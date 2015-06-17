package model;

import java.util.ArrayList;
import java.util.HashMap;

public class DiceList {
	
	private HashMap<String,Die> diceList = new HashMap<String,Die>();
	
	public HashMap<String,Die> getDiceList() {
		return diceList;
	}
	
	public void addDie (String id, ArrayList<Face> faces) {
		diceList.put(id,new Die(id,faces));
	}
}
