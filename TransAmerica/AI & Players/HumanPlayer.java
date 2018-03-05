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
	
	Rail[] runTurn() {
		//accesses lastClick to map until it isn't null
		Rail nextRail = null;
		while(nextRail == null){
			nextRail = map.returnPlacedRail();
		}
		Rail[] newRails = new Rail[2];
		newRails[0]=nextRail;
		if(newRails[0].size == 1){//if it was a single rail, place the second one
			nextRail = null;
			while(nextRail == null){
				nextRail = map.returnPlacedRail();
			}
			newRails[1]=nextRail;
		}
		return newRails;
	}

	void updatePlayer() {
		
	}
	
	Position getStartMarker() {
		return null;
	}

}
