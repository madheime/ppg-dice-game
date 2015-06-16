package model;

import java.util.HashMap;

public class DiceGame {

	private HashMap<String, Die> dice = new HashMap<String,Die>();
	private HashMap<String, Player> players = new HashMap<String,Player>();
	
	
	public DiceGame() {

		
	}
	
	public void addPlayer(Player player){
		this.players.put(player.getId(),player);
	}
	
}
