//Does the ArrayList of compPlayers mean that we are running multiple AIs against each other
//And then using the arrays to document the results of each individual AI?
import java.util.ArrayList;
public class StrategyAnalyzer{
	private int[] gamesWon;
	private int[] gamesLost;
	private int[] rank;
	private double[] winPercentage;
	private int players;
	private ArrayList<ComputerPlayer> compPlayers;
	/**
	 * Initializes the data-storing arrays
	 * @param computerPlayers Amount of players
	 */
	StrategyAnalyzer (ArrayList<ComputerPlayer> AIs){
		players = compPlayers.size();
		gamesWon = new int[players];
		gamesLost = new int[players];
		rank = new int[players];
		winPercentage = new double[players];
		compPlayers = AIs;
	}
	/**
	 * Runs the amount of games passed and then
	 * calculates the results and displays them
	 * via the ComputerStrategyScreen
	 * @param games amount of games to be played
	 */
	public void runGames(int games){
		for(int i = 0; i < games; i++){
			Game game = new Game(compPlayers,);
			
			calculateResults(i+1);
		}
		displayResults(games);
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
	 * and sets the data arrays
	 */
	public void calculateResults(int games){
		for(int i = 0; i < players; i++){
			gamesWon[i] = gamesWon[i]+/*RESULT FROM GAME*/;
			gamesLost[i] = gamesLost[i]+/*RESULT FROM GAME*/;
			winPercentage[i] = gamesWon[i]/games;
			for(int j = 0; j < players; j++){
				if(gamesWon[i] > gamesWon[j]){
					int temp = rank[i];
					rank[i] = rank[j];
					rank[j] = temp;
				}
			}
		}
	}
	/**
	 * Creates a ComputerStrategyScreen and passes
	 * it the amount of games played, gamesWon, gamesLost,
	 * rank, and winPercentage
	 * @param gamesPlayed the amount of games played
	 */
	private void displayResults(int gamesPlayed){
		ComputerStrategyScreen results = new ComputerStrategyScreen
				(gamesPlayed, gamesWon, gamesLost, rank, winPercentage);
	}
}