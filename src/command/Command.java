package command;

import java.util.ArrayList;
import java.util.ListIterator;

public abstract class Command {
	
	private CommandInvoker invoker;
	
	private ArrayList<Command> next;
	
	public Command(CommandInvoker invoker) {
		this.invoker = invoker;
	}
	
	public void execute() {
		this.executeThis();
		for (Command command: this.next) {
			command.execute();
		}
	}
	
	
	public void undo() {
		for (ListIterator<Command> iterator = this.next.listIterator(this.next.size()); iterator.hasPrevious();) {
			Command command = iterator.previous();
			command.undo();
		}
		this.undoThis();	
	}
	
	public abstract void executeThis();
	
	public abstract void undoThis();
	
}
