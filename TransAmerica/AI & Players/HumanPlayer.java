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
	HumanPlayer(Color c, ArrayList<City> cities, String name, MapofUSA Map){
		super(c, cities, name);
		map = Map;
	}
	Object runTurn(boolean firstPlacedRail, ReadOnlyGrid grid) {
		//accesses lastClick to map until it isn't null
		Object nextRail = null;
		while(nextRail == null){
			nextRail = map.returnPlacedRail();
		}
		return nextRail;
	}
	
//	Position getStartMarker() {
//		return null;
//	}

}
