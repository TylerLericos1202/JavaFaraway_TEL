import java.util.ArrayList;
import java.util.Scanner;

public class Player extends CharacterCreation{
	
	String name;
	int health = 100;
	int gold = 0;
	int attack;
	Item equippedItem;
	
	classes classes;
	race race;
	
	ArrayList<Item> inventory = new ArrayList<Item>() ;	//Inventory of Items

	boolean equipped = false;
	boolean isDead = false;
	
	public enum classes {
		WARRIOR,
		MAGE,
		THIEF
	}
	public enum race{
		HUMAN,
		ELF,
		ORC,
		DWARF
	}
	
	public Player() {
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setRace(race race) {
		this.race = race;
	}

	public Player.race getRace() {
		return race;
	}
	

	public classes getClasses() {
		return classes;
	}

	public void setClasses(classes classes) {
		this.classes = classes;
	}

	public void getInventory() {
		System.out.println("+++++++++++++++Inventory+++++++++++++++");
		for (int i = 0; i< inventory.size(); i++) {
			System.out.println(i +". |"+ inventory.get(i).name + "| Cost: " + inventory.get(i).cost + " Qunatity: " + inventory.get(i).quantity+ " Damage: " + inventory.get(i).damage);
		}
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public void Pickup(Places place) {
		if (place.item == null) {
			System.out.println("No items here!");
		}
		else {
			if(place.item.itemType == place.item.itemType.GOLD) {
				this.setGold(place.item.quantity);
			}
		inventory.add(place.item);
		System.out.println("You picked up " + place.item.name);
		place.setItem(null);
		}
	}
	/*
	 * Equip method
	 */
	public void Equip(Scanner scan, Player player) {
		
		System.out.println("What do you want to equip?");
		player.getInventory();
		
		var pick = scan.nextInt();
		if (pick <0 |pick>= player.inventory.size()) {
			System.out.println("Invalid Option!");
		}else {
			var e = player.inventory.get(pick);
			if (!equipped) {
				
				equippedItem = e;
				this.setAttack(equippedItem.damage);
				equipped = true;
				System.out.println("You equipped " + e.name + " Damage: " + e.damage + "+");
			}else if(equipped) {
				System.out.println("Item Already Equipped!");
				}
		}
	}
	

	public Item getEquippedItem() {
		return equippedItem;
	}

	public void setEquippedItem(Item equippedItem) {
		this.equippedItem = equippedItem;
	}

	public int getHealth() {
		return health;
	}

	public void Damage (int Damage) {
		this.health = health-Damage;
	}
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void setHealth(int health) {
		this.health = health;
	}


	@Override
	public String toString() {
		return "Player [name=" + name + ", classes=" + classes + ", race=" + race + ", inventory=" + inventory + "]";
	}
	
	
};
	
	

	
	
	
	
	
	
	
	
	

