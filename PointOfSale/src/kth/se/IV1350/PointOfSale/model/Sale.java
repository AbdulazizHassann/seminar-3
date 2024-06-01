package kth.se.IV1350.PointOfSale.model;
import kth.se.IV1350.PointOfSale.integration.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Manages the items being sold in a transaction.
 * Tracks the items added to the sale and calculates the total price.
 */
public class Sale {
	
	private double totalPrice ;
	private double amountPaid ;
	private double change ;
	private double totalVat ; 
	private List<ItemDTO> listOfItems = new ArrayList<ItemDTO>();
	
	/**
	 * Initializes a new Sale object.
	 */
	public Sale()
	{
		
	}
	
	/** 
	 * method returns amount money the customer paid .
	 * @return amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}
	/** 
	 * method shows in the display how much the customer have paid
	 * 
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
		
	}
	
	
	/**
	 * Updates the total price and total VAT of the sale based on the items in the sale list.
	 * 
	 * @return The total price of the sale.
	 */
	
	public double updateTotalPrice() {
	    double totalVatt = 0;
	    double totalPriceWithoutVat = 0;

	    for (ItemDTO item : listOfItems) {
	    	
	        totalPriceWithoutVat += item.getPrice() * item.getQuantity();
	        totalVatt += item.getPrice() * item.getVat() * item.getQuantity();
	    }
	   
	    totalPrice = totalPriceWithoutVat;
	    totalVat = totalVatt;
	   
	 
	    return totalPrice;
	   
	}
	/**
	 * Returns the total VAT of the sale.
	 * 
	 * @return The total VAT of the sale.
	 */
	
	public double getTotalVat() {
		
		return totalVat;
	}
	
	/**
	 * Calculates and returns the change for the customer after a payment.
	 * 
	 * @return The change for the customer.
	 */
	public double getChange() {
		 
	    updateTotalPrice();
		 change = amountPaid - totalPrice;
		
		return change;
	}
	
	/**
	 * Adds a new item to the list of items in the sale.
	 * 
	 * @param newItem The new item to be added to the list.
	 */
	
	public void addItemToList(ItemDTO newItem) {
	    if (newItem != null) {
	        boolean found = false;

	        for (ItemDTO item : listOfItems) {
	            if (item.getItemID().equals(newItem.getItemID())) {
	                item.increaseQuantity(1); 
	                found = true;
	            }
	        }

	        if (!found) {
	           newItem.setQuantity(1); 
	            listOfItems.add(newItem);
	        }
	    }
	}

	/**
     * Returns the number of customers registered items in the sale .
     * 
     * @return The size of the list of customers registered items.
     */
	public List<ItemDTO> getListOfItems(){
		
		return listOfItems;
	}
	
	
	/**
	 * Returns the total price in the sale 
	 * @return total price 
	 */
	public double getTotalPrice() {
		updateTotalPrice();
		return totalPrice;
	}
	/**
	 * Prints a receipt for the sale using the provided printer.
	 * 
	 * @param printer The printer object used for printing.
	 * @param sale The sale object for which the receipt is being printed.
	 */
	public void printReceipt(Printer printer , Sale sale){
		Reciept recieptDTO = new Reciept(sale);
		Printer.printoutReceipt(recieptDTO);
	}
		
		
	 
	
	
}
