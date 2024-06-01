package kth.se.IV1350.PointOfSale.controller;
import kth.se.IV1350.PointOfSale.model.*;

import kth.se.IV1350.PointOfSale.integration.*;
/**
 * This is the applications only controller.
 * All calls to the model path through this class.
 */

public class Controller {
	private Sale sale;
	private AccountingSystem accountingSystem;
	private InventorySystem inventorySystem;
	private Printer printer;
	
	/**
	 * Constructor for the Controller class.
	 * 
	 * @param accountingSystem The accounting system to be used by the controller.
	 * @param inventorySystem The inventory system to be used by the controller.
	 * @param printer The printer to be used by the controller.
	 */
	
	
	public Controller(AccountingSystem accountingSystem ,InventorySystem inventrySystem , Printer printer ) {
		this.accountingSystem = accountingSystem;
		this.inventorySystem = inventrySystem ;
		this.printer = printer;
	}
	
	/**
     * This method to start new sale.
     */
	
	public void startSale() {
		this.sale = new Sale();
	}
/**
 * Scans an item with the given item ID and quantity.
 * If the item is found in the inventory system, its quantity is increased by the given amount.
 * The item is then added to the sale list.
 * @param  itemID The ID of the item to be scanned.
 * @param quantity The quantity of the item to be scanned.
 */
	
	
	public ItemDTO scanItem(String itemID) {
		ItemDTO scannedItem = inventorySystem.getItemInfo(itemID);
		sale.addItemToList(scannedItem);
			return scannedItem;
	
	}
	
	/**
	 *  Ends the current sale and prints out the total price of the sale.
	 */

	public double endSale() {
	double totalPrice = sale.getTotalPrice();
	
	 return totalPrice;
		
	}
	
/**
 * the payment method show how much the customer have paid 
 * @param amountPaid is the amount money the customer have paid.
 */
	public double payment(double amountPaid) {
		 sale.setAmountPaid(amountPaid);
		double changes = sale.getChange();
		return changes ;
	}
	
	/**
	 * updatedExternalSystems methods updates the externalSystem  with information about sold items 
	 * after that removes the sold items from the inventory system and also saves them into the accounting system.
	 */
	public void updatedExternalSystems() {
		inventorySystem.updatedTheSoldItems(sale.getListOfItems());
		accountingSystem.addSoldItems(sale.getListOfItems());
		
	}
 /**
  * this methods prints out receipt 
  */
	public void printOutTheReciept() {
		sale.printReceipt(printer , sale);
	}

}
