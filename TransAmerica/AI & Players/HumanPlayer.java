import java.util.ArrayList;

/*
 * HumanPlayer extends Player{
Rail[] runTurn() {}
String playerName() {}
}
test
 */
public class HumanPlayer extends Player {
	
	
	
	public HumanPlayer(MapofUSA map) {
		
	}

	Rail[] runTurn() {
		//accesses lastClick to map until it isn't null
		while(map.lastClicked() == null){
		}
		Position click = map.lastClicked();
		//convert to rail and return it
		return null;
	}

	void updatePlayer() {
		
	}

	String playerName() {
		return null;
	}
	
	Position getStartMarker() {
		return null;
	}

}
