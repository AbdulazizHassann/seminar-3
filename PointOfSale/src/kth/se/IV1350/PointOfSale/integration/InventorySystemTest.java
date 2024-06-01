
package kth.se.IV1350.PointOfSale.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import kth.se.IV1350.PointOfSale.model.ItemDTO;
import java.util.ArrayList;
import java.util.List;

public class InventorySystemTest {
    private InventorySystem inventorySystem;
   
    /**
     * Sets up the test environment before each test case.
     * Initializes a new InventorySystem object and adds some test items to it.
     */
    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
        inventorySystem.addItems(); 
    }

    /**
     * Tests the getItemInfo() method when the item exists in the inventory system.
     * It verifies that the method returns the correct attributes of the item.
     */
    
    @Test
    public void getItemInfoTest_itemExists() {
        
        String expectedItemName = "BigWheel Oatmeal";
        double expectedPrice = 29.90;
        
        ItemDTO actualItem = inventorySystem.getItemInfo("abc123");
       
        assertEquals(expectedItemName, actualItem.getItemName(), "getItemInfo should return correct item name");
        assertEquals(expectedPrice, actualItem.getPrice(), "getItemInfo should return correct price");
        
    }

    /**
     * Tests the getItemInfo() method when the item does not exist in the inventory system.
     * It verifies that the method returns null for a non-existent item.
     */

    @Test
    public void getItemInfoTest_itemDoesNotExist() {
        
        ItemDTO actualItem = inventorySystem.getItemInfo("nonexistentID");
        
        
        assertNull(actualItem, "getItemInfo should return null for non-existent item");
    }
    /**
     * Tests the updatedTheSoldItems() method to ensure that it correctly decreases 
     * the quantity of items in the inventory. It verifies that an item is removed 
     * from the inventory after it is sold.
     */
    @Test
    public void testUpdatedTheSoldItems_DecreasesQuantity() {
        List<ItemDTO> soldItems = new ArrayList<>();
        soldItems.add(new ItemDTO("abc123", "BigWheel Oatmeal", 1, 29.90, 0.06, "Description"));

        inventorySystem.updatedTheSoldItems(soldItems);

        ItemDTO item = inventorySystem.getItemInfo("abc123");
        assertNull(item, "Item should have been removed from the inventory");
    }
    /**
     * Tests the addItems() method to ensure that items are correctly added to the inventory.
     * It verifies that the size of the inventory increases after calling the addItems() method.
     */
    @Test
    public void testAddItems_ItemsAddedToList() {
   
        int initialSize = inventorySystem.getInventorySize();
        
        inventorySystem.addItems();
        
        assertTrue(inventorySystem.getInventorySize() > initialSize, "Items should be added to the inventory");
    
    }
}

