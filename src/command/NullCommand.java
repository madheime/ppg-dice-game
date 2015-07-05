package command;

public class NullCommand extends Command {

	public NullCommand(CommandInvoker invoker) {
		super(invoker);
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
