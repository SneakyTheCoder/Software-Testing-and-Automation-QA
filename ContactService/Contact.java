package ContactService;

/**
 * Contact class represents a contact with unique ID, name, phone, and address.
 */
public class Contact {
    private final String contactId;  // Immutable unique identifier
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructor for Contact object
     */
    public Contact(String contactId, String firstName, String lastName, 
                   String phone, String address) {
        // Validate contactId
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                "Contact ID must not be null and must be 10 characters or less");
        }
        
        // Validate and set firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must not be null and must be 10 characters or less");
        }
        
        // Validate and set lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must not be null and must be 10 characters or less");
        }
        
        // Validate phone - must be exactly 10 digits
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "Phone must not be null and must be exactly 10 digits");
        }
        
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must not be null and must be 30 characters or less");
        }
        
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters (no setter for contactId since it is unchangeable)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must not be null and must be 10 characters or less");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must not be null and must be 10 characters or less");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "Phone must not be null and must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must not be null and must be 30 characters or less");
        }
        this.address = address;
    }
}