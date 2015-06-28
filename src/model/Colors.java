package model;

import java.awt.Color;

public enum Colors {
	RED(Color.RED), GREEN(Color.GREEN), BLUE(Color.BLUE), YELLOW(Color.YELLOW);
	
	private Color color;
	
	private Colors(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
}
