/**
*@author Tyler Lericos
*@version 1.0
*Interfaces 
*Spring Semester/Freshman
*/
public class Item {
	public  String name;
	int quantity;
	int cost;
	int damage;
	itemType itemType;
	
	//Enum for itemTypes
	enum itemType{
		KEY,
		WEAPON,
		ARMOR,
		GOLD
	}
	//Constuctor
	public Item(String name, int quantity, int cost, int damage) 
	{
		this.name =name;
		this.quantity = quantity;
		this.cost = cost;
		this.damage = damage;
	}
	/*
	 * getter
	 */
	public itemType getItemType() {
		return itemType;
	}
	/*
	 * Setter
	 */
	public void setItemType(itemType itemType) {
		this.itemType = itemType;
	}
	
	
	
}
