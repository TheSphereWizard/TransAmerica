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
			if(p.cityReached.size()-1==0){
				
			}
		}
	}

	
	int[] returnScoreChange(){
		int[] scoreChange = {0};
		return scoreChange;
	}
	
	
}
