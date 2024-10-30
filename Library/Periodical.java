package Library;

/**
 * Represents a periodical in the library.
 */
class Periodical extends LibraryItem {
    private String issueDate;
    private boolean isElectronic;

    /**
     * Creates a new Periodical.
     *
     * @param id          The ID of the periodical.
     * @param title       The title of the periodical.
     * @param isbn        The ISBN of the periodical.
     * @param publisher   The publisher of the periodical.
     * @param copies      The number of copies available.
     * @param issueDate   The issue date of the periodical.
     * @param isElectronic Whether the periodical is available electronically.
     */
    public Periodical(int id, String title, String isbn, String publisher, int copies, String issueDate, boolean isElectronic) {
        super(id, title, isbn, publisher, copies);
        this.issueDate = issueDate;
        this.isElectronic = isElectronic;
    }

    public String getIssueDate() { return issueDate; }
    public boolean isElectronic() { return isElectronic; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Issue Date: " + issueDate + "\nElectronic: " + (isElectronic ? "Yes" : "No") + "\nType: Periodical");
    }
}
