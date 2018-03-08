import java.awt.Color;
import java.util.ArrayList;

public class HardStrategy extends ComputerPlayer {
	int[] allScores;
	public HardStrategy(Color c, ArrayList<City> cities, int score, int[] allScores, String name) {
		super(c, cities, score, name);
		this.allScores = allScores;
	}

	Rail runTurn(boolean firstRailPlaced, ReadOnlyGrid grid) {
		ArrayList<Rail> totalRails = scanRails(getRailsAtPos(startMarker),startMarker, grid);
		int minDistance = 100;
		Rail nextRail = null;
		for(Rail r: totalRails){//check the distance to city, set min and nextRail if this rail is closer than previous
			for(City c: this.record.getCities()){
				int distance = distanceToCity(r,c);
				if(distance<minDistance){
					minDistance = distance;
					nextRail = r;
				}
			}
			
		}
		return nextRail;
	}
	
	public int distanceToCity(Rail rail, City city) {
		//returns distance from rail to city
		return null;
	}

}
