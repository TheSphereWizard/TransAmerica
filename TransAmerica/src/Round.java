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
			for(int i = 0; i<r.length;i++){
				grid.placeRail(r[i]);
			}
			if(p.cityReached)
		}
	}

	
	int[] returnScoreChange(){
		int[] scoreChange = {0};
		return scoreChange;
	}
	
	class Rail{}
	class Grid{

		public void placeRail(Rail rail) {
			// TODO Auto-generated method stub
			
		}}
	class Player{
		public void clearForNewRound() {
		}
		public Rail[] runTurn(){
			Rail[] r = new Rail[1];
			return r;
		}
	}
}
