package stage2_aleeyaahmad;

// Swing components for the GUI
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

// AWT components for layout and color
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

// Action listener and event handling
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Data structure for storing customers
import java.util.ArrayList;

public class AddCustomerForm extends JFrame implements ActionListener {
    // Components for adding customers
    private JTextField nameField;
    private JTextField custidField;
    private JTextField phoneField;
    private JButton addButton;
    private JButton clearButton;

    // Components for displaying customers
    private JTextArea customerListArea;
    private JButton displayButton;

    // List to store customers
    private ArrayList<Customer> customers;
    private final DatabaseConnector dbConnector;

    // Constructor
    public AddCustomerForm() {
        dbConnector = new DatabaseConnector();
        customers = new ArrayList<>();
        createUI();
    }

    private void createUI() {
        // Frame settings
        setTitle("Library Management System - Customer Management");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create the "Add Customer" tab
        JPanel addCustomerPanel = createAddCustomerPanel();
        tabbedPane.addTab("Add Customer", addCustomerPanel);

        // Create the "Display Customers" tab
        JPanel displayCustomerPanel = createDisplayCustomerPanel();
        tabbedPane.addTab("Display Customers", displayCustomerPanel);

        // Add tabbed pane to the frame
        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createAddCustomerPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(new Color(220, 220, 240));

        // Add labels and text fields
        JLabel custidLabel = new JLabel("Customer ID:");
        custidLabel.setForeground(Color.DARK_GRAY);
        inputPanel.add(custidLabel);
        custidField = new JTextField();
        inputPanel.add(custidField);

        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setForeground(Color.DARK_GRAY);
        inputPanel.add(nameLabel);
        nameField = new JTextField();
        inputPanel.add(nameField);

        JLabel phoneLabel = new JLabel("Customer Phone Number:");
        phoneLabel.setForeground(Color.DARK_GRAY);
        inputPanel.add(phoneLabel);
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        // Create buttons and add action listeners
        addButton = new JButton("Add");
        addButton.setBackground(new Color(135, 206, 235));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        inputPanel.add(clearButton);

        return inputPanel;
    }

    private JPanel createDisplayCustomerPanel() {
        JPanel displayPanel = new JPanel(new BorderLayout());

        // Text area to display customer list
        customerListArea = new JTextArea();
        customerListArea.setEditable(false);
        customerListArea.setBackground(new Color(245, 245, 245));
        customerListArea.setForeground(Color.DARK_GRAY);

        displayButton = new JButton("Display Customers");
        displayButton.setBackground(new Color(135, 206, 235));
        displayButton.setForeground(Color.WHITE);
        displayButton.addActionListener(this);

        displayPanel.add(displayButton, BorderLayout.NORTH);
        displayPanel.add(new JScrollPane(customerListArea), BorderLayout.CENTER); // Add scroll pane

        return displayPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addCustomer();
        } else if (e.getSource() == displayButton) {
            displayCustomers();
        } else if (e.getSource() == clearButton) {
            clearInputFields();
        }
    }

    private void addCustomer() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String custid = custidField.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || custid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer ID, name, and phone number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for duplicates in the local list
        if (isDuplicate(name, phone, custid)) {
            JOptionPane.showMessageDialog(this, "Duplicate customer detected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new Customer
        Customer newCustomer = new Customer(name, phone);

        // Add the customer to the database
        if (dbConnector.addCustomer(newCustomer)) {
            customers.add(newCustomer); // Also add to the local list
            nameField.setText(""); // Clear input field after adding
            phoneField.setText("");
            custidField.setText("");
            JOptionPane.showMessageDialog(this, "Customer added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add customer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isDuplicate(String name, String phone, String custid) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name) ||
                    customer.getPhone().equals(phone) ||
                    String.valueOf(customer.getCustID()).equals(custid)) {
                return true;
            }
        }
        return false;
    }

    private void displayCustomers() {
        customers = dbConnector.getCustomers(); // Retrieve customers from the database
        customerListArea.setText(""); // Clear previous content
        if (customers.isEmpty()) {
            customerListArea.setText("No customers found.");
            return;
        }

        for (Customer customer : customers) {
            customerListArea.append(customer.toString() + "\n"); // Append each customer to the text area
        }
    }

    private void clearInputFields() {
        nameField.setText("");
        phoneField.setText("");
        custidField.setText("");
        JOptionPane.showMessageDialog(this, "Input fields cleared.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new AddCustomerForm(); // Create an instance of the form
    }
}
