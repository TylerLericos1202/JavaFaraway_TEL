import java.util.*;
/**
*@author Tyler Lericos
*@version 1.0
*Interfaces 
*Spring Semester/Freshman
*/

public class Shop extends Village {
	
	char charChoice;
	String shopName;
	ArrayList<Item> items = new ArrayList<Item>();
	/*
	 * Parameterized Constructor
	 */
	public Shop(String shopName, ArrayList<Item> items) {
		super();
		this.shopName = shopName;
		this.items = items;
		}
	/*
	 * Getter
	 */
	public String getShopName() {
		return shopName;
	}
	/*
	 * Setter
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/*
	 * Getter for items uses a for loop to display items in shop
	 */
	public void getItems() {
		for (int i = 0; i< items.size(); i++) {
			System.out.println(items.get(i).name);
		}
	}
	/*
	 * Holds a generic type for item as a parameter
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	/*
	 * Buy items method that will add one of the shops items to your inventory and take your player's gold
	 */
	public void BuyItems(Player player, Scanner scan) {
		System.out.println("What would you like to purchase?\n");
		for (int i = 0; i<items.size(); i++) {
			System.out.println(i + ". " + items.get(i).name + " Cost: " + items.get(i).cost + " gold");
		}
		int intchoice = scan.nextInt();
		
		if (player.gold <=0) {
			System.out.println("You do not have enough gold!");
		}
		else if(player.gold > 0) {
			player.inventory.add(items.get(intchoice));
			player.gold = player.gold - items.get(intchoice).cost;
			System.out.println(items.get(intchoice).name + " was added to inventory");
		}
		
	}
	
}
