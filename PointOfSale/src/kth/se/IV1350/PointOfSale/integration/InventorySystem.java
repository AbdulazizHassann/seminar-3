package kth.se.IV1350.PointOfSale.integration;
import kth.se.IV1350.PointOfSale.model.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import kth.se.IV1350.PointOfSale.model.ItemDTO;
import java.util.Iterator;

/**
 * Manages the inventory of items in the system.
 * Provides methods for adding, removing, and updating items.
 */
public class InventorySystem {
	private Sale sale;
	private List<ItemDTO> listOfRegisteredItems = new ArrayList<ItemDTO>();
	public InventorySystem() {
		addItems();
	}
	/**
	 * Retrieves information about an item based on its item ID.
	 * 
	 * @param itemID The ID of the item to retrieve information for.
	 * @return The ItemDTO object containing information about the item if found, otherwise null.
	 */
	
	public ItemDTO getItemInfo(String itemID) {
	    boolean itemFound = false;
	    for (ItemDTO item : listOfRegisteredItems) {
	    	
	        if (item.getItemID().equals(itemID)) {
	            itemFound = true;
	           
	            return item;
	        }
	    }
	  
	    return null; 
	}
	/**
	 * Updates the inventory system with information about sold items.
	 * 
	 * @param soldItems A list of ItemDTO objects representing the items that have been sold.
	 */
    public void updatedTheSoldItems(List<ItemDTO> soldItems) {
  
    	decreaseSoldItems(soldItems);
    }
    
    /**
     * Adds a variety of items to the list of registered items.
     * Each item is represented by an ItemDTO object containing details such as ID, name, quantity, price, VAT, and description.
     * The method populates the list with pre-defined items including BigWheel Oatmeal, YouGoGo Blueberry, Fresh Apples, Carrots, Popcorn,
     * Potato Crisps, and Chocolate Bars, along with their respective details.
     */
    
    public void addItems() {
    	listOfRegisteredItems.add(new ItemDTO("abc123", "BigWheel Oatmeal", 5, 29.90, 0.06, "BigWheel Oatmeal 500 g , whole grain oats , high fiber , gluten free"));
    	listOfRegisteredItems.add(new ItemDTO("def456" , "YouGoGo Blueberry" , 10, 14.90 , 0.06, "YouGoGo Blueberry 240 g , low sugar youghurt ,blueberry flavour"));
    	listOfRegisteredItems.add(new ItemDTO("ghi789", "Fresh Apples", 20, 12.50, 0.12, "Fresh Apples, assorted varieties, 1kg"));
    	listOfRegisteredItems.add(new ItemDTO("jkl127", "Carrots", 30, 8.75, 0.12, "Carrots, fresh, 500g"));
    	listOfRegisteredItems.add(new ItemDTO("mno345", "Popcorn", 18, 3.50, 0.12, "Butter Flavored Popcorn, 100g"));
    	listOfRegisteredItems.add(new ItemDTO("pqr678", "Potato Crisps", 20, 6.75, 0.12, "Thinly Sliced Potato Crisps, Salted, 200g"));
    	listOfRegisteredItems.add(new ItemDTO("rst456", "Chocolate Bars", 25, 5.99, 0.12, "Assorted Chocolate Bars, 50g"));

    }
    /**
     * Decreases the quantity of sold items from the list of registered items.
     * 
     * @param soldItems A list of ItemDTO objects representing the items that have been sold.
     *                  For each sold item, its corresponding item in the list of registered items will have its quantity decreased.
     */
    
    public void decreaseSoldItems(List<ItemDTO> soldItems) {
        for (ItemDTO soldItem : soldItems) {
            String soldItemId = soldItem.getItemID();
            for (Iterator<ItemDTO> iterator = listOfRegisteredItems.iterator(); iterator.hasNext();) {
                ItemDTO item = iterator.next();
                if (item.getItemID().equals(soldItemId)) {
                    iterator.remove(); 
                }
            }
        }
    }
    /**
     * Returns the number of items registered in the inventorySystem.
     * 
     * @return The size of the list of registered items.
     */
    public int getInventorySize() {
        return listOfRegisteredItems.size();
    }
    
    
   }
