import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> libraryItems;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library (){
        this.libraryItems = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Manage Library Items
    public void addLibraryItem(LibraryItem item){
        libraryItems.add(item);
    }

    public void removeLibraryItem(String id){
        libraryItems.removeIf(item -> item.getId().equals(id));
    }

    public LibraryItem searchByTitle(String title){
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    // Manage Authors
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Manage Patrons
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public Patron searchPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.name.equalsIgnoreCase(name)) {
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
