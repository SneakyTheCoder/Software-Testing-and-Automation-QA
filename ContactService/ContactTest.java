package ContactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Contact class
 */
public class ContactTest {

    // Test successful contact creation
    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Kyle", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567891", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Contact ID Tests
    @Test
    public void testContactIdNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Kyle", "Doe", "1234567891", "123 Main St");
        });
    }

    @Test
    public void testContactIdNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Kyle", "Doe", "1234567891", "123 Main St");
        });
    }

    @Test
    public void testContactIdExactly10Characters() {
        Contact contact = new Contact("1234567890", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }

    // First Name Tests
    @Test
    public void testFirstNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567891", "123 Main St");
        });
    }

    @Test
    public void testFirstNameNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "KyleKyleKyle", "Doe", "1234567891", "123 Main St");
        });
    }

    @Test
    public void testFirstNameExactly10Characters() {
        Contact contact = new Contact("123", "KyleKyleJo", "Doe", 
                                      "1234567891", "123 Main St");
        assertEquals("KyleKyleJo", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameNull() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("KyleKyleKyle");
        });
    }

    // Last Name Tests
    @Test
    public void testLastNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", null, "1234567891", "123 Main St");
        });
    }

    @Test
    public void testLastNameNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", "DoeDoeDoeD", "1234567891", "123 Main St");
        });
    }

    @Test
    public void testLastNameExactly10Characters() {
        Contact contact = new Contact("123", "Kyle", "DoeDoeDoe9", 
                                      "1234567891", "123 Main St");
        assertEquals("DoeDoeDoe9", contact.getLastName());
    }

    @Test
    public void testSetLastNameSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetLastNameNull() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    public void testSetLastNameTooLong() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("SmithSmithS");
        });
    }

    // Phone Tests
    @Test
    public void testPhoneNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", "Doe", null, "123 Main St");
        });
    }

    @Test
    public void testPhoneExactly10Digits() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertEquals("1234567891", contact.getPhone());
    }

    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", "Doe", "555123456", "123 Main St");
        });
    }

    @Test
    public void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", "Doe", "12345678918", "123 Main St");
        });
    }

    @Test
    public void testPhoneNotNumeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", "Doe", "555-123-456", "123 Main St");
        });
    }

    @Test
    public void testSetPhoneSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        contact.setPhone("5559876543");
        assertEquals("5559876543", contact.getPhone());
    }

    @Test
    public void testSetPhoneNull() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    @Test
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
    }

    // Address Tests
    @Test
    public void testAddressNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", "Doe", "1234567891", null);
        });
    }

    @Test
    public void testAddressNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Kyle", "Doe", "1234567891", 
                       "1234567890123456789012345678901");
        });
    }

    @Test
    public void testAddressExactly30Characters() {
        String address = "123456789012345678901234567890";
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", address);
        assertEquals(address, contact.getAddress());
    }

    @Test
    public void testSetAddressSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    public void testSetAddressNull() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    public void testSetAddressTooLong() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "1234567891", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    }
}