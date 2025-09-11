package stage2_aleeyaahmad;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    //make array list to store customer, book, borrowing class
    protected ArrayList<Customer> customerList = new ArrayList<>();
    protected ArrayList<Borrowing> borrowingList = new ArrayList<>();
    protected ArrayList<Book> bookList = new ArrayList<>();


    //main class - where I run the program
    public static void main(String[] args) {
        Library lib = new Library(); //create a library object so that we can use the methods
        lib.run(); // run the program
    }

    //making the run method
    public void run() {
        boolean programDone = false; //flag to keep the while loop running
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        // when program is not done, then loop runs
        while (!programDone) {
            System.out.println("\n-----------------------------\n" +
                    " Options" +
                    "\n-----------------------------\n" +
                    "|  Customer Options         |\n" +
                    "|  1. Add Customer          |\n" +
                    "|  2. List All Customers    |\n" +
                    "|  3. Search Customer Info  |\n" +
                    "|  4. Update Customer Info  |\n" +
                    "|  5. Delete Customer Info  |\n" + 
                    "|  ------------------------ |\n" +
                    "|  Book Options             |\n" +
                    "|  6. Add Book to Library   |\n" +
                    "|  7. List Books            |\n" +
                    "|  8. Search Book           |\n" +

                    "|  ------------------------ |\n" +
                    "|  Borrow Options           |\n" +
                    "|  9. Borrow Book           |\n" +
                    "|  10. Return Book          |\n" +
                    "|  11. List Borrowings      |\n" +
                    "|  12. Search Borrowing     |\n" +
                    "|  ------------------------ |\n" +
                    "|  13. Exit                 |\n" +
                    "|--                       --|\n" +
                    "   Choose an option:     ");

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    listAllCustomers();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    updateCustomerInfo();
                    break;
                case 5:
                    deleteCustomerInfo();
                    break;
                case 6:
                    addBook();
                    break;
                case 7:
                    listBooks();
                    break;
                case 8:
                    searchBook();
                    break;
                case 9:
                    borrowBook();
                    break;
                case 10:
                    returnBook();
                    break;
                case 11:
                    listBorrowings();
                    break;
                case 12:
                    searchBorrowing();
                    break;
                case 13:
                    programDone = true;
                    break;
                default:
                    System.out.println("Invalid option: " + choice + " Please enter a number between 1-13!");
            }

        }

    }

    // Methods --------------------------------------------------------------

    //CUSTOMER METHODS

    //ADD CUSTOMER ----------------------------------------------------------------------------------------------------1
    public void addCustomer() {
        Scanner scan = new Scanner(System.in); //create scanner
        String name; //declare variable to assign name
        String phone;

        System.out.println("Enter Name: ");
        name = scan.nextLine(); //assign variable with name that user inputs
        System.out.println("Enter Phone Number: ");
        phone = scan.next();
        Customer cust = new Customer(name, phone); //create customer with name and phone

        customerList.add(cust);

        // Display the customer ID after adding the customer
        System.out.println("Customer added with ID: " + cust.getCustID());
    }

    //LIST ALL CUSTOMERS ----------------------------------------------------------------------------------------------2
    public void listAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("There are no customers to display.");
        } else {
            //  Iterate through the customerList to find the customer
            System.out.println("List of All Customers ");
            System.out.println("-----------------------");
            for (Customer cust : customerList) {
                System.out.println(cust);
                System.out.println("-----------------------");
            }
        }
    }

    //SEARCH CUSTOMER -------------------------------------------------------------------------------------------------3
    public void searchCustomer() {
        Scanner scan = new Scanner(System.in); //create scanner
        System.out.println("\n-------------------------------\n" +
                "  Press <3                         " +
                "\n-------------------------------\n" +
                "| 1. To Search by NAME        |\n" +
                "| 2. To Search by CUSTOMER ID |\n" +
                "| 3. To Search by PHONE NUMB  |\n" +
                "| 4. To EXIT                  |\n" +
                "     Choose an option:     ");
        int choice = scan.nextInt();
        scan.nextLine();  // Clear buffer

        switch (choice) {
            case 1:
                System.out.println("Enter Name: ");
                String custName = scan.nextLine();
                for (Customer cust : customerList) {
                    if (cust.getName().equalsIgnoreCase(custName)) {
                        // Check if the name of the customer (cust.getName()) matches the name entered by the user (custName)
                        // The comparison is case-insensitive, so "John" and "john" would be considered equal
                        System.out.println("-----------------------");
                        System.out.println("Customers Info ");
                        System.out.println("-----------------------");
                        System.out.println(cust);
                    }
                }
                break;
            case 2:
                System.out.println("Enter Customer ID: ");
                int custID = scan.nextInt();
                for (Customer cust : customerList) {
                    if (cust.getCustID() == custID) {
                        System.out.println("-----------------------");
                        System.out.println("Customers Info ");
                        System.out.println("-----------------------");
                        System.out.println(cust);
                    }
                }
                break;
            case 3:
                // Search for a customer by phone number
                System.out.println("Enter Customer Phone Number: ");
                String custPhone = scan.next();

                boolean customerFound = false; // Flag to check if the customer is found
                for (Customer cust : customerList) {
                    if (cust.getPhone().equals(custPhone)) {
                        System.out.println("-----------------------");
                        System.out.println("Customers Info ");
                        System.out.println("-----------------------");
                        System.out.println(cust);
                        customerFound = true; // Set the flag to true if the customer is found
                        break; // Exit the loop once the customer is found
                    }
                }
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }



    //UPDATE CUSTOMER INFO --------------------------------------------------------------------------------------------4
    public void updateCustomerInfo() {
        Scanner scan = new Scanner(System.in); //create scanner

        //enter custID to update name or phone number
        System.out.println("Enter Customer ID: ");
        int custID = scan.nextInt();

        for (Customer cust : customerList) {
            if (cust.getCustID() == custID) {

                System.out.println("\n-------------------------------\n" +
                        "  Press <3                         " +
                        "\n-------------------------------\n" +
                        "| 1. To Change NAME           |\n" +
                        "| 2. To Change PHONE NUMBER   |\n" +
                        "| 3. To EXIT                  |\n" +
                        "     Choose an option:     ");

                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter Updated Name: ");
                        String name = scan.nextLine();
                        cust.setName(name);
                        //display updated customer info

                        break;
                    case 2:
                        System.out.println("Enter Updated Phone Number: ");
                        String phone = scan.next();
                        cust.setPhone(phone);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Error!!! Please enter one of the following numbers [1,2,3]!");
                }
            }
        }
    }

    //UPDATE CUSTOMER INFO (TESTER)------------------------------------------------------------------------------------
    public void updateCustomerInfo(int custID) {
        Scanner scan = new Scanner(System.in); //create scanner

        for (Customer cust : customerList) {
            if (cust.getCustID() == custID) {

                System.out.println("\n-------------------------------\n" +
                        "  Press <3                         " +
                        "\n-------------------------------\n" +
                        "| 1. To Change NAME           |\n" +
                        "| 2. To Change PHONE NUMBER   |\n" +
                        "| 3. To EXIT                  |\n" +
                        "     Choose an option:     ");

                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter Updated Name: ");
                        String name = scan.nextLine();
                        cust.setName(name);
                        //display updated customer info

                        break;
                    case 2:
                        System.out.println("Enter Updated Phone Number: ");
                        String phone = scan.next();
                        cust.setPhone(phone);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Error!!! Please enter one of the following numbers [1,2,3]!");
                }
            }
        }
    }

    //DELETE CUSTOMER INFO --------------------------------------------------------------------------------------------5
    public void deleteCustomerInfo() {
        Scanner scan = new Scanner(System.in); //create scanner

        System.out.println("Enter Customer ID to Remove Customer Info: ");
        int custID = scan.nextInt();

        for (Customer cust : customerList) {
            // Check if the customer ID of the current cust object matches the user-input ID
            if (cust.getCustID() == custID) {
                customerList.remove(cust);
                System.out.println("Customer with ID " + custID + " has been removed.");
                break;
            }
        }
    }

    //DELETE CUSTOMER INFO (TESTER)------------------------------------------------------------------------------------
    public void deleteCustomerInfo(int custID) {
        Scanner scan = new Scanner(System.in); //create scanner

        for (Customer cust : customerList) {
            // Check if the customer ID of the current cust object matches the user-input ID
            if (cust.getCustID() == custID) {
                customerList.remove(cust);
                System.out.println("Customer with ID " + custID + " has been removed.");
                break;
            }
        }
    }

    //-----------------------------------------------------------------------

    //BOOK METHODS

    //ADD BOOK --------------------------------------------------------------------------------------------------------6
    public void addBook() {
        Scanner scan = new Scanner(System.in); //create scanner
        String title;
        String author;

        System.out.println("Enter Book Title: ");
        title = scan.nextLine();
        System.out.println("Enter Author Name: ");
        author = scan.nextLine();
        Book bk = new Book(title, author, "Available");

        bookList.add(bk);

        System.out.println("Book added with ID: " + bk.getBookID());
    }

    //LIST BOOKS ------------------------------------------------------------------------------------------------------7
    public void listBooks() {
        Scanner scan = new Scanner(System.in); // Create scanner

        // Check if the book list is empty
        if (bookList.isEmpty()) {
            System.out.println("No Books Found in the Library.");
        } else {
            // Iterate through the bookList to display all books
            for (Book bok : bookList) {
                System.out.println(bok);
            }

            // Menu for available or unavailable books
            System.out.println("\n----------------------------------\n" +
                    "  Press <3                         " +
                    "\n----------------------------------\n" +
                    "| 1. To Show Available Books     |\n" +
                    "| 2. To Show Unavailable Books   |\n" +
                    "| 3. To EXIT                     |\n" +
                    "     Choose an option:     ");

            int userInput = scan.nextInt();
            boolean bookFound = false;

            switch (userInput) {
                case 1:
                    // Show available books
                    for (Book bok : bookList) {
                        if (bok.isAvailable().equals("Available")) {
                            System.out.println(bok);
                            bookFound = true;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("No Books are Available");
                    }
                    break;
                case 2:
                    // Show unavailable books
                    for (Book bok : bookList) {
                        if (bok.isAvailable().equals("Unavailable")) {
                            System.out.println(bok);
                            bookFound = true;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("No Books are Unavailable");
                    }
                    break;
                case 3:
                    // Exit
                    break;
                default:
                    System.out.println("Error: please enter one of the following numbers [1, 2, 3]!");
            }
        }
    }

    //SEARCH BOOK -----------------------------------------------------------------------------------------------------8
    public void searchBook() {
        Scanner scan = new Scanner(System.in); //create scanner

        if (bookList.isEmpty()) {
            System.out.println("Currently Library is Empty.");
        } else {

            // find book via title, author, bookID
            System.out.println("\n------------------------------------\n" +
                    "  Press <3                         " +
                    "\n------------------------------------\n" +
                    "| 1. To Search for Book by TITLE   |\n" +
                    "| 2. To Search for Book by AUTHOR  |\n" +
                    "| 3. To Search for Book by BOOK ID |\n" +
                    "| 3. To EXIT                       |\n" +
                    "     Choose an option:     ");

            int userInput = scan.nextInt();
            scan.nextLine();

            boolean bookFound = false;

            switch (userInput) {
                case 1:
                    System.out.println("Enter Book Title: ");
                    String title = scan.nextLine();

                    for (Book bok : bookList) {
                        if (bok.getTitle().equals(title)) {
                            System.out.println(bok);
                            bookFound = true;
                        }
                    }

                    if (!bookFound) {
                        System.out.println("No Book with \"" + title + "\" found.");
                    }

                    break;
                case 2:
                    System.out.println("Enter Author Name: ");
                    String author = scan.nextLine();

                    for (Book bok : bookList) {
                        if (bok.getAuthor().equals(author)) {
                            System.out.println(bok);
                            bookFound = true;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("No Book with \"" + author + "\" found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Book ID: ");
                    int bookID = scan.nextInt();

                    for (Book bok : bookList) {
                        if (bok.getBookID() == (bookID)) {
                            System.out.println(bok);
                            bookFound = true;
                            break;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("No Book with \"" + bookID + "\" found.");
                        }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error!!! Please enter one of the following numbers [1,2,3,4]!");
            }
        }
    }

        //-----------------------------------------------------------------------

        //BORROWING METHODS

        //BORROW BOOK -------------------------------------------------------------------------------------------------9
        public void borrowBook () {
            Scanner scan = new Scanner(System.in); //create scanner
            int custID;
            int bookID;
            String borrowDate;

            System.out.println("Enter Customer ID: ");
            custID = scan.nextInt();
            System.out.println("Enter Book ID: ");
            bookID = scan.nextInt();
            Borrowing borrow = new Borrowing(custID, bookID);

            boolean bookFound = false;

            for (Book bok : bookList) {
                if (bookID == bok.getBookID()) {
                    if (bok.isAvailable().equals("Available")) {
                        borrowingList.add(borrow);
                        bok.setAvailability("Unavailable");
                        // Display the borrowing details after adding the customer
                        System.out.println("Book borrowed with ID: " + borrow.getBorrowingID());
                        bookFound = true;
                    } else {
                        System.out.println("Book is Unavailable!!!");
                        bookFound = true;
                    }
                }
            }

            if (!bookFound) {
                System.out.println("No book found with the provided Book ID.");
            }

        }

        //RETURN BOOK ------------------------------------------------------------------------------------------------10
        public void returnBook () {
            Scanner scan = new Scanner(System.in); //create scanner
            int bookID;
            int borrowingID;

            System.out.println("Enter Book ID: ");
            bookID = scan.nextInt();
            System.out.println("Enter Borrowing ID: ");
            borrowingID = scan.nextInt();

            // Iterate through the borrowingList to find the matching Borrowing object
            //as the loop runs, each borrow object represents each item in borrowingList
            for (Borrowing borrow : borrowingList) {
                // Check if the borrowing ID of the current Borrowing object matches the user-input ID
                if (borrow.getBorrowingID() == borrowingID) {

                    // Search for the book with the given bookID in the bookList
                    Book bok = findBook(bookID);

                    // set availability of the book
                    bok.setAvailability("Available");

                    // remove borrowing from the borrowing list
                    borrowingList.remove(borrow);
                    System.out.println("Book Successfully Returned!!!");
                    // exit the loop after finding and removing the borrowing
                    break;
                }
            }
        }
        // ----------- SUB CATEGORY - Method to search for book based on BookID
        private Book findBook ( int bookID){
            // Iterate through the bookList to find the book with the given bookID
            for (Book bok : bookList) {
                // Check if the bookID of the current Book object matches the given bookID
                if (bok.getBookID() == bookID) {
                    // return the found book
                    return bok;
                }
            }
            // return null if no book is found with the given bookID
            return null;
        }

        //LIST BORROWINGS --------------------------------------------------------------------------------------------11
        public void listBorrowings () {
            Scanner scan = new Scanner(System.in); //create scanner

            // Check if the borrowingList is empty
            if (borrowingList.isEmpty()) {
                System.out.println("No books currently borrowed.");
            } else {
                // Iterate through the borrowingList to display all borrowings
                System.out.println("-----------------------");
                System.out.println("Books Borrowed");
                System.out.println("-----------------------");
                for (Borrowing borrow : borrowingList) {
                    System.out.println(borrow);
                }
            }
        }

        //SEARCH BORROWING -------------------------------------------------------------------------------------------12
        public void searchBorrowing () {
            Scanner scan = new Scanner(System.in); //create scanner

            // customer id, borrowing id, book id
            System.out.println("\n---------------------------------------------------\n" +
                    "  Press <3                         " +
                    "\n---------------------------------------------------\n" +
                    "| 1. To Search for Borrowing Info by Customer ID  |\n" +
                    "| 2. To Search for Borrowing Info by Borrowing ID |\n" +
                    "| 3. To Search for Borrowing Info by BookID       |\n" +
                    "| 3. To EXIT                                      |\n" +
                    "     Choose an option:     ");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Customer ID: ");
                    int custID = scan.nextInt();

                    for (Borrowing borrow : borrowingList) {
                        if (borrow.getCustID() == custID) {
                            System.out.println(borrow);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter Borrowing ID: ");
                    int borrowingID = scan.nextInt();

                    for (Borrowing borrow : borrowingList) {
                        if (borrow.getBorrowingID() == borrowingID) {
                            System.out.println(borrow);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter BookID: ");
                    int bookID = scan.nextInt();

                    for (Borrowing borrow : borrowingList) {
                        if (borrow.getBookID() == bookID) {
                            System.out.println(borrow);
                        }
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error!!! Please enter one of the following numbers [1,2,3,4]!");

            }
        }
    }





//          WHAT EACH METHOD IS SUPPOSED TO DO
//          Customer Options
//          1. Add Customer   [name, phone] - [creates and displays - customerID, displays - name, phone]
//          2. List All Customers  [displays - customers name, phone, custID] - [displays no customers if none]
//          3. Search Customer Info  [asks for - name, custID or phone] - [displays remaining customer info - name, phone or custID]
//          4. Update Customer Info [enter cust id - then choose to update name or phone] - [displays updated customer info - name, phone]
//          5. Delete Customer Info [enter cust id - then delete customer from database] - [displays no customers if none]
//          ------------------------
//          Book Options
//          6. Add Book to Library [asks for - title, author] - [creates and displays - bookID, displays - title, author, availability]
//          7. List Books [displays - book title, author, bookID, availability] - [displays no books if none] - [displays available or unavailable books]
//          8. Search Book [asks for - title, author OR bookID] - [displays - title, author, bookID, availability]
//          ------------------------
//          Borrow Options
//          9. Borrow Book [asks for - customerID, bookID] - [creates and displays - borrowingID, displays - customerID, bookID]
//          10. Return Book [asks for - bookID, borrowingID] - [displays - bookID, borrowingID, customerID, availability]
//          11. List Borrowings [displays - borrowingID, customerID, bookID] - [displays no borrowings if none]
//          12. Search Borrowing [asks for - customerID, borrowingID or bookID] - [displays - borrowingID, customerID, bookID]

