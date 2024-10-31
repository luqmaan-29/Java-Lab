// Base Class: Employee
class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    // Setters and Getters for basic attributes
    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getDesignation() { return designation; }

    // Method to calculate bonus (will be overridden in subclasses)
    public double calculateBonus() {
        return 0;
    }

    // Display employee information
    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }
}

// Derived Class: HourlyEmployee
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    // Setter methods with validation
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("Hourly rate must be positive.");
            this.hourlyRate = 0;
        }
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked >= 0) {
            this.hoursWorked = hoursWorked;
        } else {
            System.out.println("Hours worked cannot be negative.");
            this.hoursWorked = 0;
        }
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    // Override calculateBonus
    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.1; // 10% bonus for hourly employees
    }

    // Display info with weekly salary
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Bonus: " + calculateBonus());
    }
}

// Derived Class: SalariedEmployee
class SalariedEmployee extends Employee {
    protected double monthlySalary;  // Changed to protected to allow subclass access

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        setMonthlySalary(monthlySalary);
    }

    // Setter with validation
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Monthly salary must be positive.");
            this.monthlySalary = 0;
        }
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return monthlySalary / 4; // Assuming 4 weeks in a month
    }

    // Override calculateBonus
    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05; // 5% bonus for salaried employees
    }

    // Display info with weekly salary
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Bonus: " + calculateBonus());
    }
}

// Derived Class: ExecutiveEmployee
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        setBonusPercentage(bonusPercentage);
    }

    // Setter with validation
    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage >= 0 && bonusPercentage <= 100) {
            this.bonusPercentage = bonusPercentage;
        } else {
            System.out.println("Bonus percentage must be between 0 and 100.");
            this.bonusPercentage = 0;
        }
    }

    // Override calculateBonus using the super keyword
    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double executiveBonus = (monthlySalary * 12) * (bonusPercentage / 100); // Annual salary * bonus percentage
        return baseBonus + executiveBonus;
    }

    // Display info with weekly salary
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Executive Bonus: " + calculateBonus());
    }
}

// Main Class
public class Lab3a {
    public static void main(String[] args) {
        // Creating objects of each type
        HourlyEmployee hourlyEmployee = new HourlyEmployee(101, "Ravi Kumar", "Lab Assistant", 200.0, 40);
        SalariedEmployee salariedEmployee = new SalariedEmployee(102, "Priya Sharma", "Lecturer", 50000.0);
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(103, "Amitabh Singh", "Director", 120000.0, 10);

        // Display information and salaries
        System.out.println("Hourly Employee Information:");
        hourlyEmployee.displayInfo();

        System.out.println("\nSalaried Employee Information:");
        salariedEmployee.displayInfo();

        System.out.println("\nExecutive Employee Information:");
        executiveEmployee.displayInfo();
    }
}
