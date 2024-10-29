package Library;
public class Demo {
    public static void main(String[] args) {
        Library library = new Library();
        loadSampleData(library);

        System.out.println("\n--- Testing Library Management System ---");

        // Display all library items
        System.out.println("\n****** Start of List Library Itmes *******");
        System.out.println("\nLibrary Items:");
        for (LibraryItem item : library.getLibraryItems()) {
            item.printDetails();
            System.out.println();
        }
        System.out.println("********* End of Library Items ***********");

        // Display all authors
        System.out.println("\n******* Start of List of Authors *******");
        System.out.println("\nAuthors:");
        for (Author author : library.getAuthors()) {
            author.printDetails();
            System.out.println();
        }
        System.out.println("****** End of List of Authors ************");

        // Display all patrons
        System.out.println("\n***** Start of List of Patrons *********");
        System.out.println("\nPatrons:");
        for (Patron patron : library.getPatrons()) {
            patron.printDetails();
            System.out.println();
        }
        System.out.println("******** End of List of Patrons **********");

        // Test borrowing an item
        System.out.println("\n**** Showing Borrowing from Library ****");
        Patron patron = library.searchPatronByName("Alice Johnson");
        if (patron != null) {
            System.out.println("\nAlice Johnson borrows 'The Philosopher's Stone'");
            library.borrowLibraryItem(patron, "The Philosopher's Stone");
            patron.printDetails();
        }
        System.out.println("************ End of Borrowing ************");


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
            System.out.println("\nSearched for 'Motherbird':");
            searchedItem.printDetails();
        } else {
            System.out.println("\n'Motherbird' not found in library.");
        }
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

        // Display all authors
        library.printAllAuthors();

        // Adding Library Items
        library.addLibraryItem(new LibraryItem("001", "The Philosopher's Stone", author1, "9780747532743", "Exim", 5, "Book"));
        library.addLibraryItem(new LibraryItem("002", "The Chamber of Hallow Secrets", author1, "9780747538486", "Exim", 5, "Book"));
        library.addLibraryItem(new LibraryItem("003", "The Wedding Day", author2, "9780451524935", "Secker & Warburg", 4, "Book"));
        library.addLibraryItem(new LibraryItem("004", "Animal Farm", author2, "9780451526342", "Secker & Warburg", 6, "Book"));
        library.addLibraryItem(new LibraryItem("005", "Motherbird", author3, "9780061120084", "Scribner", 7, "Book"));
        library.addLibraryItem(new LibraryItem("006", "The Great Isle", author4, "9780743273565", "Scribner", 3, "Book"));
        library.addLibraryItem(new LibraryItem("001", "Time Magazine - March 2023", null, "000123456", "Time Inc.", 10, "Periodical"));
        library.addLibraryItem(new LibraryItem("002", "National Geographic - April 2023", null, "000234567", "Nat Geo Society", 8, "Periodical"));

        // Adding Patrons
        library.addPatron(new Patron("Alice Johnson", "123 Elm Street", "555-1234"));
        library.addPatron(new Patron("Bob Smith", "456 Oak Avenue", "555-5678"));
        library.addPatron(new Patron("Cathy Brown", "789 Pine Road", "555-9101"));

        System.out.println("Sample data loaded successfully.");
    }
}
