package model;

/**
 * Possible numbers on a face of a die.
 * @author Matthew
 *
 */
public enum Numbers {
	ONE(1,"img/one.png"), TWO(2,"img/two.png"), THREE(3,"img/three.png"), 
	FOUR(4,"img/four.png"), FIVE(5,"img/five.png"), SIX(6,"img/six.png");
	
	private int num;
	private String path;
	
	private Numbers(){
		
	}
	
	private Numbers(int num, String path){
		this.num = num;
		this.path = path;
	}

	public int getNum() {
		return num;
	}

	public String getPath() {
		return path;
	}
}
