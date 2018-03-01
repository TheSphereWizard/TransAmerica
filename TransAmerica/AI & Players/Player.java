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
	abstract void clearForNewRound(ArrayList<City> cities);
	abstract void updatePlayer();
	abstract String playerName();
<<<<<<< HEAD
	abstract Position getStartMarker();
	
=======
	
	public class PlayerRecord {
		//Should store player's color, cities, score, and other information as needed.
		
		public PlayerRecord() {
			
		}
	}
>>>>>>> branch 'master' of https://github.com/TheSphereWizard/TransAmerica

}
