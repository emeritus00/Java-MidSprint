import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    public Patron (String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowedItem(LibraryItem item){
        if (item.getAvailableCopies() > 0){
            item.borrowItem();
            borrowedItems.add(item);
        } else {
            System.out.println("This item is not available to borrow.");
        }
    }

    public void returnItem(LibraryItem item){
        if(borrowedItems.contains(item)){
            item.returnItem();
            borrowedItems.remove(item);
        } else {
            System.out.println("You have not borrowed this item.");
        }
    }

    public void printDetails() {
        System.out.println("Patron: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber);
        System.out.println("Borrowed Items:");
        for (LibraryItem item : borrowedItems) {
            item.printDetails();
        }
    }
}
