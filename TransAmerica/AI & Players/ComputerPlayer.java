import java.util.ArrayList;

public class ComputerPlayer extends Player {
	
	//Computer player should get copy of game state (but should not have access to other player’s hands)
	//Pass in an array of scores, a grid, and a hand to computer players
	
	public ComputerPlayer(int[] scores, Grid grid, City[] cities) {
		super(null);
	}

	Rail[] runTurn() {
		return null;
	}

}
