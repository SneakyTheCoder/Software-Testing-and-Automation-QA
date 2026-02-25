package ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ContactService class
 */
public class ContactServiceTest {
    
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    // Add Contact Tests
    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertEquals(1, contactService.getContactCount());
        assertEquals(contact, contactService.getContact("123"));
    }

    @Test
    public void testAddMultipleContacts() {
        Contact contact1 = new Contact("123", "Kyle", "Doe", 
                                       "5551234567", "123 Main St");
        Contact contact2 = new Contact("456", "Jane", "Smith", 
                                       "5559876543", "456 Oak Ave");
        Contact contact3 = new Contact("789", "Bob", "Kyleson", 
                                       "5555555555", "789 Pine Rd");
        
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        contactService.addContact(contact3);
        
        assertEquals(3, contactService.getContactCount());
        assertEquals(contact1, contactService.getContact("123"));
        assertEquals(contact2, contactService.getContact("456"));
        assertEquals(contact3, contactService.getContact("789"));
    }

    @Test
    public void testAddContactWithDuplicateId() {
        Contact contact1 = new Contact("123", "Kyle", "Doe", 
                                       "5551234567", "123 Main St");
        Contact contact2 = new Contact("123", "Jane", "Smith", 
                                       "5559876543", "456 Oak Ave");
        
        contactService.addContact(contact1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
        
        // Verify only first contact exists
        assertEquals(1, contactService.getContactCount());
        assertEquals("Kyle", contactService.getContact("123").getFirstName());
    }

    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    // Delete Contact Tests
    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertEquals(1, contactService.getContactCount());
        
        contactService.deleteContact("123");
        
        assertEquals(0, contactService.getContactCount());
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("123");
        });
    }

    @Test
    public void testDeleteNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact(null);
        });
    }

    // Update First Name Tests
    @Test
    public void testUpdateFirstNameSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateFirstName("123", "Jane");
        
        assertEquals("Jane", contactService.getContact("123").getFirstName());
    }

    @Test
    public void testUpdateFirstNameInvalidValue() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("123", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("123", "KyleKyleKyle");
        });
    }

    // Update Last Name Tests
    @Test
    public void testUpdateLastNameSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateLastName("123", "Smith");
        
        assertEquals("Smith", contactService.getContact("123").getLastName());
    }

    // Update Phone Tests
    @Test
    public void testUpdatePhoneSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updatePhone("123", "5559876543");
        
        assertEquals("5559876543", contactService.getContact("123").getPhone());
    }

    @Test
    public void testUpdatePhoneInvalidValue() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("123", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("123", "123");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("123", "12345678901");
        });
    }

    // Update Address Tests
    @Test
    public void testUpdateAddressSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateAddress("123", "456 Oak Ave");
        
        assertEquals("456 Oak Ave", contactService.getContact("123").getAddress());
    }

    @Test
    public void testUpdateAddressInvalidValue() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("123", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("123", "1234567890123456789012345678901");
        });
    }

    // Get Contact Tests
    @Test
    public void testGetContactSuccess() {
        Contact contact = new Contact("123", "Kyle", "Doe", 
                                      "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        Contact retrieved = contactService.getContact("123");
        
        assertNotNull(retrieved);
        assertEquals(contact, retrieved);
    }

    @Test
    public void testGetNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("999");
        });
    }

    @Test
    public void testGetContactNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact(null);
        });
    }
}