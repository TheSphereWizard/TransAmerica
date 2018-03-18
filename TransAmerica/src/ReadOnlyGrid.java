import java.util.ArrayList;

public class ReadOnlyGrid {
	private Grid grid;
	ReadOnlyGrid(Grid r){
		grid=r;
	}
	boolean checkRail(Rail r, Player p){
		return grid.checkRail(r, p);
	}
	int[] railsMissing(){
		return grid.railsMissing();
	}
	ArrayList<Rail> immediateneighbors(Position p){
		try {
			return grid.immediateneighbors(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	int distbetweenpoints(Position p1, Position p2){
		return grid.distbetweenpoints(p1, p2);
	}
	ArrayList<Rail> checkRail2(Player p){
		try{
			return grid.allValidMovesForPlayer(p);//Why doesn't this work for comp players
		}catch(Exception E){return null;}
	}
	boolean RailExists(Position p1, Position p2) {
		return grid.RailExists(p1, p2);
	}
}
