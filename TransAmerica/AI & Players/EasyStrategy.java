import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class EasyStrategy extends ComputerPlayer{
	public EasyStrategy(Color c, String name) {
		super(c,  name);
	}

	Object runTurn(boolean firstturn,boolean firstRailPlaced, Object grid2) {
		ReadOnlyGrid grid = null;
		try{
			grid = (ReadOnlyGrid) grid2;
		}catch(Exception e){
			
		}
		if(firstturn){
			return new Marker(new Position(Math.random()*Grid.boardwidth,Math.random()*Grid.boardheight),this);
			//Needs to Check if this is not in the Ocean
		}else{
			ArrayList<Rail> totalRails = grid.allValidMovesforPlayer(this,!firstRailPlaced);//getRailsAtPos(startMarker.p),startMarker.p, grid);//totalRails contains all the rails to be checked
			if(firstRailPlaced){
				for(Rail r: totalRails){
					if(r.size==2){
						totalRails.remove(r);
					}
				}
			}
			Random rand = new Random();
			int pos = rand.nextInt(totalRails.size());
			Rail r = totalRails.get(pos);
			railsRemaining-=r.size;
			if(railsRemaining == 0)
				railsRemaining = 2;
			return totalRails.get(pos);
		}
	}


}
