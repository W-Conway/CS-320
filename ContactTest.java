import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Smith", "1234567890", "123 Main St");
        assertNotNull(contact);
    }

    @Test
    void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "Johnathan", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "FizzBuzz", "1234567890", "123 Main St"));
    }

    @Test
    void testPhoneNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith", "123456789", "123 Main St"));
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith", "1234567890", "123 Main Street, Springfield, Anytown"));
    }

}