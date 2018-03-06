
public class Position {
	
	public int x, y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equals(Position compare) {
		if(x == compare.x && y == compare.y)
			return true;
		return false;
	}

}
