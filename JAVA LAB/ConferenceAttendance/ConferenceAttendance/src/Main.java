import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\n1. Add Attendee\n2. Edit Attendee\n3. Delete Attendee\n4. Search Attendee\n5. Generate Statistics\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Full Name: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Contact Number: ");
                        String contactNumber = scanner.nextLine();
                        System.out.print("Enter Country: ");
                        String country = scanner.nextLine();

                        Attendance attendee = new Attendance(0, fullName, email, contactNumber, country);
                        dbManager.addAttendee(attendee);
                        System.out.println("Attendee added with ID: " + attendee.getId());
                        break;

                    case 2:
                        System.out.print("Enter Attendee ID to edit: ");
                        int editId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Full Name: ");
                        String newFullName = scanner.nextLine();
                        System.out.print("Enter New Email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter New Contact Number: ");
                        String newContactNumber = scanner.nextLine();
                        System.out.print("Enter New Country: ");
                        String newCountry = scanner.nextLine();

                        Attendance updatedAttendee = new Attendance(editId, newFullName, newEmail, newContactNumber,
                                newCountry);
                        dbManager.editAttendee(updatedAttendee);
                        System.out.println("Attendee updated successfully.");
                        break;

                    case 3:
                        System.out.print("Enter Attendee ID to delete: ");
                        int deleteId = scanner.nextInt();
                        dbManager.deleteAttendee(deleteId);
                        System.out.println("Attendee deleted successfully.");
                        break;

                    case 4:
                        System.out.print("Enter search term (Name or Country): ");
                        String searchTerm = scanner.nextLine();
                        List<Attendance> attendees = dbManager.searchAttendees(searchTerm);
                        if (attendees.isEmpty()) {
                            System.out.println("No attendees found.");
                        } else {
                            for (Attendance a : attendees) {
                                System.out.println(a.getId() + ": " + a.getFullName() + ", " + a.getEmail() + ", "
                                        + a.getCountry());
                            }
                        }
                        break;

                    case 5:
                        dbManager.generateAttendeeStatistics();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}
