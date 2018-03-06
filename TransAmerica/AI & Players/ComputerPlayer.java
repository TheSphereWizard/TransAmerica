import java.util.ArrayList;

public abstract class ComputerPlayer extends Player {
	
	//Computer player should get copy of game state (but should not have access to other player’s hands)
	//Pass in an array of scores, a grid, and a hand to computer players
	private int[] scores;
	private Grid grid;
	
	public ComputerPlayer(int[] scores, Grid grid) {
		super(null);
		this.scores = scores;
		this.grid = grid;
	}

	abstract Rail[] runTurn();
	
	public ArrayList<Rail> getRailsAtPos(Position pos) {
		if(pos.x)
		
		return null;
	}

}
