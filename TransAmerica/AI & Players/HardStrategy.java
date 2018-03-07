import java.awt.Color;
import java.util.ArrayList;

public class HardStrategy extends ComputerPlayer {
	int[] allScores;
	public HardStrategy(Color c, ArrayList<City> cities, int score, int[] allScores, String name, Grid grid) {
		super(c, cities, score, name, grid);
		this.allScores = allScores;
	}

	Rail runTurn() {
		ArrayList<Rail> totalRails = scanRails(getRailsAtPos(startMarker),startMarker);
		int minDistance = 100;
		Rail nextRail = null;
		for(Rail r: totalRails){
			//check the distance to city, set min and nextRail if this rail is closer than previous
		}
		return nextRail;
	}

}
