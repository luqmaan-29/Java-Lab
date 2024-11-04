// Base Class: Employee
class Employee {
    int employeeId;
    String employeeName;
    String designation;

    public Employee(int id, String name, String desig) {
        employeeId = id;
        employeeName = name;
        designation = desig;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }
}

// Derived Class: HourlyEmployee
class HourlyEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    public HourlyEmployee(int id, String name, String desig, double rate, int hours) {
        super(id, name, desig);
        hourlyRate = rate;
        hoursWorked = hours;
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    // Display employee info along with salary
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}

// Derived Class: SalariedEmployee
class SalariedEmployee extends Employee {
    double monthlySalary;

    public SalariedEmployee(int id, String name, String desig, double salary) {
        super(id, name, desig);
        monthlySalary = salary;
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return monthlySalary / 4; // Assuming 4 weeks in a month
    }

    // Display employee info along with salary
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}

// Derived Class: ExecutiveEmployee
class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    public ExecutiveEmployee(int id, String name, String desig, double salary, double bonus) {
        super(id, name, desig, salary);
        bonusPercentage = bonus;
    }

    // Calculate total bonus
    public double calculateBonus() {
        return (monthlySalary * 12) * (bonusPercentage / 100);
    }

    // Display employee info along with salary and bonus
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Annual Bonus: " + calculateBonus());
    }
}

// Main Class
public class Lab3a {
    public static void main(String[] args) {
        HourlyEmployee hourlyEmp = new HourlyEmployee(101, "Ravi Kumar", "Lab Assistant", 200.0, 40);
        SalariedEmployee salariedEmp = new SalariedEmployee(102, "Priya Sharma", "Lecturer", 50000.0);
        ExecutiveEmployee executiveEmp = new ExecutiveEmployee(103, "Amitabh Singh", "Director", 120000.0, 10);

        System.out.println("Hourly Employee Information:");
        hourlyEmp.displayInfo();

        System.out.println("\nSalaried Employee Information:");
        salariedEmp.displayInfo();

        System.out.println("\nExecutive Employee Information:");
        executiveEmp.displayInfo();
    }
}
