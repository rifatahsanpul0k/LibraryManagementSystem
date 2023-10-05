import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create lists to store information about books and patrons
        List<Book> bookList = new ArrayList<>();
        List<Patrons> patronsList = new ArrayList<>();

        // Scanner for user input
        Scanner scan = new Scanner(System.in);

        // Display the main menu
        System.out.println("####### It is a Library management system ######");
        System.out.println("Menu1:\n1. Book Management\n2. Patron Management");
        System.out.println("Enter your choice: ");
        int choice1 = scan.nextInt();

        // Switch based on the user's choice from the main menu
        switch (choice1) {
            case 1: // Book Management
                System.out.println("Enter \n1. to Add New Book\n2. to View The List\n3. to Search For a Book\n4. Mark Book for Borrowed and Return");
                int choice2 = scan.nextInt();

                // Switch based on the user's choice in the Book Management submenu
                switch (choice2) {
                    case 1: // Add new book
                        scan.nextLine(); // Consume newline character
                        System.out.println("Enter Title: ");
                        String title = scan.nextLine();
                        System.out.println("Enter Author: ");
                        String author = scan.nextLine();
                        System.out.println("Enter ISBN: ");
                        String isbn = scan.next();
                        String borrower = null;
                        Book book1 = new Book(title, author, isbn, true, borrower);
                        bookList.add(book1);
                        System.out.println("Book Added Successfully!");
                        break;
                    case 2: // View the list of all books
                        System.out.println("Book List: ");
                        for (Book book : bookList) {
                            System.out.println(book);
                        }
                        break;
                    case 3: // Search for a book by title, ISBN, or Author
                        boolean bookFound = false;
                        System.out.println("Enter Title, ISBN, or Author");
                        String input1 = scan.nextLine();
                        for (Book book : bookList) {
                            if (book.title.equals(input1) || book.isbn.equals(input1) || book.author.equals(input1)) {
                                bookFound = true;
                                System.out.println("This Book: " + book);
                                break;
                            }
                        }
                        if (!bookFound) {
                            System.out.println("Books not found! Please try again.");
                        }
                        break;
                    case 4: // Mark books as borrowed and return
                        boolean studentFound = false;
                        String borrowerID = null;
                        System.out.println("Enter Book Title, ISBN, or Author");
                        String input3 = scan.nextLine();
                        System.out.println("Library Card Number to Determine the Borrower");
                        String input4 = scan.nextLine();
                        for (Patrons patrons : patronsList) {
                            if (patrons.name.equals(input4)) {
                                studentFound = true;
                                borrowerID = patrons.libraryCardNumber;
                            }
                        }
                        if (!studentFound) {
                            System.out.println("Student is not in the Patrons list");
                        }
                        for (Book book : bookList) {
                            if (book.isbn.equals(input3) || book.author.equals(input3) || book.title.equals(input3)) {
                                book.borrower = borrowerID;
                                book.isAvailable = false;
                                bookFound = true;
                            }
                        }
                        System.out.println("Book Borrowed by: " + borrowerID);
                        break;
                }
                break; // End of Book Management

            case 2: // Patron Management
                System.out.println("1. to Add a Patron\n2. to View the List of All Patrons\n3. Search for Patrons\n4. Keep Track of Books Borrowed by a Patron");
                int choice3 = scan.nextInt();

                // Switch based on the user's choice in the Patron Management submenu
                switch (choice3) {
                    case 1: // Add a patron
                        System.out.println("Enter name: ");
                        String name = scan.nextLine(); // Consume newline character
                        System.out.println("Enter Student ID: ");
                        String studentID = scan.nextLine();
                        System.out.println("Enter Phone: ");
                        String phone = scan.next();
                        System.out.println("Enter Email: ");
                        String email = scan.next();
                        scan.nextLine(); // Consume newline character
                        System.out.println("Enter Address: ");
                        String address = scan.nextLine();
                        System.out.println("Enter Library Card Number: ");
                        String libraryCardNumber = scan.next();
                        System.out.println("Enter Membership Status: ");
                        String membershipStatus = scan.next();
                        System.out.println("Enter Patron Type: ");
                        String type = scan.next();
                        ArrayList<String> bookList1 = new ArrayList<String>();
                        bookList1 = null;
                        Patrons patron = new Patrons(name, studentID, phone, email, address, libraryCardNumber, membershipStatus, type, bookList1);
                        patronsList.add(patron);
                        System.out.println("Patron Added Successfully!");
                        break;

                    case 2: // View all the list of patrons
                        for (Patrons patrons : patronsList) {
                            System.out.println(patrons);
                        }
                        break;

                    case 3: // Search for a patron by name or library card number
                        boolean patronFound = false;
                        System.out.println("Enter Patron Name or Library Card Number: ");
                        String input = scan.nextLine();
                        for (Patrons patrons : patronsList) {
                            if (patrons.name.equals(input) || patrons.libraryCardNumber.equals(input)) {
                                patronFound = true;
                                System.out.println("Patron Details: ");
                                System.out.println(patrons);
                                break;
                            }
                        }
                        if (!patronFound) {
                            System.out.println("Patron is not found in the list");
                        }
                        break;

                    case 4: // Keep track of books borrowed by a patron
                        System.out.println("Enter Student ID or Library Card Number: ");
                        String input2 = scan.nextLine();
                        for (Patrons patrons : patronsList) {
                            if (patrons.studentID.equals(input2) || patrons.libraryCardNumber.equals(input2)) {
                                patronFound = true;
                                System.out.println("List of Borrowed Books: ");
                                for (String element : patrons.booklist1) {
                                    System.out.println(element);
                                }
                            }
                        }
                        break;
                }
                break; // End of Patron Management
        }
    }
}
