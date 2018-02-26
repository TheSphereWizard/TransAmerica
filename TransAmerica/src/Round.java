import java.util.ArrayList;

public class Round {
	Grid grid;
	ArrayList<Player> players;
	Round(ArrayList<Player> P){
		grid = new Grid();
		players = P;
		for(Player p: players){
			p.clearForNewRound();
		}
		startRound();
	}
	
	void startRound(){
		for(Player p: players){
			Rail[] r = p.runTurn();
		}
	}

	
	int[] returnScoreChange(){
		int[] scoreChange = {0};
		return scoreChange;
	}
	
	class Rail{}
	class Grid{}
	class Player{
		public void clearForNewRound() {
		}
		public Rail[] runTurn(){
			Rail[] r = new Rail[1];
			return r;
		}
	}
}
