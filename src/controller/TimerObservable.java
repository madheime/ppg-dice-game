package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.Timer;

import model.DiceGame;

import java.util.LinkedList;

/**
 * 
 * @author
 *
 */

public class TimerObservable extends Observable {

	private DiceGame game;
	private Timer timer;
	private ControlButtons buttons;
	int count = 0;



	public TimerObservable(ControlButtons buttons) {
		this.buttons = buttons;
		this.game = new DiceGame();
		this.timer = new Timer(5, null);

	}

	
	public void computeAndNotify() {
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
					setChanged();
					notifyObservers(this);
					count++;
			}
		});
		timer.setDelay(5);
		timer.restart();

	}

	public void pauseGame() {
		this.getTimer().stop();
	}

	public void resumeGame() {
		this.getTimer().setDelay(5);
		this.getTimer().restart();
	}

	
///////////////////////////////////Getters and Setters/////////////////////////////////////////


	public DiceGame getComputeCoordinatesObj() {
		return game;
	}

	public void setComputeCoordinatesObj(
			DiceGame computeCoordinatesObj) {
		this.game = computeCoordinatesObj;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}