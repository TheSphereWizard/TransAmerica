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
	public static final int GameState = 0;
	// ^shows the types of specific game states^
	//ArrayList<Round> rounds;
	ArrayList<Player> players;
	Game(ArrayList<Player> player, boolean gameSpeed){
		//determines if is AI game and slow mode, Instantiates rounds with number of rounds, order of players in Round parameters is the order of player’s turns
	}
	void runRounds(){
		//runs through rounds arraylist, calls returnScoreChange after finished
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
	public int getWinningPlayer(){
		for(int maxScore : ){
			
		}
	}
	public int[] getCurrentScore(){
		return currentScore;
	}
	
	


	Grid grid;

	void Round(ArrayList<Player> P) {
		grid = new Grid();
		players = P;
		for (Player p : players) {
			p.clearForNewRound(grid.allcities);
		}
		startRound();
	}

	void startRound() {
		for (Player p : players) {
			Rail[] r = p.runTurn();
			for (int i = 0; i < r.length; i++) {
				grid.placeRail(r[i]);
			}
			if (p.cityReached.size() - 1 == 0) {

			}
		}
	}

	int[] returnScoreChange() {
		int[] scoreChange = { 0 };
		return scoreChange;
	}
}
