//Yo does the ArrayList of compPlayers mean that we are running multiple AIs against each other
//and then using the arrays to document the results of each individual AI?
//Also we need some setters for the arrays
//Also we're just printing the results onto the console and not on a JPanel right?
import java.util.ArrayList;
public class StrategyAnalyzer{
	int[] gamesWon;
	int[] gamesLost;
	int[] rank;
	double[] winPercentage;
	/**
	 * @param computerPlayers 
	 * @param games Number of games to be played
	 */
	StrategyAnalyzer (ArrayList computerPlayers,int games){
		//runs games, then calculates statistics, then creates an AI panel
		for(int i = 0; i < games; i++)
			System.out.println("Placeholder until we find out how to run games");
		calculate();
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

	public double[] getPercentage(){
		return winPercentage;
	}

	public void calculate(){
		//called at the end for percentages and ranks
	}

}