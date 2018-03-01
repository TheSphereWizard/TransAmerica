import java.util.ArrayList;

/*
 * HumanPlayer extends Player{
Rail[] runTurn() {}
String playerName() {}
}
test
 */
public class HumanPlayer extends Player {

	Rail[] runTurn() {
		return null;
	}

	void clearForNewRound(ArrayList<City> cities) {
		cityGoal = cities;
		cityReached.clear();
		placedMarkerAlready = false;
	}

	void updatePlayer() {
		
	}

	String playerName() {
		return null;
	}

	@Override
	Position getStartMarker() {
		// TODO Auto-generated method stub
		return null;
	}

}
