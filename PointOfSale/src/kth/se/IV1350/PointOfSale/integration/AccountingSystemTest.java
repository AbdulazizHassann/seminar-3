
package kth.se.IV1350.PointOfSale.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import kth.se.IV1350.PointOfSale.integration.AccountingSystem;
import kth.se.IV1350.PointOfSale.model.ItemDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  AccountingSystemTest{
    private AccountingSystem accountingSystem;
   /**
    * Sets up the test environment before each test case.
    * Initializes a new accountingSystem object for testing.
    */
    @BeforeEach
    public void setUp() {
        accountingSystem = new AccountingSystem();
    }
    /** 
     * Tests the addSoldItems() method in the AccountingSystem class.
     * It verifies that sold items are correctly added to the list of sold items.
     */
    @Test
    public void addSoldItemsTest() {
        List<ItemDTO> soldItems = new ArrayList<>();
        ItemDTO item1 = new ItemDTO("abc123", "BigWheel Oatmeal", 1, 29.90, 6, "BigWheel Oatmeal 500 g , whole grain oats , high fiber , gluten free");
        ItemDTO item2 = new ItemDTO("def456", "YouGoGo Blueberry", 1, 14.90, 6, "YouGoGo Blueberry 240 g , low sugar youghurt ,blueberry flavour");
        
        soldItems.add(item1);
        soldItems.add(item2);

        accountingSystem.addSoldItems(soldItems);

        assertEquals(2, accountingSystem.getSoldItemsList().size(), "Sold items list should contain correct number of items");
        assertTrue(accountingSystem.getSoldItemsList().contains(item1), "Sold items list should contain first item");
        assertTrue(accountingSystem.getSoldItemsList().contains(item2), "Sold items list should contain second item");
    }
    /**
     * Tests the getSoldItemsList() method in the AccountingSystem class.
     * It verifies that the method returns the correct list of sold items.
     */
    @Test
    public void getSoldItemsListTest() {
       
        ItemDTO item1 = new ItemDTO("abc123", "BigWheel Oatmeal", 1, 29.90, 6, "BigWheel Oatmeal 500 g , whole grain oats , high fiber , gluten free");
        ItemDTO item2 = new ItemDTO("def456", "YouGoGo Blueberry", 1, 14.90, 6, "YouGoGo Blueberry 240 g , low sugar youghurt ,blueberry flavour");

       
        accountingSystem.addSoldItems(Arrays.asList(item1, item2));

       
        List<ItemDTO> soldItemsList = accountingSystem.getSoldItemsList();

        
        assertEquals(2, soldItemsList.size(), "Sold items list should contain correct number of items");

     
        assertTrue(soldItemsList.contains(item1), "Sold items list should contain first item");
        assertTrue(soldItemsList.contains(item2), "Sold items list should contain second item");
    }
    
    

}
