public class LibraryItem {
    private String id;
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int totalCopies;
    private int availableCopies;
    private String itemType;

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

    public void borrowItem(){
        if (availableCopies > 0) {
            availableCopies--;
        } else {
            System.out.println("Item is currently check out");
        }
        
    }

    public void returnItem(){
        if(availableCopies < totalCopies){
            availableCopies++;
        } else {
            System.out.println("All copies of this item are already in the library.");
        }
    }

    
    public void printDetails() {
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nPublisher: " + publisher + "\nAvailable Copies: " + availableCopies);
    }
}
