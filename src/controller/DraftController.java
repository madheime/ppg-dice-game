package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import command.CommandFactory;
import command.CommandInvoker;
import command.Commands;
import main.StartFrameController;
import model.Collection;
import model.DiceGame;
import model.Die;
import model.Player;

public class DraftController {
	
	private DiceGame game;
	private CommandFactory generator;
	private Commands passingDirection = Commands.PASS_LEFT;
	
	//for debugging
	private Map<Player, Collection> hands = new HashMap<Player, Collection>();
	
	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(DraftController.class);
	
	public DraftController(DiceGame game, Map<Player, ArrayList<Die>> hands) {
		this.game = game;
		this.gatherHands();
	}
	
	
	private void gatherHands() {
		for (Player player: this.game.getPlayers().values()) {
			hands.put(player, player.getDraftHand());
		}
	}
	
	
	public void draft() {
	
		//while some player still has dice left in hand
		
		while(this.stillDrafting()) {
			
			for(Player player: game.getPlayers().values()) {
				//let them choose a die
				generator.generate(Commands.CHOOSE_DIE,player);
				
				//then they pass their hand or discard it
				if (player.getDraftHand().size() == 1) {
					generator.generate(Commands.DISCARD_HAND , player);
				}
				else {
					generator.generate(this.passingDirection, player);
				}
			}
		}
	}

	private boolean stillDrafting() {
		for (Collection hand: this.hands.values()) {
			if(hand.size() > 0) {
				return true;
			}
		}
		return false;
	}
	
	
	private void discardLastCards() {
		Iterator<Map.Entry<Player, Collection>> it = hands.entrySet().iterator();
	    while (it.hasNext()) {
	    	
	        Map.Entry<Player, Collection> pair = it.next();
	        Collection currentHand = pair.getValue();
	        
	        if (currentHand.size() == 1) {
	        	generator.generate(Commands.DISCARD_HAND, pair.getKey());
	        }
	        

	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public void playerTakesDie(Player player, Die die, List<Die> source) {
		player.takeDie(die, source);
	}
	
	
	
}
