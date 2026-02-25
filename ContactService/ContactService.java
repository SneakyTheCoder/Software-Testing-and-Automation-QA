package ContactService;

import java.util.HashMap;
import java.util.Map;

/**
 * ContactService manages a collection of Contact objects.
 * Provides functionality to add, delete, and update contacts.
 */
public class ContactService {
    // In-memory data structure to store contacts
    private final Map<String, Contact> contacts;

    /**
     * Constructor initializes the contact storage
     */
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    /**
     * Adds a new contact with a unique ID
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        String contactId = contact.getContactId();
        
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                "Contact with ID " + contactId + " already exists");
        }
        
        contacts.put(contactId, contact);
    }

    /**
     * Deletes a contact by contact ID
     */
    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                "Contact with ID " + contactId + " does not exist");
        }
        
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of a contact
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of a contact
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    /**
     * Updates the address of a contact
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact by ID
     */
    public Contact getContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                "Contact with ID " + contactId + " does not exist");
        }
        
        return contacts.get(contactId);
    }

    /**
     * Returns the number of contacts in the service
     */
    public int getContactCount() {
        return contacts.size();
    }
}