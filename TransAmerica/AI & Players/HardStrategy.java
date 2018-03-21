import java.awt.Color;
import java.util.ArrayList;
public class HardStrategy extends ComputerPlayer {
	int[] allScores;
	public HardStrategy(Color c, ArrayList<City> cities, int[] allScores, String name) {
		super(c, cities, name);
		this.allScores = allScores;
	}
	Object runTurn(boolean firstturn,boolean firstRailPlaced, Object grid2) {
		ReadOnlyGrid grid = null;
		try{
			grid = (ReadOnlyGrid) grid2;
		}catch(Exception e){}
		if(firstturn){
			Marker m=new Marker(record.cities.get(2).p,this);
			return m;
		}else{
			ArrayList<Rail> totalRails = grid.allValidMovesforPlayer(this);//getRailsAtPos(startMarker.p),startMarker.p, grid);
			int minDistance = 100000;
			Rail nextRail;
			try {
				nextRail = new Rail(new Position(0,0),new Position(0,1));
			} catch (Exception e) {
				nextRail=null;
			}
			for(Rail r: totalRails){//check the distance to city, set min and nextRail if this rail is closer than previous
				for(City c: this.record.getCities()){
					if(!record.citiesReached.contains(c)){
						int distance = distanceToCity(r,c, grid);//DONT TRUST THIS VALUE<
						//THIS VALUE APPEARS TO SOMETIMES BE WRONG, NEEDS TO BE TESTED AND FIXED
						if(distance<minDistance){
							minDistance = distance;
							nextRail = r;
						}
					}
				}
			}
			return nextRail;
		}
		
	}
	public int distanceToCity(Rail rail, City city, ReadOnlyGrid grid) {
		//returns distance from rail to city
//		int distance = 0;
//		if(grid.distbetweenpoints(rail.p1,city.getPos())>grid.distbetweenpoints(rail.p2, city.getPos())){
//			distance = grid.distbetweenpoints(rail.p2, city.getPos());
//		}else{
//			distance = grid.distbetweenpoints(rail.p1, city.getPos());
//		}
		return Math.min(grid.distbetweenpoints(rail.p1,city.getPos()), grid.distbetweenpoints(rail.p2, city.getPos()));
	}
}