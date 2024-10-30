package Library;

import java.util.ArrayList;
import java.util.List;

/**
 * The Author class represents an author who has written items in the library.
 */
public class Author {
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> itemsWritten;

    /**
     * Creates a new Author.
     * @param name The name of the author.
     * @param dateOfBirth The date of birth of the author.
     */
    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.itemsWritten = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Adds a library item to the list of items written by the author.
     * @param item The LibraryItem to add.
     */
    public void addLibraryItem(LibraryItem item) {
        this.itemsWritten.add(item);
    }

    public void removeLibraryItem(LibraryItem item) {
        this.itemsWritten.remove(item);
    }

    /**
     * Prints details of the author and the items they have written.
     */
    @Override
    public String toString() {
        return "Author: " + name + ", Date of Birth: " + dateOfBirth;
    }
    
    public void printDetails() {
        System.out.println(this.toString());
    }

}
