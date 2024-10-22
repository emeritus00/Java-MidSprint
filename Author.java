import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> itemsWritten;

    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.itemsWritten = new ArrayList<>();
    }

    public void addLibraryItem(LibraryItem item) {
        this.itemsWritten.add(item);
    }

    public void printDetails(){
        System.out.println("Author: " + name + "\nDate of Birth: " + dateOfBirth);
        System.out.println("Items Written:");
        for (LibraryItem item : itemsWritten) {
            item.printDetails();
        }
    }
}
