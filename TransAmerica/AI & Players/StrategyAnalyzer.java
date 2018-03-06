//Does the ArrayList of compPlayers mean that we are running multiple AIs against each other
//And then using the arrays to document the results of each individual AI?
import java.util.ArrayList;
public class StrategyAnalyzer{
	private int[] gamesWon;
	private int[] gamesLost;
	private int[] rank;
	private double[] winPercentage;
	private int players;
	private ArrayList<Player> AIs;
	/**
	 * Initializes the data-storing arrays
	 * Pre-supposes that all players passed are AIs
	 * @param computerPlayers Amount of players
	 */
	StrategyAnalyzer (ArrayList<Player> compPlayers){
		players = compPlayers.size();
		gamesWon = new int[players];
		gamesLost = new int[players];
		rank = new int[players];
		winPercentage = new double[players];
		AIs = compPlayers;
	}
	/**
	 * Runs the amount of games passed and then
	 * calculates the results and displays them
	 * via the ComputerStrategyScreen
	 * @param games amount of games to be played
	 */
	public void runGames(int games){
		for(int i = 0; i < games; i++){
			Game game = new Game(AIs, false);
			
			calculateResults(i+1, game);
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
	public void calculateResults(int games, Game game){
		//The position of the winning player
		int winner = game.getWinningPlayer();
		for(int i = 0; i < players; i++){
			if(i == winner)
				gamesWon[winner]++;
			else
				gamesLost[i] = gamesLost[i]++;
			winPercentage[i] = gamesWon[i]/games;
		}
		calculateRank();
	}
	//FIX
	private void calculateRank(){
		for(int j = 1; j < players; j++){
			if(gamesWon[j] > gamesWon[j-1]){
				int temp = rank[j-1];
				rank[j-1] = rank[j];
				rank[j] = temp;
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