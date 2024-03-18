import java.util.ArrayList;
import java.util.Scanner;

/**
*@author Tyler Lericos
*@version 1.0
*Interfaces 
*Spring Semester/Freshman
*/
public class Places extends World{
	/*
	 * 
	 */
	Shop shop;
	Tavern tavern;
	String placeName;
	String flavorText;
	Item item;
	Item key;
	String itemName;
	Enemy enemy = new Enemy();
	Battle battle =  new Battle();
	Player player = new Player();
	boolean isLocked;
	/*
	 * Empty Constructor
	 */
	public Places() {}
	/*
	 * Constructor with paramters
	 */
	public Places(String placeName, String flavorText, Item item, Player player, Enemy enemy, boolean isLocked,Item key) {
		super();
		this.placeName = placeName;
		this.flavorText = flavorText;
		this.item = item;
		this.player = player;
		this.enemy = enemy;
		this.isLocked = isLocked;
		this.key = key;
	}
	//Checks the place is it has an enemy or not
	public void checkEnemy() {
		if (this.enemy == null) {
			System.out.println("There are no enemies nearby!");
			
		}else {
			System.out.println("There is a " + this.enemy.name + " nearby!");
			battle.Battle(player, enemy);
		}
	}
	//Checks if the place is locked
	public void checkLock() {
		if(this.isLocked ==false) {
			System.out.println("Unlocked!");
		}else {
			System.out.println("Locked!");
			if (player.inventory.contains(this.key)) {
				this.isLocked =false;
				
			}else {
				System.out.println("You do not have the key!");
				
			}
		}
	}
	//Open lock statement
	public void OpenLock(Player player, Scanner scan) {
		System.out.println("Do you have the key?");
		
	}
	
	/*
	 * ===================================================
	 * Getters and Setters
	 * ===================================================
	 */
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Shop getShop() {
		return shop;
	}
	

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	@Override
	public String toString() {
		return  placeName +"\n"+ flavorText +"\n";
	}
	public void setTavern(Tavern tavern) {
		this.tavern = tavern;
	}
	
	public Tavern getTavern() {
		// TODO Auto-generated method stub
		return tavern;
	}
	
	
	
	
	
	
	
	
}
