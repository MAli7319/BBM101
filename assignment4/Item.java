
public class Item {
    
    // Each item will have a name and id
    private String itemID, itemName;

    public Item(String itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    // Getters - setters and toString
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemID + " " + itemName;
    }
    
}
