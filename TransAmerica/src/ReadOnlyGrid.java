
public class ReadOnlyGrid {
	private Grid grid;
	ReadOnlyGrid(Grid r){
		grid=r;
	}
	boolean checkRail(Rail r, Player p){
		return grid.checkRail(r, p);
	}
}
