import java.util.LinkedList;

// OOP: Abstraction - Base class for all employee types
public abstract class Employee {
    // OOP: Encapsulation - Private fields
    private final int employeeId;
    private final String name;
    private double salary;

    // DSA: Linked List to track task history/audit trail
    private LinkedList<Task> taskHistory;

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.taskHistory = new LinkedList<>();
    }

    // OOP: Abstraction - Abstract method for role-specific bonus calculation
    public abstract double calculateAnnualBonus();

    // OOP: Encapsulation - Getter methods
    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    // FIX: This method is crucial for SystemManager to access the ID (The missing piece)
    public int getEmployeeId() {
        return employeeId;
    }

    // OOP: Encapsulation - Setter with QMS/ISMS-relevant validation
    public boolean setSalary(double newSalary) {
        if (newSalary < 0) {
            System.out.println("ERROR: Salary must be positive. QMS/Security check failed.");
            return false;
        }
        this.salary = newSalary;
        return true;
    }

    public void assignTask(Task t) {
        taskHistory.add(t); // DSA: Add task to the end of the Linked List
        System.out.println(name + " assigned task: " + t.getDescription());
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: $" + salary);
        System.out.println("  Total Tasks Assigned (Audit Trail Length): " + taskHistory.size());
    }
}