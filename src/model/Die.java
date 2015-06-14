package model;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
import java.util.Random;

public class Die {

	private ArrayList<Face> faces = new ArrayList<Face> ();
	private Face topFace;
	private Colors color;
	
	public Die(ArrayList<Face> faces, Colors color) {
		this.faces.addAll(0, faces);
		this.setColor(color);
		this.topFace = faces.get(0);
	}
	
	/**
	 * @return ref to the list of faces
	 */
	public ArrayList<Face> getFaces() {
		return faces;
	}
	
	/**
	 * Set a new top face randomly
	 * @return ref to the new top face
	 */
	public Face roll() {
		topFace = faces.get(new Random().nextInt(faces.size()));
		return topFace;
	}
	
	/**
	 * @return ref to the current top face
	 */
	public Face getTopFace() {
		return topFace;
	}
	
	/**
	 * @return the color
	 */
	public Colors getColor() {
		return color;
	}

	/**
	 * @param color the color of the die. Should only be used by the constructor.
	 */
	public void setColor(Colors color) {
		this.color = color;
	}
	
}
