package command;

import model.Player;

public class DiscardHandCommand extends Command {

	private Player player;
	
	public DiscardHandCommand(CommandInvoker invoker, Player player) {
		super(invoker);
		this.player = player;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
