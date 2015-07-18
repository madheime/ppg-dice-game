package command;

import model.Player;

public class PassRightCommand extends Command {
	
	
	private Player passer;
	
	public PassRightCommand(CommandInvoker invoker, Player passer) {
		super(invoker);	
		this.passer = passer;
	}
	
	
	@Override
	public void executeThis() {
		// TODO Auto-generated method stub

	}

	@Override
	public void undoThis() {
		// TODO Auto-generated method stub

	}

}
