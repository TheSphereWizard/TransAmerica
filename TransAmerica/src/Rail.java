
public class Rail {
	Position p1, p2;
	Player player;
	int size;//0 is not placed, 1 is placed, 2 is double rail

	Rail(Position P1, Position P2, Player p) throws Exception{
		if(Grid.legalRail(P1,P2)){
		p1 = P1;
		p2 = P2;
		player = p;
		size = Grid.checkiflargeornot(P1,P2);
		}else{
			throw new Exception();
		}
	}
}
