// OOP: Inheritance - Manager IS-A Employee
public class Manager extends Employee {
    private int teamSize;

    public Manager(int employeeId, String name, double salary, int teamSize) {
        super(employeeId, name, salary); // Calls parent constructor
        this.teamSize = teamSize;
    }

    // OOP: Polymorphism - Method Overriding
    @Override
    public double calculateAnnualBonus() {
        // Custom bonus calculation logic for Manager
        return (getSalary() * 0.10) + (teamSize * 500);
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call parent method to show base details
        System.out.println("  Role: Manager, Team Size: " + teamSize);
    }
}
