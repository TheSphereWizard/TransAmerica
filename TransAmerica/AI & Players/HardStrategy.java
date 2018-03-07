import java.awt.Color;
import java.util.ArrayList;

public class HardStrategy extends ComputerPlayer {

	public HardStrategy(Color c, ArrayList<City> cities, int score, int[] scores, String name, Grid grid) {
		super(c, cities, score, scores, name, grid);
	}

	Rail runTurn() {
		return null;
	}

}
