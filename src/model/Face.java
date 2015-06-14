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
	/** The number on the face of the die.*/
	private Numbers number;

	/**
	 * Constructs a face of a given color and number.
	 * 
	 * @param color The color of the face of the die.
	 * @param number The number displayed on the face of the die.
	 */
	public Face(Colors color, Numbers number) {
		this.setColor(color);
		this.setNumber(number);
	}

	/**
	 * @return the color of the face
	 */
	public Colors getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Colors color) {
		this.color = color;
	}
	
	/**
	 * @return the number
	 */
	public Numbers getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Numbers number) {
		this.number = number;
	}

	/**
	 * @return string repr of a face
	 */
	public String toString() {
		return color + ": " + number;
	}
	
	
}
