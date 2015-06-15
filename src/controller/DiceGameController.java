package controller;

import javax.swing.JFrame;

import model.DiceGame;

public class DiceGameController {
	
	private DiceGame game;
	private JFrame frame;
	
	public DiceGameController(JFrame frame, DiceGame game) {
		this.game = game;
		this.frame = frame;
	}

}
