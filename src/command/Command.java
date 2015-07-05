package command;

public abstract class Command {
	
	private CommandInvoker invoker;
	
	public Command(CommandInvoker invoker) {
		this.invoker = invoker;
	}
	
	
	public abstract void execute();
	
	public abstract void undo();
	
}
