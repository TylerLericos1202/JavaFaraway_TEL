import java.util.*;

public class Enemy {
	
	String name;
	int health;
	int attack;
	boolean isDead = false;
	
	Item item;
	Player player;
	
	
	public Enemy() {
		
	}
	public Enemy(String name, int health, int attack, Item item) {
		super();
		this.name = name;
		this.health = health;
		this.attack = attack;
		
		this.item = item;
	}
	
	
	
	
	
}
