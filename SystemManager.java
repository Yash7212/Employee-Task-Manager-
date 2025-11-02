import java.util.HashMap;
import java.util.PriorityQueue;

public class SystemManager {
    // DSA: HashMap for O(1) Employee Lookup
    private static HashMap<Integer, Employee> employeeMap = new HashMap<>();

    // DSA: PriorityQueue (acts as a Max Heap) for Task Scheduling
    private static PriorityQueue<Task> taskQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        System.out.println("--- Employee Management System Initialized ---");

        // 1. Setup Employees (DSA: HashMap Insertion)
        Manager m1 = new Manager(101, "Aman Sharma", 120000.0, 5);
        employeeMap.put(m1.getEmployeeId(), m1);

        // 2. Add Tasks (DSA: Max Heap/PriorityQueue Insertion)
        System.out.println("\n--- Adding Tasks to Scheduler ---");
        taskQueue.add(new Task(1, "Fix major security bug.", 5)); // Highest Priority (QMS/ISMS)
        taskQueue.add(new Task(2, "Update internal documentation.", 2));
        taskQueue.add(new Task(3, "Review QMS compliance report.", 4));
        taskQueue.add(new Task(4, "Simple UI update.", 1));

        // 3. Process Tasks (Demonstrates Max Heap property)
        System.out.println("\n--- Task Prioritization Demo (DSA: Max Heap Polling) ---");
        System.out.println("Processing tasks by priority (Highest first):");

        while (!taskQueue.isEmpty()) {
            Task nextTask = taskQueue.poll(); // DSA: Removes and returns the highest priority task (O(log n))
            System.out.println("  Processing: " + nextTask);
            // Assigning the task updates the employee's Linked List audit trail
            m1.assignTask(nextTask);
        }

        // 4. OOP and Validation Demo
        System.out.println("\n--- Polymorphism and Encapsulation Demo (OOP) ---");

        // OOP: Polymorphism in action (calls Manager's specific bonus method)
        System.out.printf("%s's Annual Bonus: $%.2f%n", m1.getName(), m1.calculateAnnualBonus());

        // OOP: Encapsulation with validation check (QMS/ISMS relevance)
        System.out.println("\nAttempting to set an invalid salary (Encapsulation check):");
        m1.setSalary(-5000.0);

        System.out.println("\n--- Final Employee Status (DSA: HashMap Lookup) ---");
        // DSA: Lookup employee in O(1) time
        Employee retrievedEmp = employeeMap.get(101);
        retrievedEmp.displayDetails();
    }
}