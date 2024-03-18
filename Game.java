import java.io.IOException;
import java.util.*;

/**
*@author Tyler Lericos
*@version 1.0
*Interfaces 
*Spring Semester/Freshman
*/

public class Game {
	
	
	public static void main(String[] args) throws IOException
	{
		//User input variables
		String stringChoice;
		char charChoice;
		
		
		Scanner scan = new Scanner(System.in);//Scanner
		Player player = new Player();//Player 
		player.setAttack(5);
		CharacterCreation creator = new CharacterCreation(); //Character Creation Object to Create Character
		
		
		/*
		 * =================================================================================
		 * World Builder
		 * =================================================================================
		 */
		//Items
		Item sword = new Item("Sword", 1,5,24);
		sword.setItemType(sword.itemType.WEAPON);
		Item armorHelm = new Item("Helmet",1,8,0);
		armorHelm.setItemType(armorHelm.itemType.ARMOR);
		Item gold = new Item("Gold", 22,0,0);
		gold.setItemType(gold.itemType.GOLD);
		Item key = new Item("Ironfall Key",1,0,0);
		key.setItemType(key.itemType.KEY);
		
		//Shops
	    ArrayList<Item> shop1items = new ArrayList<Item>();
	    shop1items.add(sword);
	    shop1items.add(armorHelm);
	    shop1items.add(sword);
	   
		
		//Village Taverns and Shops
		Shop shop1 = new Shop("The Warstead Trader Post",shop1items);
		Tavern tavern1 = new Tavern("The Borrows Inn", 5);
		
		//Enemies
		Enemy goblin =  new Enemy("Golbin",100,5,gold);
		Enemy bat = new Enemy("Bat",50,2,null);
		
		//Places
		Location Riverwood= new Location("Riverwood", "You are in the village of Riverwood, a road lies north and south is a mountain!", gold,player, null,false, null);
		Location Northpath = new Location ("Northpath", "The road is long, rolling green hills to your left and right, another town lies north, Riverwood still lies to the South",sword,player, null,false,null);
		Location Havenfall = new Location ("Havenfall", "The town of Havenfall is small, sitting cozily under the cliff of Mount Warstead. North is the Farpath.",sword,player, null,false, null);
		Location Warstead1 = new Location ("Foot of Warstead", "At the bottom of the great giant of Polaris, you see a village sitting on a ridge just up ahead, whilst behind you lie Havenfall.",null,player,null,false,null);
		Village Warstead2 = new Village ("Warstead Keep", "You arrive in the cozy village of Warstead, sitting strong and sound in the mountain breeze. You see many villagers, a shop and tavern",shop1, tavern1,sword,player,null,false,null);
		Location Cliffpath = new Location ("Warstead Mountain Path", "You look out and see a beatiful view of the valley of Polaris, whilst a looming dark tower lies ahead.", null,player,goblin,false,null);
		Location IronfallGate = new Location ("Ironfall Gate", "A large, black ironed gate readily stands in front of the looming tower of Ironfall. Ahead is the entrance!",key,player,null,false,null);
		Location IronfallDoor = new Location("Door to Ironfall", "A tall, dark door stands in your way of the dark citadel.",null,player,null,true,key);
		Location IronfallInterior = new Location("Ironfall Atrium", "You stand in the darkly lit atrium of the tower of Ironfall!", null,player,bat,false, null);
		
		//World 
		World polaris = new World();
		polaris.places.add(Riverwood);
		polaris.places.add(Northpath);
		polaris.places.add(Havenfall);
		polaris.places.add(Warstead1);
		polaris.places.add(Warstead2);
		polaris.places.add(Cliffpath);
		polaris.places.add(IronfallGate);	
		polaris.places.add(IronfallDoor);
		polaris.places.add(IronfallInterior);
		
		
		/*
		 * =================================================================================
		 * Character Creation Methods
		 * =================================================================================
		 */
		
		System.out.println("===============Faraway===============\n");
		System.out.println("Welcome to the world of Polaris\nWhat is your name?");
		player.setName(scan.nextLine());
		System.out.println(player.getName());
		
		creator.SetPlayerRace(player, scan);
		creator.SetPlayerClass(player, scan);
		creator.SetPlayerStats(player, scan);
		System.out.println("\nType anything to start the game, " +player.name+", if you dare!");
		charChoice =scan.next().charAt(0);
		
		
		
		/*
		 * 
		 * =================================================================================
		 * Game
		 * =================================================================================
		 * 
		 */
		int travel = 0;//Travel variable for game
		do {
			
			var currentPlace = polaris.places.get(travel);//Variable of the world's arraylist of places and where it is currently
			/*
			 * An nested if statement to check for locks or blocks
			 */
			if (travel< 0 || travel>=polaris.places.size() ||currentPlace.isLocked ==true) {
				System.out.println("You cannot go this way!");
				if (travel<0) {
					travel = travel+1;
				}
				if(travel>=polaris.places.size()) {
					travel = travel-1;
				}
				if(currentPlace.isLocked ==true) {
					System.out.println("The door is locked!");
					travel = travel -1;
				}
				else if(currentPlace.isLocked ==false) {
					System.out.println("The door is unlocked!");
				}
			}
			System.out.println("\n"+"=================" + currentPlace.placeName+"=================");//Place name
			System.out.println(currentPlace.flavorText);//Place Flavor Text
			currentPlace.checkEnemy();//Places check enemy method!
			currentPlace.checkLock();
			System.out.println("Your Health: " + player.getHealth());//Player's health
			System.out.println("Gold: " + player.getGold()+"\n"); //Player's gold amount
			//List of controls
			System.out.println("Controls:\n"
					+ "1.North\n"
					+ "2.South\n"
					+ "3.Pickup\n"
					+ "4.Inventory\n"
					+ "5.Show Stats\n"
					+ "6.Equip\n7.Shop\n"
					+ "8.Tavern\n"
					+ "9.Exit\n"
					+ "0.Help");
			
			
			charChoice = scan.next().charAt(0);//User input variable declaration
			/*
			 * Switch case for user input and game controls 
			 */
			switch(charChoice) 
			{
			case '1':
				travel = travel+1;//Adds one to travel index
				break;
			case '2':
				travel = travel-1;//subtracts from travel to go backwards in the array
				break;
			case '3':
				player.Pickup(currentPlace);//Pickups up the current Places' item
				break;
			case '4':
				player.getInventory();//Displays the player's current inventory
				break;
			case '5':
				creator.getStats(player);//Displays the player's stats
				break;
			case '6':
				player.Equip(scan, player);//Equips an item from the player's inventory
				break;
			case '7':
				//declares a shop variable for if a Place has a shop
				var shop = currentPlace.getShop();
				//if statement for if the places' shop parameter is null or if it is set to a certain ship.
				if (shop == null) {
					System.out.println("There is no Shop here!");
				}
				else {
				System.out.println(shop.shopName);
				shop.BuyItems(player, scan);
				break;
				}
			case '8':
				//Variable for tavern of the current place's tavern.
				var tavern = currentPlace.getTavern();
				if (tavern == null) {
					System.out.println("There is no Tavern here!");
				}
				else {
					System.out.println(tavern.tavernName);
					tavern.Rest(player, scan);
				}
				break;
			case '9':
				System.exit(0);//Quits the loop and ends program
				break;
			case'0'://This is the controls display
				System.out.println("*Help*");
				System.out.println("Controls: \n");
				System.out.println("1 : Move North\n"
						+ "2 : Move South\n"
						+ "3 : Pick up an item\n"
						+ "4 : Show Inventory\n"
						+ "5 : Show player stats\n"
						+ "6 : Equip an item/weapon\n"
						+ "7 : If in a village, access a shop!\n"
						+ "8 : If in a village, access the tavern!\n"
						+ "9 : Quit game!\n"
						+ "0 : Help panel\n");
				break;
				
			default:
				//Prints an invalid statement
				System.out.println("Invalid Input! Try 10 for help!");
				break;
			}
		}while(charChoice != '9');
		
		
	}
	
	
}
