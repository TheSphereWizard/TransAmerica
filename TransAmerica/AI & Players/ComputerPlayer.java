import java.awt.Color;
import java.util.ArrayList;

public abstract class ComputerPlayer extends Player {
	
	//Computer player should get copy of game state (but should not have access to other player’s hands)
	//Pass in an array of scores, a grid, and a hand to computer players
	private ReadOnlyGrid grid;
	
	public ComputerPlayer(Color c, ArrayList<City> cities, int score, String name) {
		super(c, cities, score, name);
	}

	abstract Rail runTurn(boolean firstRailPlaced, ReadOnlyGrid grid);
	
	public ArrayList<Rail> scanRails(ArrayList<Rail> rail, Position startPos, ReadOnlyGrid grid){
		//returns an arraylist of all possible rails to be placed
		this.grid = grid;
		ArrayList<Rail> rails = rail;
		ArrayList<Rail> newRails = new ArrayList<Rail>();
		for(Rail r: rails){
			if(grid.checkRail(r,this)){//rail attached to network
				Position endpoint;//endpoint is where the next scan originates at
				if(r.p1.equals(startPos)){
					endpoint = r.p2;
				}else{
					endpoint = r.p1;
				}
				ArrayList<Rail> scanList = getRailsAtPos(endpoint);
				for(Rail r2: scanList){
					if(r2.equals(r)){
						scanList.remove(r2);
					}
				}
				newRails.addAll(scanRails(scanList,endpoint,grid));
			}
			else{//rail not attached to network
				rails.remove(r);//rails only contains a list of valid rails
			}
		}
		rails=newRails;
		return rails;
		
	}
	
	public ArrayList<Rail> getRailsAtPos(Position pos) {
		ArrayList<Rail> rails = new ArrayList<Rail>(0);
		try {
			if(getGrid().RailExists(pos, new Position(pos.x, pos.y + 1)) && pos.y < 15)
				rails.add(new Rail(pos, new Position(pos.x, pos.y + 1)));
			if(getGrid().RailExists(pos, new Position(pos.x + 1, pos.y)) && pos.x < 25)
				rails.add(new Rail(pos, new Position(pos.x + 1, pos.y)));
			if(getGrid().RailExists(pos, new Position(pos.x, pos.y - 1)) && pos.y > 0)
				rails.add(new Rail(pos, new Position(pos.x, pos.y - 1)));
			if(getGrid().RailExists(pos, new Position(pos.x - 1, pos.y)) && pos.x > 0)
				rails.add(new Rail(pos, new Position(pos.x - 1, pos.y)));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return rails;
	}
	
	public ReadOnlyGrid getGrid() {
		return grid;
	}

}
