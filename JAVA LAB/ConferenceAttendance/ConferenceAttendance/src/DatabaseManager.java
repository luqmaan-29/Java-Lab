import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/conference_db";
    private static final String USER = "root"; // Update with your username
    private static final String PASSWORD = "salt@20293"; // Update with your password

    // Add attendee
    public void addAttendee(Attendance attendee) throws SQLException {
        String query = "INSERT INTO attendees (full_name, email, contact_number, country) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, attendee.getFullName());
            pstmt.setString(2, attendee.getEmail());
            pstmt.setString(3, attendee.getContactNumber());
            pstmt.setString(4, attendee.getCountry());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    attendee.setId(rs.getInt(1));
                }
            }
        }
    }

    // Edit attendee
    public void editAttendee(Attendance attendee) throws SQLException {
        String query = "UPDATE attendees SET full_name = ?, email = ?, contact_number = ?, country = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, attendee.getFullName());
            pstmt.setString(2, attendee.getEmail());
            pstmt.setString(3, attendee.getContactNumber());
            pstmt.setString(4, attendee.getCountry());
            pstmt.setInt(5, attendee.getId());
            pstmt.executeUpdate();
        }
    }

    // Delete attendee
    public void deleteAttendee(int id) throws SQLException {
        String query = "DELETE FROM attendees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // Search attendees
    public List<Attendance> searchAttendees(String searchTerm) throws SQLException {
        List<Attendance> attendees = new ArrayList<>();
        String query = "SELECT * FROM attendees WHERE full_name LIKE ? OR country LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + searchTerm + "%");
            pstmt.setString(2, "%" + searchTerm + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    attendees.add(new Attendance(
                            rs.getInt("id"),
                            rs.getString("full_name"),
                            rs.getString("email"),
                            rs.getString("contact_number"),
                            rs.getString("country")));
                }
            }
        }
        return attendees;
    }

    // Generate attendee statistics
    public void generateAttendeeStatistics() throws SQLException {
        String query = "{call GetAttendeeStatistics()}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                CallableStatement cstmt = conn.prepareCall(query)) {
            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Country: " + rs.getString("country") +
                            ", Attendee Count: " + rs.getInt("attendee_count"));
                }
            }
        }
    }
}
