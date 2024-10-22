import java.util.Scanner;

public class LibraryMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Welcome to the Library Management System ---");
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Add Author");
            System.out.println("7. Add Patron");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter Library Item details...");
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter Author Date of Birth: ");
                    String dateOfBirth = scanner.nextLine();
                    Author author = new Author(authorName, dateOfBirth);
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter Number of Copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Type (Book/Periodical): ");
                    String type = scanner.nextLine();

                    LibraryItem newItem = new LibraryItem(id, title, author, isbn, publisher, copies, type);
                    library.addLibraryItem(newItem);
                    System.out.println("Library item added.");
                    break;

                case 2:
                    // Editing library item can be added in a similar manner (omitted for brevity)
                    System.out.println("Feature not implemented yet.");
                    break;

                case 3:
                    System.out.print("Enter the ID of the Library Item to delete: ");
                    String deleteId = scanner.nextLine();
                    library.removeLibraryItem(deleteId);
                    System.out.println("Library item deleted if it existed.");
                    break;

                case 4:
                    System.out.print("Enter Patron's Name: ");
                    String patronName = scanner.nextLine();
                    Patron borrowingPatron = library.searchPatronByName(patronName);
                    if (borrowingPatron != null) {
                        System.out.print("Enter the title of the item to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        library.borrowLibraryItem(borrowingPatron, borrowTitle);
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Patron's Name: ");
                    String returnPatronName = scanner.nextLine();
                    Patron returningPatron = library.searchPatronByName(returnPatronName);
                    if (returningPatron != null) {
                        System.out.print("Enter the title of the item to return: ");
                        String returnTitle = scanner.nextLine();
                        library.returnLibraryItem(returningPatron, returnTitle);
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Author's Name: ");
                    String newAuthorName = scanner.nextLine();
                    System.out.print("Enter Author's Date of Birth: ");
                    String dob = scanner.nextLine();
                    Author newAuthor = new Author(newAuthorName, dob);
                    library.addAuthor(newAuthor);
                    System.out.println("Author added.");
                    break;

                case 7:
                    System.out.print("Enter Patron's Name: ");
                    String newPatronName = scanner.nextLine();
                    System.out.print("Enter Patron's Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Patron's Phone Number: ");
                    String phone = scanner.nextLine();
                    Patron newPatron = new Patron(newPatronName, address, phone);
                    library.addPatron(newPatron);
                    System.out.println("Patron added.");
                    break;

                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
