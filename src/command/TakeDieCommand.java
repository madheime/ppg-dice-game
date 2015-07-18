package command;

import model.Player;

public class TakeDieCommand extends Command {

	
	public TakeDieCommand(CommandInvoker invoker, Player player) {
		super(invoker);
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
