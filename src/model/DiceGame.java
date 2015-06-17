package model;

import java.util.HashMap;

public class DiceGame {

	private HashMap<String,Die> dice = new HashMap<String,Die>();

	
	
	public DiceGame() {

		
	}
	
	public HashMap<String,Die> getDice() {
		return dice;
	}
	
}
