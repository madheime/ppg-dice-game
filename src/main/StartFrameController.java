package main;

import java.awt.EventQueue;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import view.DraftFrame;
import view.FileInputFrame;
import model.DiceFileReader;
import model.DiceGame;
import controller.DiceGameController;

public class StartFrameController
{
	
	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(StartFrameController.class);
	
	
	public static void main(String[] args)
	{
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				LOG.info("Everything's goin' well so far.");

				// create initial view
				FileInputFrame fileInputFrame = new FileInputFrame();				

				// create model
				DiceGame diceGame = new DiceGame();
				
				DiceFileReader dfr = new DiceFileReader("data/DiceData.xlsx",diceGame);
				
				// create controller for initial view
				DiceGameController DiceGameController = new DiceGameController(fileInputFrame, diceGame);

				fileInputFrame.setVisible(true);

			}
		});
	}
}
