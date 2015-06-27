package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DraftFrame;
import view.FileInputFrame;
import model.DiceGame;
import model.Player;

public class DiceGameController {
	
	private DiceGame game;
	private FileInputFrame frame;
	private DraftFrame draftFrame;
	
	public DiceGameController(FileInputFrame frame, DiceGame game) {
		this.game = game;
		this.frame = frame;
		initializePlayers();
		this.frame.addStartActionListener(new StartListener());
	}
	
	

	/**
	 * Inner class that handles the action performed event of Start button
	 * 
	 */
	class StartListener implements ActionListener {

		/**
		 * Method that handles the click event of Start button
		 * 
		 * @param e ActionEvent object
		 * @throws CloneNotSupportedException Clone Not Supported Exception
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//TODO
			// code that starts the draft
			//
			
			
			
			frame.dispose();
			DraftFrame draftFrame = new DraftFrame();
			draftFrame.setVisible(true);
		}
	}
	
	private void initializePlayers() {
		for(Integer i = 1; i <= frame.getPlayerNumberSelected(); i++) {
			Player player = new Player("Player" + i.toString(), "P" + i.toString());
			game.addPlayer(player);
		}
	}
	
	

}
