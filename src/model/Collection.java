package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection {
	
	
	private ArrayList<Die> dice = new ArrayList<Die>();
	
	//<value, position>   acts as benchmarks for sorting the Array into bins
	private HashMap<Integer, Integer> valuePositions = new HashMap<Integer, Integer>();
	
	public Collection() {
		for (Values value: Values.values()) {
			valuePositions.put(value.getNum(), 0);			
		}
	}
	
	public Collection(Collection collection) {
		this.dice = new ArrayList<Die>(collection.getDice());
		this.valuePositions = new HashMap<Integer, Integer>(collection.getValuePositions());
	}
	
	

	//TODO decide about maintaining die uniqueness
	public void add(Die die) {
		dice.add(this.valuePositions.get(die.getValue()), die);
		this.incrementValuePositions(die.getValue());
		
	}
	
	public void remove(Die die) {
		dice.remove(die);
		this.decrementValuePositions(die.getValue());
	}
	
	
	private void incrementValuePositions(Integer value) {
		for (Integer benchmark: this.valuePositions.keySet()) {
			if (benchmark > value) {
				this.valuePositions.put(benchmark, this.valuePositions.get(benchmark) + 1);
			}
		}
	}
	
	
	private void decrementValuePositions(Integer value) {
		for (Integer benchmark: this.valuePositions.keySet()) {
			if (benchmark > value) {
				this.valuePositions.put(benchmark, this.valuePositions.get(benchmark) - 1);
			}
		}	
	}
	
	
	
	public HashMap<Integer, Integer> getValuePositions() {
		return valuePositions;
	}

	public void setValuePositions(HashMap<Integer, Integer> valuePositions) {
		this.valuePositions = valuePositions;
	}
	
	public ArrayList<Die> getDice() {
		return dice;
	}

	public void setDice(ArrayList<Die> dice) {
		this.dice = dice;
	}
	
	
	

}
