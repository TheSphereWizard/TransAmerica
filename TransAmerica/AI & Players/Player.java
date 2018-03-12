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
public abstract class Player {//give players playerrecords
	boolean placedMarkerAlready;
	Position startMarker;
	MapofUSA map;
	PlayerRecord record;
	
	Player(Color c, ArrayList<City> cities, int score,String n){
		placedMarkerAlready = false;
		record = new PlayerRecord(c, cities, score, n);
	}
	//This needs to be an object because on first turn returns marker
	abstract Object runTurn(boolean firstRailPlaced, ReadOnlyGrid grid);
	void clearForNewRound(ArrayList<City> cities){
		placedMarkerAlready = false;
		record.cities = cities;
	}
	
	Position getStartMarker(){
		return startMarker;
	}
	
	public PlayerRecord getPlayerRecord() {
		return record;
	}
	
	
	public class PlayerRecord {
		//Should store player's color, cities, score, and other information as needed.
		//The players color
		private Color color;
		//The cities the player needs/have to connect
		private ArrayList<City> cities;
		//# of cities player has connected
		private int score;
		private String name;
		
		public PlayerRecord(Color color, ArrayList<City> cities, int score, String name) {
			this.color = color;
			this.cities = cities;
			this.score = score;
			this.name = name;
		}
		
		String playerName(){
			return name;
		}
		
		public Color getColor() {
			return color;
		}
		
		public ArrayList<City> getCities() {
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
