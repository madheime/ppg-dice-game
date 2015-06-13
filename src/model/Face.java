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
	
	/**
	 * Constructs a face of a given color.
	 * 
	 * @param color The color of the face of the die.
	 */
	public Face(Colors color) {
		this.setColor(color);
	}

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}
	
	
	
	
}
