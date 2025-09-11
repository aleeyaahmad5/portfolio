package stage2_aleeyaahmad;

public class Borrowing {

    //variables
    private int borrowingID;
    private int custID;
    private int bookID;
    static int nextID;

    //constructor
    public Borrowing() {}

    //returnDate is not added here because it is not known at the time of borrowing
    public Borrowing(int custID, int bookID) {
        this.custID = custID;
        this.bookID = bookID;
        this.borrowingID = nextID++;
    }

    //functions
    public int getBorrowingID() {
        return borrowingID;
    }

    public int getCustID() {
        return custID;
    }
    public int getBookID() {
        return bookID;
    }


    public String toString() {
        return "Borrowing ID: " + borrowingID + "\n" +
                "Customer ID: " + custID + "\n" +
                "Book ID: " + bookID + "\n" ;
    }
}
