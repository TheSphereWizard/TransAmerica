import java.util.ArrayList;

public class ComputerPlayer extends Player {
	
	//Computer player should get copy of game state (but should not have access to other player’s hands)
	//Pass in an array of scores, a grid, and a hand to computer players
	private int[] scores;
	private Grid grid;
	private City[] cities;
	
	
	public ComputerPlayer(int[] scores, Grid grid, City[] cities) {
		super(null);
		this.scores = scores;
		this.grid = grid;
		this.cities = cities;
	}

	Rail[] runTurn() {
		return null;
	}

	void clearForNewRound(ArrayList<City> cities) {
		
	}

	void updatePlayer() {
		
	}

	String playerName() {
		return null;
	}

	@Override
	Position getStartMarker() {
		// TODO Auto-generated method stub
		return null;
	}

}
