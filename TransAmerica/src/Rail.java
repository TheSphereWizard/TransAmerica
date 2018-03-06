
public class Rail {
	Position p1, p2;
	Player player;
	int size;//0 is not placed, 1 is placed, 2 is double rail
	Rail(Position P1, Position P2, Player p, int Size){
		p1 = P1;
		p2 = P2;
		player = p;
		size = Size;
	}
}
