import java.util.ArrayList;

public class ReadOnlyGrid {
	private Grid grid;
	ReadOnlyGrid(Grid r){
		grid=r;
	}
	boolean checkRail(Rail r, Player p){
		return grid.checkRail(r, p);
	}
	int[] railsMissing(ArrayList<Player> players){
		return grid.railsMissing(players);
	}
	ArrayList<Rail> immediateneighbors(Position p){
		return grid.immediateneighbors(p);
	}
	int distbetweenpoints(Position p1, Position p2){
		return grid.distbetweenpoints(p1, p2);
	}
	ArrayList<Rail> allValidMovesforPlayer(Player p){
		try{
			return grid.allValidMovesForPlayer(p);//Why doesn't this work for comp players
		}catch(Exception E){return null;}
	}
	boolean RailExists(Position p1, Position p2) {
		return grid.RailExists(p1, p2);
	}
}
