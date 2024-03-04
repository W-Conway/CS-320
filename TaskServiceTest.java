import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskServiceTest {
    private TaskService service;

    @Before
    public void setUp() {
        service = new TaskService();
    }

    @Test
    public void testAddTaskValid() {
        Task task = new Task("1", "Task 1", "Description of Task 1");
        service.addTask(task);
        assertNotNull(service);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskDuplicateId() {
        Task task1 = new Task("1", "Task 1", "Description of Task 1");
        Task task2 = new Task("1", "Task 2", "Description of Task 2");
        service.addTask(task1);
        service.addTask(task2); // This should throw an exception
    }

    @Test
    public void testDeleteTaskValid() {
        Task task = new Task("2", "Task 2", "Description of Task 2");
        service.addTask(task);
        service.deleteTask("2");
        // Attempting to delete again to verify it's removed
        try {
            service.deleteTask("2");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Task ID does not exist.", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteTaskInvalidId() {
        service.deleteTask("nonexistent");
    }

    @Test
    public void testUpdateTaskValid() {
        Task task = new Task("3", "Task 3", "Description of Task 3");
        service.addTask(task);
        service.updateTask("3", "Updated Task 3", "Updated Description");
        Task updatedTask = service.getTask("3"); // Assuming getTask is implemented for testing
        assertEquals("Updated Task 3", updatedTask.getName());
        assertEquals("Updated Description", updatedTask.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskInvalidId() {
        service.updateTask("nonexistent", "Name", "Description");
    }
}
