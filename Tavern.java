import java.util.*;
/**
*@author Tyler Lericos
*@version 1.0
*Interfaces 
*Spring Semester/Freshman
*/
public class Tavern extends Village{
	
	String tavernName;
	int cost;
	/*
	 * Tavern Constructor
	 */
	public Tavern(String name, int cost) {
		super();
		this.tavernName = name;
		this.cost = cost;
		// TODO Auto-generated constructor stub
	}
	/*
	 * Rest method for restoring players health and taking their gold
	 */
	public void Rest(Player player, Scanner scan) {
		System.out.println("Would you like to rest to regain health?");
		System.out.println("1. Yes\n2. No");
		int choice = scan.nextInt();
		if (choice == 1) {
			player.setHealth(100);
			player.gold = player.gold - cost;
			System.out.println("You are fully healed and rested!");
			System.out.println("-" +cost);
		}
		else if (choice == 2) {
			System.out.println("You avoid the tavern!");
		}
		else if (choice != 1|| choice !=2) {
			System.out.println("Invalid Option");
		}
	}
	/*
	 * =======================================
	 * Getters and Setters
	 * =======================================
	 */
	public String getTavernName() {
		return tavernName;
	}

	public void setTavernName(String name) {
		this.tavernName = name;
	}
	
	
}
