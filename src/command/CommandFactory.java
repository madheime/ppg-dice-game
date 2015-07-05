package command;

import main.StartFrameController;

import org.apache.logging.log4j.LogManager;

public class CommandFactory {

	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(CommandFactory.class);
	
	private CommandInvoker invoker;
	
	public Command generate(Commands commandType) {
		
		Command command = new NullCommand(this.invoker);
		
		switch(commandType) {
		case CONVENE:
			break;
		case DISCARD_DIE:
			break;
		case DISCARD_HAND:
			break;
		case EXPLODE:
			break;
		case LOSE_GAME:
			break;
		case PASS_LEFT:
			break;
		case PASS_RIGHT:
			break;
		case TAKE_DIE:
			break;
		case WIN_GAME:
			break;
		default:
			LOG.error("invoke reached default case");
			break;
		}
		
		return command;
			
	}
	
	
}
