import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

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
		boolean FirstTurn =true;
		MapofUSA.currentGrid=grid;
		while(!gameOver()){
			for (Player p : players) {
				int railsleft=2;
				placesleft=railsleft;
				try{
					HumanPlayer h = (HumanPlayer)p;
					if(!gameOver()){
						do{
							Object o = h.runTurn(FirstTurn,!(railsleft==2),MainGameScreen.map);
							if(o!=null){
								try{
									Marker m = (Marker) o;
									h.startMarker=m;
									grid.placeMarker(m.p, h);
								}catch(Exception E){
									try{
										Rail r = (Rail) o;
										grid.placeRail(r);
										railsleft-=r.size;
										placesleft=railsleft;
									}catch(Exception er){
										er.printStackTrace();
									}
								}
							}
						}while(railsleft>0&!FirstTurn);
					}
				}catch(Exception E){
					try{
						ComputerPlayer c = (ComputerPlayer)p;
						if(!gameOver()){
							do{
								Object o = c.runTurn(FirstTurn,!(railsleft==2),new ReadOnlyGrid(grid));
								if(o!=null){
									try{
										Marker m = (Marker) o;
										c.startMarker=m;
										grid.placeMarker(m.p, c);
									}catch(Exception Eer){
										try{
											Rail r = (Rail) o;
											grid.placeRail(r);
											railsleft-=r.size;
											placesleft=railsleft;
										}catch(Exception er){
											er.printStackTrace();
										}
									}
								}
							}while(railsleft>0&!FirstTurn);
						}
					}catch(Exception Ee){
						Ee.printStackTrace();
					}
					try {
						Thread.sleep(350);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			FirstTurn=false;
			MapofUSA.firstturn=false;
		}
		showScoreScreen=true;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ScoreScreen screen = new ScoreScreen(players, this);

		TransAmerica.transamerica.add(screen);
		TransAmerica.transamerica.remove(0);
		TransAmerica.transamerica.dispose();
		JFrame f = new JFrame();
		f.add(screen);
		TransAmerica.transamerica = f;
		TransAmerica.transamerica.setTitle("TransAmerica");
		TransAmerica.transamerica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TransAmerica.transamerica.dispose();
		TransAmerica.transamerica.setUndecorated(true);
		TransAmerica.transamerica.setExtendedState(JFrame.MAXIMIZED_BOTH);
		TransAmerica.transamerica.setVisible(true);
		TransAmerica.transamerica.repaint();
	}

	int[] returnScoreChange() {
		int[] scoreChange = { 0 };
		return scoreChange;
	}
}
