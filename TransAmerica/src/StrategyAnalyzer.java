//Yo does the ArrayList of compPlayers mean that we are running multiple AIs against each other
//and then using the arrays to document the results of each individual AI?
//Also we need some setters for the arrays
//Also we're just printing the results onto the console and not on a JPanel right?
import java.util.ArrayList;
public class StrategyAnalyzer{
	private int[] gamesWon;
	private int[] gamesLost;
	private int[] rank;
	private double[] winPercentage;
	/**
	 * Runs games, then calculates statistics, then creates an AI panel
	 * @param computerPlayers Amount of players
	 * @param games Number of games to be played
	 */
	StrategyAnalyzer (ArrayList computerPlayers,int games){
		initialize(computerPlayers.size());
		for(int i = 0; i < games; i++)
			setWinsAndLosses(computerPlayers.size());
		calculate();
	}
	/**
	 * Called after each game and
	 * records the wins and losses
	 */
	private void setWinsAndLosses(int players){
		for(int i = 0; i < players; i++){
			
		}
	}
	/**
	 * Initializes arrays based off 
	 * the number of players
	 * @param players Amount of players
	 */
	private void initialize(int players){
		gamesWon = new int[players];
		gamesLost = new int[players];
		rank = new int[players];
		winPercentage = new double[players];
	}
	public int[] getLost(){
		return gamesLost;
	}
	public int[] getWon(){
		return gamesWon;
	}
	public int[] getRank(){
		return rank;
	}
	public double[] getPercetage(){
		return winPercentage;
	}
	/**
	 * Called after each game is run
	 * and sets winPercentage & rank
	 */
	public void calculate(){
		//called at the end for percentages and ranks
	
	}
}