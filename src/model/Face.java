package model;


/**
 * [MAY BECOME AN ABSTRACT CLASS LATER]
 * 
 * One face of a die, containing the data encoded on that face.
 * 
 * @author Matthew
 *
 */
public class Face {
	
	/** The color of the face of the die.*/
	private Colors color;	
	
	/** */
	private Numbers number;
	
	/**
	 * Constructs a face of a given color.
	 * 
	 * @param color The color of the face of the die.
	 * @param number The number displayed on the face of the die.
	 */
	public Face(Colors color, Numbers number) {
		this.setColor(color);
		this.setNumber(number);
	}

	/**
	 * 
	 * @return
	 */
	public Colors getColor() {
		return color;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(Colors color) {
		this.color = color;
	}

	public Numbers getNumber() {
		return number;
	}

	public void setNumber(Numbers number) {
		this.number = number;
	}
	
	
	
	
}
