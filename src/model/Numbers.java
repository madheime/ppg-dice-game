package model;

/**
 * Possible numbers on a face of a die.
 * @author Matthew
 *
 */
public enum Numbers {
	ONE(1), TWO(2), THREE(3), FOUR, FIVE, 
	SIX, SEVEN, EIGHT, NINE, TEN, 
	ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, 
	SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN, TWENTY(20);
	
	private int number;
	
	private Numbers(){
		
	}
	
	private Numbers(int number){
		this.number = number;
	}
}
