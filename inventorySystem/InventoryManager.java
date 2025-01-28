package inventorySystem;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<InventoryItem> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

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
    public void deleteItem(String id) {
        inventory.removeIf(item -> item.getId().equals(id));
    }
    public List<InventoryItem> getItems() {
        return inventory;
    }
}

