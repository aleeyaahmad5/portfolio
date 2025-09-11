package stage2_aleeyaahmad;

public class Tester extends Library {

    public static void main(String[] args) {
        // Create library object
        Library lib = new Library();

        // Add customers to Arraylist
        System.out.println("Customers are Being Created------------------------------");
        lib.customerList.add(new Customer("Kim", 1, "0412348392"));
        lib.customerList.add(new Customer("Aleeya", 2, "1427439382"));
        lib.customerList.add(new Customer("Fatima", 3, "3479289386"));
        lib.customerList.add(new Customer("Hanna", 4, "0925261976"));

        //List all customers
        lib.listAllCustomers();

        //Update customer
        System.out.println("Update Customer with ID 4------------------------------");
        lib.updateCustomerInfo(4);

        //Delete customer
        System.out.println("Delete Customer with ID 2-------------------------------");
        lib.deleteCustomerInfo(2);

        //Confirming changes
        System.out.println("Confirming Changes-------------------------------");
        lib.listAllCustomers();


        //Create book objects with assigned values
        System.out.println("Books are Being Created------------------------------");
        lib.bookList.add(new Book("The Monkey's Land", 1, "Jason Drumroll", "Available"));
        lib.bookList.add(new Book("Magic Around Us", 2, "Timothy Bacon", "Available"));
        lib.bookList.add(new Book("A Beginner's Guide to Coffee", 3,  "Bob Builder", "Unavailable"));
        lib.bookList.add(new Book("Path of Truth", 4, "Josh Knight", "Available"));

    }

    // Constructor for Library object
    public Tester() {
        // Library tester created
    }
}