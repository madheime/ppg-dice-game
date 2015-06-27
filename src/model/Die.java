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
	
	public Die(String id, ArrayList<Face> faces) {
		this.faces.addAll(0, faces);
		for (Face face: faces) {
			this.addColor(face.getColor());
		}
		this.topFace = faces.get(0);
		this.id = id;
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
	
	// TODO
	/*
	public String toString() {
		Colors[] colores = values();
		String[] colornames = new String[colors.size()];
		
		for (int i = 0; i < colornames.length; i++) {
			colornames[i] = colors[i].name();
		}
		String faceColors = String.join("/", new Vector<Colors>(colors).toArray().collect().toString());
		return faces.size() + "-side " + faceColors;
	}
	*/
}
