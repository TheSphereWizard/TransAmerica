import java.util.ArrayList;

/*
 * Game{//stores series of rounds
	ArrayList<Round> rounds
ArrayList<Player> players
	Game(ArrayList<Player>, int numberOfRounds){
//determines if is AI game and slow mode, Instantiates rounds with number of rounds, order of players in Round parameters is the order of player’s turns
}
Void runRounds(){//runs through rounds arraylist, calls returnScoreChange after finished
}
Boolean showScoreScreen;
Boolean isAIGame;
Boolean slowMode;
Boolean getShowScoreScreen();//called by MainGamePanel to determine when to change

Int[] playerNumber, winningPlayer, currentScore, scores;
	Int getNumberOfPlayers()
	Int getWinningPlayer()
	Int[] getCurrentScore()
	Int[] getScores()
}

 */
public class Game {
	public static final int ROUND = 0;
	// ^shows the types of specific game states^
	Grid grid;
	ArrayList<Player> players;
	/**
	 * determines if is AI game and slow mode
	 * @param players the types and amounts of players
	 * @param slowMode if false run a fast game
	 */
	Game(ArrayList<Player> players, boolean slowMode){
		grid = new Grid();
		this.players = players;
		this.slowMode = slowMode;
		if(!slowMode){
			
		}
	}
	
	boolean showScoreScreen;
	boolean isAIGame;
	boolean slowMode;
	public boolean getShowScoreScreen(){
		//called by MainGamePanel to determine when to change
		if(showScoreScreen){
			return true;
		}
		return false;
	}
	int[] playerNumber, winningPlayer, currentScore, scores;
	public int getNumberOfPlayers(){
		int numOfPlayers = 0;
		for(numOfPlayers = 0; numOfPlayers < playerNumber.length; numOfPlayers++){
			numOfPlayers++;
		}
		return numOfPlayers;
	}
	/**
	 * @return the position of the player who won in the ArrayList players (0-5)
	 */
	public int getWinningPlayer(){
		int maxScore = 0;
		for(int i = 0; i < scores.length; i++){
			if(maxScore < scores[i]){
				maxScore = scores[i];
			}
		}
		return maxScore;
	}
	public int[] getCurrentScore(){
		return currentScore;
	}
	
	void Round() {
		grid = new Grid();
		for (Player p : players) {
			p.clearForNewRound(p.getPlayerRecord().getCities());
		}
		startCompRound();
	}

	void startCompRound() {
		ReadOnlyGrid readGrid = null;
		for (Player p : players) {
			Rail[] r = (Rail[]) p.runTurn(false,readGrid);
			for (int i = 0; i < r.length; i++) {
				grid.placeRail(r[i]);
			}
			
		}
	}

	int[] returnScoreChange() {
		int[] scoreChange = { 0 };
		return scoreChange;
	}
}
