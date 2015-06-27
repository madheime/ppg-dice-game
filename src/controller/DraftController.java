package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import command.Commands;

import main.StartFrameController;
import model.DiceGame;
import model.Die;
import model.Player;

public class DraftController {
	
	private DiceGame game;
	private Map<Player, ArrayList<Die>> hands = new HashMap<Player, ArrayList<Die>>();
	
	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(DraftController.class);
	
	public DraftController(DiceGame game, Map<Player, ArrayList<Die>> hands) {
		this.game = game;
		this.hands = hands;
	}
	
	
	
	public void draft() {
		
		//while some player still has dice left in hand
		
		//iterate through the list of players
		
		//let them choose a die
		
		//then they pass their hand or discard it
		
		
	}

	private void passHands() {
		
		LOG.debug("Before passing hands: " + hands);
		
		ArrayList<Die> lastHand = new ArrayList<Die>();
		Player currentPlayer = new Player(null, null);
		Player firstPlayer = new Player(null, null);
		boolean first = true;
		Iterator<Map.Entry<Player, ArrayList<Die>>> it = hands.entrySet().iterator();
	    while (it.hasNext()) {
	    	
	        Map.Entry<Player, ArrayList<Die>> pair = it.next();
	        currentPlayer = pair.getKey();
	        
	        //pass a new version of the current hand (so that it doesn't get overwritten by reference)
	        lastHand = new ArrayList<Die>(pair.getValue());
	        
	        
	        //save the first player for later
	        if (first) {
	    		firstPlayer = currentPlayer;
	    		first = false;
	    	}
	        else {
	        	//if it's not the first player, make their hand the previous hand
	        	// new should prevent accidentally changing by reference
	        	hands.put(currentPlayer, new ArrayList<Die>(lastHand));
	        }
	        
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	    //after looping through the whole group, the first player is passed the last player's hand.
	    hands.put(firstPlayer, new ArrayList<Die>(lastHand));    
	    
	    LOG.debug("After passing hands: " + hands);
	}
	
	
	private void discardLastCards() {
		Iterator<Map.Entry<Player, ArrayList<Die>>> it = hands.entrySet().iterator();
	    while (it.hasNext()) {
	    	
	        Map.Entry<Player, ArrayList<Die>> pair = it.next();
	        ArrayList<Die> currentHand = pair.getValue();
	        
	        if (currentHand.size() == 1) {
	        	pair.getKey().receiveCommand(Commands.DISCARD_HAND);
	        }
	        

	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public void playerTakesDie(Player player, Die die, List<Die> source) {
		player.takeDie(die, source);
	}
	
	
	
}
