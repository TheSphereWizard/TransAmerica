
public class Rail {
	Position p1, p2;
	Player player;
	int size;//0 is not placed, 1 is placed, 2 is double rail
	Rail(Position P1, Position P2) throws Exception{
		if(Grid.legalRail(P1,P2)){
			p1 = P1;
			p2 = P2;
			}else{
				throw new Exception();
			}
	}
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
	
	public boolean equals(Object compare2) {
		Rail compare;
		try{
			compare=(Rail)compare2;
		}catch(Exception e){
			return false;
		}
		if(p1.equals(compare.p1) && p2.equals(compare.p2))
			return true;
		try {
			if(compare.equals(new Rail(p2,p1)))
				return true;
		} catch (Exception e) {return false;}
		return false;
	}
	
}
