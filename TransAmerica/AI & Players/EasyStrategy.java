import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class EasyStrategy extends ComputerPlayer{
	public EasyStrategy(Color c, ArrayList<City> cities, int score, String name) {
		super(c, cities, score, name);
	}

	Rail runTurn(boolean firstRailPlaced, ReadOnlyGrid grid) {
		ArrayList<Rail> totalRails = scanRails(getRailsAtPos(startMarker),startMarker, grid);//totalRails contains all the rails to be checked
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
