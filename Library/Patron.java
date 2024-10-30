package Library;

import java.util.ArrayList;
import java.util.List;

/**
 * The Patron class represents a library user who can borrow and return items.
 */
public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    /**
     * Creates a new Patron.
     * @param name The name of the patron.
     * @param address The address of the patron.
     * @param phoneNumber The phone number of the patron.
     */
    public Patron (String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return this.name;
     }

     // Method to get the list of borrowed items
     public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    /**
     * Attempts to borrow an item for the patron.
     * @param item The LibraryItem to borrow.
     */
    public void borrowedItem(LibraryItem item){
        if (item.getAvailableCopies() > 0){
            item.borrowItem();
            borrowedItems.add(item);
        } else {
            System.out.println("This item is not available to borrow.");
        }
    }

    /**
     * Returns an item for the patron.
     * @param item The LibraryItem to return.
     */
    public void returnItem(LibraryItem item){
        if(borrowedItems.contains(item)){
            item.returnItem();
            borrowedItems.remove(item);
        } else {
            System.out.println("You have not borrowed this item.");
        }
    }

    /**
     * Prints details of the patron and their borrowed items.
     */
    public void printDetails() {
        System.out.println("Patron: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber);
    }

}
