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
		while(map.returnplacedRail() == null){
		}
		Rail[] newRails = new Rail[2];
		newRails[0]=map.returnPlacedRail();
		if(newRails[0].){
			
		}
		return newRails;
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
