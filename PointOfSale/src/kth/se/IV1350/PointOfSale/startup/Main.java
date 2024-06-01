package kth.se.IV1350.PointOfSale.startup;
import kth.se.IV1350.PointOfSale.controller.Controller;
import kth.se.IV1350.PointOfSale.view.View;
import kth.se.IV1350.PointOfSale.integration.*;

/**
 * Main entry point of the application.
 * Initializes the necessary components and starts the application.
 */
public class Main {
	
	public static void main(String[] args ) {
		
		 
		Printer printer = new Printer();
		InventorySystem inventorySystem = new InventorySystem();
		AccountingSystem accountingSystem = new AccountingSystem();
		Controller contr = new Controller(accountingSystem,inventorySystem ,printer);
        View view = new View(contr);
        view.runFakeExecution(); 
   
		
	
	}

}
