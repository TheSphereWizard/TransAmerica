import java.util.ArrayList;

/*
 * HumanPlayer extends Player{
Rail[] runTurn() {}
String playerName() {}
}
test
 */
public class HumanPlayer extends Player {

	HumanPlayer(String name, MapofUSA Map){
		super(name);
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
