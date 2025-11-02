public class Task implements Comparable<Task> {
    private final int taskId;
    private final String description;
    private final int priorityLevel; // Higher number = Higher Priority (e.g., 1 to 5)

    public Task(int taskId, String description, int priorityLevel) {
        this.taskId = taskId;
        this.description = description;
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Priority: " + priorityLevel + ", Desc: " + description;
    }

    // DSA: Max Heap Logic. We reverse the natural order (Min Heap) 
    // to make the Task with the highest priorityLevel come first.
    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priorityLevel, this.priorityLevel);
    }
}