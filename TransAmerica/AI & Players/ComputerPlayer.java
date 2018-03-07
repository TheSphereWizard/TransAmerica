import java.awt.Color;
import java.util.ArrayList;

public abstract class ComputerPlayer extends Player {
	
	//Computer player should get copy of game state (but should not have access to other player�s hands)
	//Pass in an array of scores, a grid, and a hand to computer players
	protected Grid grid;
	
	public ComputerPlayer(Color c, ArrayList<City> cities, int score, String name, Grid grid) {
		super(c, cities, score, name);
		this.grid = grid;
	}

	abstract Rail runTurn();
	
	public ArrayList<Rail> scanRails(ArrayList<Rail> rail, Position startPos){//returns an arraylist of all possible rails to be placed
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
				newRails.addAll(scanRails(scanList,endpoint));
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
		
		if(grid.getRail(pos, new Position(pos.x, pos.y + 1)) != null && pos.y < 15)
			rails.add(grid.getRail(pos, new Position(pos.x, pos.y + 1)));
		if(grid.getRail(pos, new Position(pos.x + 1, pos.y)) != null && pos.x < 25)
			rails.add(grid.getRail(pos, new Position(pos.x + 1, pos.y)));
		if(grid.getRail(pos, new Position(pos.x, pos.y - 1)) != null && pos.y > 0)
			rails.add(grid.getRail(pos, new Position(pos.x, pos.y - 1)));
		if(grid.getRail(pos, new Position(pos.x - 1, pos.y)) != null && pos.x > 0)
			rails.add(grid.getRail(pos, new Position(pos.x - 1, pos.y)));
		
		return rails;
	}

}
