package Library;

/**
 * Represents a general item in the library with common attributes.
 */
public class LibraryItem {
    private int id;
    private String title;
    private String ISBN;
    private String publisher;
    private int totalCopies;
    private int availableCopies;

    /**
     * Creates a new LibraryItem.
     * @param id The ID of the item.
     * @param title The title of the item.
     * @param author The author of the item.
     * @param ISBN The ISBN of the item.
     * @param publisher The publisher of the item.
     * @param totalCopies The total number of copies of the item.
     * @param itemType The type of the item (e.g., book, periodical).
     */
    public LibraryItem(int id, String title, String ISBN, String publisher,int totalCopies){
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getISBN(){
        return this.ISBN;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public int getTotalCopies(){
        return this.totalCopies;
    }

    public int getAvailableCopies(){
        return this.availableCopies;
    }

    /**
     * Attempts to borrow the item, decreasing the available copies by one if available.
     */
    public void borrowItem(){
        if (availableCopies > 0) {
            availableCopies--;
        } else {
            System.out.println("Item is currently checked out");
        }
        
    }

    /**
     * Returns the item, increasing the available copies by one if applicable.
     */
    public void returnItem(){
        if(availableCopies < totalCopies){
            availableCopies++;
        } else {
            System.out.println("All copies of this item are already in the library.");
        }
    }

    
    public void printDetails() {
        System.out.println("ID: " + id + "\nTitle: " + title + "\nISBN: " + ISBN + "\nPublisher: " + publisher + "\nAvailable Copies: " + availableCopies);
    }
}
