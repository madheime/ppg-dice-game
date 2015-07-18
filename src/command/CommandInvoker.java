package command;

import main.StartFrameController;

import org.apache.logging.log4j.LogManager;

public class CommandInvoker {

	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(CommandInvoker.class);
	
	public void invoke(Command command) {
		command.execute();	
	}
	
	
}
