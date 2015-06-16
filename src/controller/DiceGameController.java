package controller;

import view.FileInputFrame;
import model.DiceGame;
import model.Player;

public class DiceGameController {
	
	private DiceGame game;
	private FileInputFrame frame;
	
	public DiceGameController(FileInputFrame frame, DiceGame game) {
		this.game = game;
		this.frame = frame;
		initializePlayers();
	}
	
	
	private void initializePlayers() {
		for(Integer i = 1; i <= frame.getPlayerNumberSelected(); i++) {
			Player player = new Player("Player" + i.toString(), "P" + i.toString());
			game.addPlayer(player);
		}
	}
	
	

}
