import java.util.ArrayList;
import java.util.Arrays;
/**
*@author Tyler Lericos
*@version 1.0
*Interfaces 
*Spring Semester/Freshman
*/
public class World {
	
	String worldName;
	ArrayList<Places> places = new ArrayList<Places>();//Hold type Places and its children

	public World(){
	}
	
	/*
	 * World constructor with parameters for worldName and ArrayList<Places>
	 */
	public World(String worldName, ArrayList<Places> T) {
		super();
		this.worldName = worldName;
		this.places = T;
	}
	/*
	 * ============================================
	 * Getters and Setters
	 * ============================================
	 */
	public String getWorldName() {
		return worldName;
	}

	public void setWorldName(String worldName) {
		this.worldName = worldName;
	}

	public ArrayList<Places> getPlaces() {
		return places;
	}

	public void setPlaces(ArrayList<Places> T) {
		this.places = T;
	}
	

	
	
	
	
	
	
}
