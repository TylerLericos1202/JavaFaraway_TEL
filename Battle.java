import java.util.*;

public class Battle {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	int intChoice;
	
	public Battle() {}
	/*
	 * Battle method which is a constructor
	 */
	public void Battle(Player player, Enemy enemy) {
		System.out.println("Do you wish to fight the " + enemy.name);
		System.out.println("\n1. Yes\n2. No");
		intChoice = scan.next().charAt(0);
		
		if(intChoice == '1') {
			do {
				System.out.println("Health: " + player.health);
				System.out.println(enemy.name + " health: " + enemy.health);
				System.out.println("Player Attack DEBUG: " + player.getAttack());//debug
				
				System.out.println(enemy.name + " strikes!\n");
				enemy.attack = rand.nextInt(1,20);
				player.health = player.health - enemy.attack;
				System.out.println("Your turn!\n1.Attack\n2.Equip");
				
				intChoice = scan.next().charAt(0);
				switch(intChoice) {
				case '1':
					enemy.health = enemy.health - player.getAttack();
					System.out.println("You attacked!");
					break;
				case '2':
					player.Equip(scan, player);
					break;
					default:
						System.out.println("Invalid Option");
						break;
				
				}
				if (enemy.health <= 0) {
					enemy.isDead =true;
					System.out.println("You defeated " + enemy.name);
				}
				if (player.health <=0) {
					player.isDead = true;
					System.out.println("You have died!");
					System.exit(0);
				}
		
			}while(enemy.isDead != true );
		}else if(intChoice == '2') {
			System.out.println("You ran away safely!");
		}
	}
	
	
	
}
