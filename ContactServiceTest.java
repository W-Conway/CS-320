import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        service.addContact("1234567890", "John", "Smith", "1234567890", "123 Main St");
        assertNotNull(service.getContact("1234567890"));
    }

    @Test
    void testAddContactWithExistingID() {
        service.addContact("1234567890", "John", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () ->
                service.addContact("1234567890", "Jane", "Doe", "0987654321", "456 State St"));
    }

    @Test
    void testDeleteContact() {
        service.addContact("1234567890", "John", "Smith", "1234567890", "123 Main St");
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test
    void testDeleteNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact("nonexistent"));
    }

    @Test
    void testUpdateContact() {
        service.addContact("1234567890", "John", "Smith", "1234567890", "123 Main St");
        service.updateContact("1234567890", "Jane", "Doe", "0987654321", "456 State St");
        Contact updated = service.getContact("1234567890");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Doe", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 State St", updated.getAddress());
    }

    @Test
    void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateContact("nonexistent", "Jane", "Doe", "0987654321", "456 State St"));
    }

}
