import java.util.ArrayList;

/*Abstract Player (players and strategy){
	ArrayList<City> cityGoal
ArrayList<City> cityReached//added in order (also only needed cities)
Boolean PlacedMarkerAlready.
	Rail[] runTurn()//starts round, waits for input if human, and then updates rails and Grid
	Void clearForNewRound
Void updatePlayer
String playerName(){}

Int[] startMarker;
Int[] getStartMarker();
} */
public abstract class Player {
	
	ArrayList<City> cityGoal;
	ArrayList<City> cityReached;
	boolean placedMarkerAlready;
	Position startMarker;
	int score;
	MapofUSA map;
	
	abstract Rail[] runTurn();
	void clearForNewRound(ArrayList<City> cities){
		cityGoal = cities;
		cityReached.clear();
		placedMarkerAlready = false;
	}
	abstract void updatePlayer();
	abstract String playerName();
	abstract Position getStartMarker();
	

	
	public class PlayerRecord {
		//Should store player's color, cities, score, and other information as needed.
		
		public PlayerRecord() {
			
		}
	}

}
