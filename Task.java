public class Task {
    private final String taskId; // Unique and immutable
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be null and must be 10 characters or less.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null and must be 20 characters or less.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be 50 characters or less.");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null and must be 20 characters or less.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be 50 characters or less.");
        }
        this.description = description;
    }
}
