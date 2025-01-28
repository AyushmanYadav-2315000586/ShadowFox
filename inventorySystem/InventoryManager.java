package inventorySystem;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<InventoryItem> inventory;

    // Constructor
    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    // Add an item to the inventory
    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

    // Update an item in the inventory
    public void updateItem(String id, String name, int quantity, double price) {
        for (InventoryItem item : inventory) {
            if (item.getId().equals(id)) {
                item.setName(name);
                item.setQuantity(quantity);
                item.setPrice(price);
                return;
            }
        }
    }

    // Delete an item from the inventory
    public void deleteItem(String id) {
        inventory.removeIf(item -> item.getId().equals(id));
    }

    // Get all items in the inventory
    public List<InventoryItem> getItems() {
        return inventory;
    }
}

