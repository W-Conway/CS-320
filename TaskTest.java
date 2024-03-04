import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
    private Task task;

    @Before
    public void setUp() {
        task = new Task("123", "Initial Task", "This is a test description.");
    }

    @Test
    public void testTaskConstructorValidInput() {
        assertEquals("123", task.getTaskId());
        assertEquals("Initial Task", task.getName());
        assertEquals("This is a test description.", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdTooLong() {
        new Task("12345678901", "Valid Name", "Valid Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdNull() {
        new Task(null, "Valid Name", "Valid Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameTooLong() {
        new Task("123", "This name is definitely more than twenty characters long", "Valid Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameNull() {
        new Task("123", null, "Valid Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionTooLong() {
        new Task("123", "Valid Name", "This description is definitely more than fifty characters long. It keeps going and going and going.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionNull() {
        new Task("123", "Valid Name", null);
    }

    @Test
    public void testUpdateNameValid() {
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNameInvalid() {
        task.setName(null);
    }

    @Test
    public void testUpdateDescriptionValid() {
        task.setDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateDescriptionInvalid() {
        task.setDescription("");
    }
}
