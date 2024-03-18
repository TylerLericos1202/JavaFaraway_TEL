/**
*@author Tyler Lericos
*@version 1.0
*Interfaces 
*Spring Semester/Freshman
*/
public class Village extends Places{

	Shop shop;
	Tavern tavern;
	
	public Village() {
		// TODO Auto-generated constructor stub
	}
	public Village(String placeName, String flavorText, Shop shop, Tavern tavern, Item item, Player player,Enemy enemy,boolean isLocked,Item key) {
		super(placeName, flavorText, item,player, enemy,isLocked, key);
		this.shop = shop;
		this.tavern = tavern;
	}
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Tavern getTavern() {
		return tavern;
	}
	public void setTavern(Tavern tavern) {
		this.tavern = tavern;
	}


	
	
	

	
}
