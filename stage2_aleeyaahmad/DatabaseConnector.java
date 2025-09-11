package stage2_aleeyaahmad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseConnector {
    // Constants for database connection
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    // Constructor to establish connection
    public DatabaseConnector() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Error establishing database connection:");
            e.printStackTrace(); // Print the exception for debugging
        }
    }

    // Method to check for duplicate customers by name or phone
    public boolean isDuplicateCustomer(String name, String phone, int custID) {
        String query = "SELECT COUNT(*) FROM customer WHERE (name = ? OR phone = ?) AND custID != ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setInt(3, custID); // Exclude the current customer ID from the check
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Return true if a duplicate exists
            }
        } catch (SQLException e) {
            System.err.println("Error checking for duplicate customer:");
            e.printStackTrace();
        }
        return false;
    }

    // Method to add a customer to the database
    public boolean addCustomer(Customer customer) {
        String query = "INSERT INTO customer (name, phone) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPhone());
            pstmt.executeUpdate();
            return true; // Customer added successfully
        } catch (SQLException e) {
            System.err.println("Error adding customer:");
            e.printStackTrace();
            return false; // Failed to add customer
        }
    }

    // Method to retrieve all customers from the database
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";

        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("custID");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                customers.add(new Customer(name, id, phone));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving customers:");
            e.printStackTrace();
        }
        return customers; // Return the list of customers
    }

    // Method to close the database connection
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection:");
            e.printStackTrace();
        }
    }
}
