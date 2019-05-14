
public enum Month_table {
	JANUARY(31),
	FEBURARY(28),
	MARCH(31),
	APRIL(30),
	MAY(31),
	JUNE(30),
	JULY(31),
	AUGUST(31),
	SEPTEMBER(30),
	OCTOBER(31),
	NOVEMBER(30),
	DECEMBER(31),
	LEAPFEBURARY(29);
	
	
	private final int value;
	
	Month_table(int value){
		this.value = value;
	}
	public int getValue() {return value;}
}
