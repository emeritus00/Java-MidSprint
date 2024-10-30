package Library;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Library library = new Library();
        loadSampleData(library);

        System.out.println("\n--- Testing Library Management System ---");

        // Display all library items
        System.out.println("\n****** Start of List Library Items *******");
        System.out.println("\nLibrary Items:");
        for (LibraryItem item : library.getLibraryItems()) {
            item.printDetails();
            System.out.println();
        }
        System.out.println("********* End of Library Items ***********");

        // Display all authors and their books
        System.out.println("\n******* Start of List of Authors and Their Books *******");
        for (Author author : library.getAuthors()) {
            author.printDetails();
            System.out.println("\nBooks written by " + author.getName() + ":\n");
            for (LibraryItem item : library.getLibraryItems()) {
                if (item instanceof Book && ((Book) item).getAuthor().equals(author)) {
                    item.printDetails();
                    System.out.println();
                }
            }
            System.out.println("----\n");
        }
        System.out.println("****** End of List of Authors and Their Books ************");

         // Display all patrons and their borrowed items
        System.out.println("\n***** Start of List of Patrons and Their Borrowed Items *********\n");
        for (Patron patron : library.getPatrons()) {
            patron.printDetails();
            System.out.println("\nItems borrowed by " + patron.getName() + ":\n");
            List<LibraryItem> borrowedItems = patron.getBorrowedItems(); 
            if (borrowedItems.isEmpty()) {
                System.out.println("No borrowed items.");
            } else {
                for (LibraryItem item : borrowedItems) {
                    item.printDetails();
                    System.out.println();
                }
            }
            System.out.println("----\n");
        }
        System.out.println("******** End of List of Patrons and Their Borrowed Items **********");

        // Test borrowing an item
        System.out.println("\n**** Showing Borrowing from Library ****");
        Patron patron = library.searchPatronByName("Alice Johnson");
        if (patron != null) {
            System.out.println("\nAlice Johnson borrows 'The Philosopher's Stone'");
            library.borrowLibraryItem(patron, "The Philosopher's Stone");
            patron.printDetails();
        }
        System.out.println("\n************ End of Borrowing ************");

        // Test returning an item
        System.out.println("\n**** Showing Returning to Library ******");
        if (patron != null) {
            System.out.println("\nAlice Johnson returns 'The Philosopher's Stone'");
            library.returnLibraryItem(patron, "The Philosopher's Stone");
            patron.printDetails();
        }
        System.out.println("****** End of Returning to Library *******");

        // Test searching for a library item
        System.out.println("\n******* Searching in Library ***********");
        LibraryItem searchedItem = library.searchByTitle("Motherbird");
        if (searchedItem != null) {
            System.out.println("\nSearched for 'Motherbird':\n");
            System.out.println("Searched result...\n");
            searchedItem.printDetails();
        } else {
            System.out.println("\n'Motherbird' not found in library.");
        }
        System.out.println("----\n");
        System.out.println("***** End of Searching in Library ********");
    }

    public static void loadSampleData(Library library) {
        
        // Adding Authors
        Author author1 = new Author("Jones Rowling", "1965-07-31");
        Author author2 = new Author("George Wen", "1903-06-25");
        Author author3 = new Author("Muhammad Hilda", "1926-04-28");
        Author author4 = new Author("Femi Oguntade", "1896-09-24");

        System.out.println("\n--- Adding or Updating Library ---");
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);

        // Editing an author
        library.editAuthor("Femi Oguntade", "Femi Oguntade Omojo", "1975-05-15");

        // Deleting an author
        library.deleteAuthor("Muhammad Hilda");

        // Adding Books
        Book book1 = new Book(1, "The Philosopher's Stone", "9780747532743", "Exim", 5, author1, false, false);
        Book book2 = new Book(2, "The Chamber of Hallow Secrets", "9780747538486", "Exim", 5, author1, true, false);
        Book book3 = new Book(3, "The Wedding Day", "9780451524935", "Secker & Warburg", 4, author2, false, false);
        Book book4 = new Book(4, "Animal Farm", "9780451526342", "Secker & Warburg", 6, author2, false, true);
        Book book5 = new Book(5, "Motherbird", "9780061120084", "Scribner", 7, author3, true, false);
        Book book6 = new Book(6, "The Great Isle", "9780743273565", "Scribner", 3, author4, false, false);

        library.addLibraryItem(book1);
        library.addLibraryItem(book2);
        library.addLibraryItem(book3);
        library.addLibraryItem(book4);
        library.addLibraryItem(book5);
        library.addLibraryItem(book6);

        // Adding Periodicals
        Periodical periodical1 = new Periodical(7, "Time Magazine - March 2023", "000123456", "Time Inc.", 10, "March 2023", true);
        Periodical periodical2 = new Periodical(8, "National Geographic - April 2023", "000234567", "Nat Geo Society", 8, "April 2023", false);

        library.addLibraryItem(periodical1);
        library.addLibraryItem(periodical2);

        // Adding Patrons
        Patron patron1 = new Patron("Alice Johnson", "123 Elm Street", "555-1234");
        Patron patron2 = new Patron("Bob Smith", "456 Oak Avenue", "555-5678");
        Patron patron3 = new Patron("Cathy Brown", "789 Pine Road", "555-9101");

        library.addPatron(patron1);
        library.addPatron(patron2);
        library.addPatron(patron3);

        // Sample borrowing actions
        library.borrowLibraryItem(patron1, "The Philosopher's Stone");
        library.borrowLibraryItem(patron3, "The Wedding Day");


        System.out.println("Sample data loaded successfully.");
    }
}
