import java.awt.Color;

public class City {
	
	private String name;
	Position p;
	Color color;
	
	public City(String name, Position pos, Color color) {
		this.name = name;
		this.p = pos;
		this.color = color;
	}
	
	String getName(){
		return name;
	}
	
	Position getPos(){
		return p;
	}
}
