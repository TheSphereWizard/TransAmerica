
public class ReadOnlyGrid {
	private Grid grid;
	ReadOnlyGrid(Grid r){
		grid=r;
	}
	boolean checkRail(Rail r, Player p){
		return grid.checkRail(r, p);
	}
	
	int distbetweenpoints(Position p1, Position p2){
		return grid.distbetweenpoints(p1, p2);
	}
	
	boolean RailExists(Position p1, Position p2) {
		return grid.RailExists(p1, p2);
	}
}
