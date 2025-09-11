package stage2_aleeyaahmad;

/**
 * The {@code Customer} class represents a customer with a unique ID, name, and phone number.
 * It provides methods to get and set customer details.
 */
public class Customer {

    // Variables
    /** The unique customer ID. */
    private int custID;

    /** The name of the customer. */
    private String name;

    /** The phone number of the customer. */
    private String phone;

    /** Static variable to track the next customer ID. */
    static int nextID = 0;

    // Constructors

    /**
     * Default constructor that creates a new customer with no details.
     */
    public Customer(int custID, String name, String phone) {
    }

    /**
     * Constructs a new customer with the specified name and phone number.
     * The customer ID is automatically assigned based on the {@code nextID} value.
     *
     * @param name  the name of the customer
     * @param phone the phone number of the customer
     */
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.custID = nextID++; // Assign a unique ID to the customer
    }

    /**
     * Constructs a new customer with the specified name, customer ID, and phone number.
     * This constructor is mainly used for testing purposes.
     *
     * @param name   the name of the customer
     * @param custID the unique ID for the customer
     * @param phone  the phone number of the customer
     */
    public Customer(String name, int custID, String phone) {
        this.name = name;
        this.phone = phone;
        this.custID = custID; // Set the customer ID
    }

    // Methods

    /**
     * Gets the customer ID.
     *
     * @return the customer ID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name the new name of the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the customer.
     *
     * @return the phone number of the customer
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phone the new phone number of the customer
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns a string representation of the customer, including the ID, name, and phone number.
     *
     * @return a string representation of the customer
     */
    @Override
    public String toString() {
        return "Customer ID: " + custID + "\n" +
                "Name: " + name + "\n" +
                "Phone number: " + phone + "\n";
    }
}
