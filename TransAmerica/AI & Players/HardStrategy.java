import java.awt.Color;
import java.util.ArrayList;

public class HardStrategy extends ComputerPlayer {
	int[] allScores;
	public HardStrategy(Color c, ArrayList<City> cities, int score, int[] allScores, String name, Grid grid) {
		super(c, cities, score, name, grid);
		this.allScores = allScores;
	}

	Rail runTurn() {
		return null;
	}

}
