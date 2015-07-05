package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import command.Command;
import command.Commands;
import controller.DraftController;

public class Player {

	private String name;
	private String id;
	
	//seating
	private Player left;
	private Player right;
	
	//play collections
	private Collection stash = new Collection();
	private Collection draftHand = new Collection();


	private static final org.apache.logging.log4j.Logger LOG = LogManager
			.getLogger(Player.class);

	public Player(String name, String id) {
		this.setName(name);
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void takeDie(Die die, List<Die> source) {
		if (source.contains(die)) {
			stash.add(die);
			source.remove(die);
		} else {
			LOG.debug(name + " tried to take die " + die.getId()
					+ " but couldn't find it in the source list.");
		}
	}

	public Collection getDraftHand() {
		return draftHand;
	}

	public void setDraftHand(Collection draftHand) {
		this.draftHand = draftHand;
	}

}
