import java.awt.Color;
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
	int score = 0;
	MapofUSA map;
	String name;
	
	Player(String n){
		name = n;
		placedMarkerAlready = false;
	}
	
	abstract Rail[] runTurn();
	void clearForNewRound(ArrayList<City> cities){
		cityGoal = cities;
		cityReached.clear();
		placedMarkerAlready = false;
		score = 0;
	}
	abstract void updatePlayer();
	abstract String playerName();
	Position getStartMarker(){
		return startMarker;
	}
	

	
	public class PlayerRecord {
		//Should store player's color, cities, score, and other information as needed.
		private Color color;
		private City[] cities;
		private int score;
		
		public PlayerRecord(Color color, City[] cities, int score) {
			this.color = color;
			this.cities = cities;
			this.score = score;
		}
		
		public Color getColor() {
			return color;
		}
		
		public City[] getCities() {
			return cities;
		}
		
		public int getScore() {
			return score;
		}
		
		public void setScore(int newScore) {
			score = newScore;
		}
	}

}
