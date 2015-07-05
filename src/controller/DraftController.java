package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import command.CommandInvoker;
import command.Commands;
import main.StartFrameController;
import model.Collection;
import model.DiceGame;
import model.Die;
import model.Player;

public class DraftController {
	
	private DiceGame game;
	private CommandInvoker invoker;
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
				
				//then they pass their hand or discard it
				if (player.getDraftHand().size() == 1) {
					player.receiveCommand(invoker.invoke(this.passingDirection));
				}
				else {
					player.receiveCommand(invoker.invoke(Commands.PASS_LEFT));
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
	
	private void passHands() {
		
		LOG.debug("Before passing hands: " + hands);
		
		Collection lastHand = new Collection();
		Player currentPlayer = new Player(null, null);
		Player firstPlayer = new Player(null, null);
		boolean first = true;
		Iterator<Map.Entry<Player, Collection>> it = hands.entrySet().iterator();
	    while (it.hasNext()) {
	    	
	        Map.Entry<Player, Collection> pair = it.next();
	        currentPlayer = pair.getKey();
	        
	        //pass a new version of the current hand (so that it doesn't get overwritten by reference)
	        lastHand = new Collection(pair.getValue());
	        
	        
	        //save the first player for later
	        if (first) {
	    		firstPlayer = currentPlayer;
	    		first = false;
	    	}
	        else {
	        	//if it's not the first player, make their hand the previous hand
	        	// new should prevent accidentally changing by reference
	        	hands.put(currentPlayer, new Collection(lastHand));
	        }
	        
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	    //after looping through the whole group, the first player is passed the last player's hand.
	    hands.put(firstPlayer, new Collection(lastHand));    
	    
	    LOG.debug("After passing hands: " + hands);
	}
	
	
	private void discardLastCards() {
		Iterator<Map.Entry<Player, Collection>> it = hands.entrySet().iterator();
	    while (it.hasNext()) {
	    	
	        Map.Entry<Player, Collection> pair = it.next();
	        Collection currentHand = pair.getValue();
	        
	        if (currentHand.size() == 1) {
	        	pair.getKey().receiveCommand(invoker.invoke(Commands.DISCARD_HAND));
	        }
	        

	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public void playerTakesDie(Player player, Die die, List<Die> source) {
		player.takeDie(die, source);
	}
	
	
	
}
