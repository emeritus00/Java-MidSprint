package Library;

/**
 * Represents a book in the library.
 */
class Book extends LibraryItem {
    private Author author;
    private boolean isElectronic;
    private boolean isAudio;

    /**
     * Creates a new Book.
     *
     * @param id          The ID of the book.
     * @param title       The title of the book.
     * @param isbn        The ISBN of the book.
     * @param publisher   The publisher of the book.
     * @param copies      The number of copies available.
     * @param author1      The author of the book.
     * @param isElectronic Whether the book is available electronically.
     * @param isAudio     Whether the book is available as an audiobook.
     */
    public Book(int id, String title, String isbn, String publisher, int copies, Author author1, boolean isElectronic, boolean isAudio) {
        super(id, title, isbn, publisher, copies);
        this.author = author1;
        this.isElectronic = isElectronic;
        this.isAudio = isAudio;
    }

    public Author getAuthor() { 
        return author; 
    }

    public boolean isElectronic() {
        return isElectronic; 
    }

    public boolean isAudio() { 
        return isAudio; 
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Author: " + author.getName() + "\nElectronic: " + (isElectronic ? "Yes" : "No") + "\nAudio: " + (isAudio ? "Yes" : "No") + "\nType: Book");
    }
}
