import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class EasyStrategy extends ComputerPlayer{
	public EasyStrategy(Color c, ArrayList<City> cities, String name) {
		super(c, cities, name);
	}

	Rail runTurn(boolean firstturn,boolean firstRailPlaced, Object grid2) {
		ReadOnlyGrid grid = null;
		try{
			grid = (ReadOnlyGrid) grid2;
		}catch(Exception e){
			
		}
		ArrayList<Rail> totalRails = scanRails();//getRailsAtPos(startMarker.p),startMarker.p, grid);//totalRails contains all the rails to be checked
		if(firstRailPlaced){
			for(Rail r: totalRails){
				if(r.size==2){
					totalRails.remove(r);
				}
			}
		}
		Random rand = new Random();
		int pos = rand.nextInt(totalRails.size()+1);
		return totalRails.get(pos);
	}


}
