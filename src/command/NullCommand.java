package command;

public class NullCommand extends Command {

	public NullCommand(CommandInvoker invoker) {
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
