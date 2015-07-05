package command;

import main.StartFrameController;
import model.Player;

import org.apache.logging.log4j.LogManager;

public class CommandFactory {

	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(CommandFactory.class);
	
	private CommandInvoker invoker;
	
	public void generate(Commands commandType) {
		
		Command command = new NullCommand(this.invoker);
		
		switch(commandType) {
		case DISCARD_DIE:
			break;
		case DISCARD_HAND:
			break;
		case PASS_LEFT:
			break;
		case PASS_RIGHT:
			break;
		case TAKE_DIE:
			break;
		default:
			LOG.error("invoke reached default case");
			break;
		}
		
		invoker.invoke(command);
			
	}
	
	
	public void generate(Commands commandType, Player player) {
		
		Command command = new NullCommand(this.invoker);
		
		switch(commandType) {
		case DISCARD_DIE:
			break;
		case DISCARD_HAND:
			break;
		case PASS_LEFT:
			break;
		case PASS_RIGHT:
			break;
		case TAKE_DIE:
			break;
		default:
			LOG.error("invoke reached default case");
			break;
		}
		
		invoker.invoke(command);
		
	}
	
	
}
