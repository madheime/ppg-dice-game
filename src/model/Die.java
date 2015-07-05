package model;

import java.util.ArrayList;
import java.util.HashSet;
//import java.util.Collections;
//import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class Die {

	private ArrayList<Face> faces = new ArrayList<Face> ();
	private Face topFace;
	private Set<Colors> colors = new HashSet<Colors>();
	private String id;
	
	//may want to order collections by die value
	private Integer value;
	
	public Die(String id, ArrayList<Face> faces, Values value) {
		this.faces.addAll(0, faces);
		for (Face face: faces) {
			this.addColor(face.getColor());
		}
		this.topFace = faces.get(0);
		this.id = id;
		this.value = value.getNum();
	}
	
	/**
	 * @return ref to the list of faces
	 */
	public ArrayList<Face> getFaces() {
		return faces;
	}
	
	public String getId() {
		return id;
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
	 * @return the set of colors of faces of the die
	 */
	public Set<Colors> getColors() {
		return colors;
	}

	/**
	 * @param color the color added to the die. Should only be used by the constructor.
	 */
	public void addColor(Colors color) {
		colors.add(color);
	}
	
	public void addFace(Face face) {
		faces.add(face);
	}

	/**
	 * @return an identifying string of the form "6-sided blue/red"
	 */
	public String toString() {
		String[] colornames = new String[colors.size()];
		
		int i = 0;
		for (Colors c: colors) {
			colornames[i] = c.name();
			i++;
		}
		String faceColors = String.join("/", colornames);
		return faces.size() + "-sided " + faceColors;
	}
	
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
