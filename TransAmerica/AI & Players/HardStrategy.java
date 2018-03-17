import java.awt.Color;
import java.util.ArrayList;
public class HardStrategy extends ComputerPlayer {
	int[] allScores;
	public HardStrategy(Color c, ArrayList<City> cities, int[] allScores, String name) {
		super(c, cities, name);
		this.allScores = allScores;
	}
	Rail runTurn(boolean firstRailPlaced, Object grid2) {
		ReadOnlyGrid grid = null;
		try{
			grid = (ReadOnlyGrid) grid2;
		}catch(Exception e){}
		ArrayList<Rail> totalRails = scanRails();//getRailsAtPos(startMarker.p),startMarker.p, grid);
		int minDistance = 100;
		Rail nextRail = null;
		for(Rail r: totalRails){//check the distance to city, set min and nextRail if this rail is closer than previous
			for(City c: this.record.getCities()){
				int distance = distanceToCity(r,c, grid);
				if(distance<minDistance){
					minDistance = distance;
					nextRail = r;
				}
			}
		}
		return nextRail;
	}
	public int distanceToCity(Rail rail, City city, ReadOnlyGrid grid) {
		//returns distance from rail to city
		int distance = 0;
		if(grid.distbetweenpoints(rail.p1,city.getPos())>grid.distbetweenpoints(rail.p2, city.getPos())){
			distance = grid.distbetweenpoints(rail.p2, city.getPos());
		}else{
			distance = grid.distbetweenpoints(rail.p1, city.getPos());
		}
		return distance;
	}
}