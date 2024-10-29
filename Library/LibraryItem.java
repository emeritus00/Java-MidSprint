package Library;

/**
 * The LibraryItem class represents an item in the library, such as a book or periodical.
 */
public class LibraryItem {
    private String id;
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int totalCopies;
    private int availableCopies;
    private String itemType;

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
    public LibraryItem(String id, String title, Author author, String ISBN, String publisher,int totalCopies, String itemType){
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.itemType = itemType;
    }

    // Getter methods with Javadoc comments can be added here...
    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public Author getAuthor(){
        return this.author;
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

    public String getItemType(){
        return this.itemType;
    }

    /**
     * Attempts to borrow the item, decreasing the available copies by one if available.
     */
    public void borrowItem(){
        if (availableCopies > 0) {
            availableCopies--;
        } else {
            System.out.println("Item is currently check out");
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
        System.out.println("\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nPublisher: " + publisher + "\nAvailable Copies: " + availableCopies);
    }
}
