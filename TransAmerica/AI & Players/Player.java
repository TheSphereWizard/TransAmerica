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
	boolean placedMarkerAlready;//this is never set
	Marker startMarker;
	PlayerRecord record;
	
	Player(Color c, ArrayList<City> cities,String n){
		placedMarkerAlready = false;
		record = new PlayerRecord(c, cities, n);
	}
	//This needs to be an object because on first turn returns marker
	abstract Object runTurn(boolean firstRailPlaced, Object gridormap);
	void clearForNewRound(ArrayList<City> cities){
		placedMarkerAlready = false;
		record.cities = cities;
	}
	Marker getStartMarker(){
		return startMarker;
	}
	Position getStartPosition(){
		return startMarker.p;
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
		private ArrayList<City> citiesReached;
		//# of cities player has connected
		private int score;
		private String name;
		
		public PlayerRecord(Color color, ArrayList<City> cities, String name) {
			this.color = color;
			this.cities = cities;
			this.score = 12;
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
		public void setCities(ArrayList<City> cities){
			this.cities = cities;
		}
		public ArrayList<City> getCitiesReached(){
			return citiesReached;
		}
		public void setCitiesReached(ArrayList<City> citiesReached){
			this.citiesReached = citiesReached;
		}
		public int getScore() {
			return score;
		}	
		public void setScore(int newScore) {
			score = newScore;
		}
	}
}
