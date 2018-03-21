import java.awt.Color;
import java.util.ArrayList;

public class PlayerRecord {
		//Should store player's color, cities, score, and other information as needed.
		//The players color
		private Color color;
		//The cities the player needs/have to connect
		ArrayList<City> cities;
		ArrayList<City> citiesReached=new ArrayList<City>();
		//# of cities player has connected
		int score;
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
