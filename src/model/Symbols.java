package model;

public enum Symbols {
	DOLLAR_SIGN("img/dollar_sign.png"), KEY("img/key.png"), 
	PLANET("img/planet.png"), RAINBOW("img/rainbow.png");
	
	private String path;
	
	private Symbols(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
}
