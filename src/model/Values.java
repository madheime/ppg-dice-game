package model;

public enum Values {
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
	
	private Integer num;
	
	private Values(Integer num) {
		this.num = num;
	}
	
	public Integer getNum() {
		return this.num;
	}
	
}
