import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
		MapofUSA.currentGrid=grid;//technically should not do this but idk right now
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
	public int placesleft=2;
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
	Timer gametimer = new Timer();
	void Round() {
		
		// ONLY DOES HUMAN ROUNDS RIGHT NOW
		
		gametimer.schedule(new TimerTask(){
			public void run() {
				grid = new Grid();
				for (Player p : players) {
					p.clearForNewRound(p.getPlayerRecord().getCities());
				}
				startHumanRound();
			}
			
		}, 0);
		
	}
	
	boolean gameOver(){
		boolean over=false;
		for (Player p : players) {
			boolean all=true;
			for(City c : p.record.getCities()){
				if(!p.record.getCitiesReached().contains(c)){
					all=false;
				}
			}
			if(all){
				over=true;
			}
		}
		return over;
	}
	void startHumanRound() {
		ReadOnlyGrid readGrid = null;
		boolean FirstTurn =true;
//		System.out.println(grid==MapofUSA.currentGrid);
		MapofUSA.currentGrid=grid;
		while(!gameOver()){
//			System.out.println(grid==MapofUSA.currentGrid);
			for (Player p : players) {
				try{
					HumanPlayer h = (HumanPlayer)p;
					Object o = h.runTurn(FirstTurn,false,MainGameScreen.map);
					if(o!=null){
						try{
							Marker m = (Marker) o;
							h.startMarker=m;
							grid.placeMarker(m.p, h);
//							System.out.println(grid==MapofUSA.currentGrid);
						}catch(Exception E){
							try{
								Rail r = (Rail) o;
								grid.placeRail(r);//place multiple rails, impliment mountains
							}catch(Exception er){
								er.printStackTrace();
							}
						}
					}
//					System.out.println("once");
				}catch(Exception E){
					System.out.println(p.record.playerName());
					try{
						ComputerPlayer c = (ComputerPlayer)p;
						Object o = c.runTurn(FirstTurn,false,new ReadOnlyGrid(grid));
						if(o!=null){
							try{
								Marker m = (Marker) o;
								c.startMarker=m;
								grid.placeMarker(m.p, c);
//								System.out.println(grid==MapofUSA.currentGrid);
							}catch(Exception Eer){
								try{
									Rail r = (Rail) o;
									grid.placeRail(r);//place multiple rails, impliment mountains
								}catch(Exception er){
									er.printStackTrace();
								}
							}
						}
					}catch(Exception Ee){
						Ee.printStackTrace();
					}
				}
			}
			FirstTurn=false;
			MapofUSA.firstturn=false;
		}
	}

	int[] returnScoreChange() {
		int[] scoreChange = { 0 };
		return scoreChange;
	}
}
