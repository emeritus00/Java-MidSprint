package Library;

import java.util.ArrayList;
import java.util.List;

/**
 * The Library class manages library items, authors, and patrons.
 * Provides methods for adding, editing, deleting, and searching these objects.
 */

public class Library {
    private List<LibraryItem> libraryItems;
    private List<Author> authors;
    private List<Patron> patrons;

    /**
     * Initializes a new Library with empty lists for library items, authors, and patrons.
     */
    public Library (){
        this.libraryItems = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    
    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    /**
     * Adds a new item to the library.
     * @param item The LibraryItem to add.
     */
    public void addLibraryItem(LibraryItem item){
        libraryItems.add(item);
    }

    /**
     * Removes an item from the library by its ID.
     * @param id The ID of the LibraryItem to remove.
     */
    public void removeLibraryItem(int id){
        libraryItems.removeIf(item -> item.getId() == id);
    }

    /**
     * Searches for a library item by title.
     * @param title The title of the LibraryItem to search for.
     * @return The LibraryItem if found; otherwise, null.
     */
    public LibraryItem searchByTitle(String title){
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Adds a new author to the library.
     * @param author The Author to add.
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void editAuthor(String name, String newName, String newDateOfBirth) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                author.setName(newName);
                author.setDateOfBirth(newDateOfBirth);
                System.out.println("\nAuthor details updated.");
                return;
            }
        }
        System.out.println("Author not found.");
    }

    public void deleteAuthor(String name) {
        authors.removeIf(author -> author.getName().equalsIgnoreCase(name));
        System.out.println("\nAuthor removed if they existed.");
    }

    public void printAllAuthors() {
        System.out.println("\nAuthors in Library:");
        for (Author author : authors) {
            author.printDetails();
        }
    }

    /**
     * Adds a new patron to the library.
     * @param patron The Patron to add.
     */
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    /**
     * Searches for a patron by name.
     * @param name The name of the Patron to search for.
     * @return The Patron if found; otherwise, null.
     */
    public Patron searchPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(name)) {
                return patron;
            }
        }
        return null;
    }

    public void borrowLibraryItem(Patron patron, String title) {
        LibraryItem item = searchByTitle(title);
        if (item != null && patron != null) {
            patron.borrowedItem(item);
        } else {
            System.out.println("Item or patron not found.");
        }
    }

    public void returnLibraryItem(Patron patron, String title) {
        LibraryItem item = searchByTitle(title);
        if (item != null && patron != null) {
            patron.returnItem(item);
        } else {
            System.out.println("Item or patron not found.");
        }
    }

}
