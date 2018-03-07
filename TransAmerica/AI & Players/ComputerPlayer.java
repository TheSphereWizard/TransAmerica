import java.awt.Color;
import java.util.ArrayList;

public abstract class ComputerPlayer extends Player {
	
	//Computer player should get copy of game state (but should not have access to other player’s hands)
	//Pass in an array of scores, a grid, and a hand to computer players
	private int[] scores;
	private Grid grid;
	
	public ComputerPlayer(Color c, ArrayList<City> cities, int score, int[] scores, String name, Grid grid) {
		super(c, cities, score, name);
		this.scores = scores;
		this.grid = grid;
	}

	abstract Rail runTurn();
	
	public ArrayList<Rail> getRailsAtPos(Position pos) {
		ArrayList<Rail> rails = new ArrayList<Rail>(0);
		
		if(grid.getRail(pos, new Position(pos.x, pos.y + 1)) != null && pos.y < 15)
			rails.add(grid.getRail(pos, new Position(pos.x, pos.y + 1)));
		if(grid.getRail(pos, new Position(pos.x + 1, pos.y)) != null && pos.x < 25)
			rails.add(grid.getRail(pos, new Position(pos.x + 1, pos.y)));
		if(grid.getRail(pos, new Position(pos.x, pos.y - 1)) != null && pos.y > 0)
			rails.add(grid.getRail(pos, new Position(pos.x, pos.y - 1)));
		if(grid.getRail(pos, new Position(pos.x - 1, pos.y)) != null && pos.x > 0)
			rails.add(grid.getRail(pos, new Position(pos.x - 1, pos.y)));
		
		return rails;
	}
	
	public Grid getGrid() {
		return grid;
	}

}
