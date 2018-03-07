import java.awt.Color;
import java.util.ArrayList;

/*
 * HumanPlayer extends Player{
Rail[] runTurn() {}
String playerName() {}
}
test
 */
public class HumanPlayer extends Player {
	HumanPlayer(Color c, ArrayList<City> cities, int score, String name, MapofUSA Map){
		super(c, cities, score, name);
		map = Map;
	}
	Rail runTurn() {
		//accesses lastClick to map until it isn't null
		Rail nextRail = null;
		while(nextRail == null){
			nextRail = map.returnPlacedRail();
		}
		return nextRail;
	}
	
	Position getStartMarker() {
		return null;
	}

}
