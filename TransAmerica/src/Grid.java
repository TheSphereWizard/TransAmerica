import java.awt.Color;
import java.util.ArrayList;

public class Grid {

	Rail[][] railGrid;
	private int boardwidth=25,boardheight=15;
	int[][] grid=new int[getBoardwidth()][];
	ArrayList<Rail> allrails = new ArrayList<Rail>();
	
	City[] allcities = new City[]{
			new City("Red1",new Position(0,0),Color.red),
			new City("Red2",new Position(0,1),Color.red),
			new City("Red3",new Position(0,2),Color.red),
			new City("Red4",new Position(0,3),Color.red),
			new City("Red5",new Position(0,4),Color.red),
			new City("Red6",new Position(0,5),Color.red),
			new City("Red7",new Position(0,6),Color.red),
			new City("green1",new Position(1,0),Color.green),
			new City("green2",new Position(1,1),Color.green),
			new City("green3",new Position(1,2),Color.green),
			new City("green4",new Position(1,3),Color.green),
			new City("green5",new Position(1,4),Color.green),
			new City("green6",new Position(1,5),Color.green),
			new City("green7",new Position(1,6),Color.green),
			new City("blue1",new Position(2,0),Color.blue),
			new City("blue2",new Position(2,1),Color.blue),
			new City("blue3",new Position(2,2),Color.blue),
			new City("blue4",new Position(2,3),Color.blue),
			new City("blue5",new Position(2,4),Color.blue),
			new City("blue6",new Position(2,5),Color.blue),
			new City("blue7",new Position(2,6),Color.blue),
			new City("orange1",new Position(3,0),Color.orange),
			new City("orange2",new Position(3,1),Color.orange),
			new City("orange3",new Position(3,2),Color.orange),
			new City("orange4",new Position(3,3),Color.orange),
			new City("orange5",new Position(3,4),Color.orange),
			new City("orange6",new Position(3,5),Color.orange),
			new City("orange7",new Position(3,6),Color.orange),
			new City("yellow1",new Position(4,0),Color.yellow),
			new City("yellow2",new Position(4,1),Color.yellow),
			new City("yellow3",new Position(4,2),Color.yellow),
			new City("yellow4",new Position(4,3),Color.yellow),
			new City("yellow5",new Position(4,4),Color.yellow),
			new City("yellow6",new Position(4,5),Color.yellow),
			new City("yellow7",new Position(4,6),Color.yellow),
	};
	
	boolean checkrail(Rail r, Player p){//checks whether the passed rail is on the player's network
		return false;
	}
	Grid(){
		placemountains();
	}
	
	void placeMarker(Position p){//places markers
		
	}
	void placeRail(Rail rail) {//Places a rail on the grid, update all player networks
		allrails.add(rail);
	}
	City[] getCities() {
		return allcities;
	}
	static boolean legalRail(Position one, Position two){
		if(one.x==two.x&one.y==two.y)
			return false;
		if(Math.abs(one.x-two.x)>1||Math.abs(one.y-two.y)>1)
			return false;
		if(one.y==two.y&Math.abs(one.x-two.x)==1)
			return true;
		if(one.y<two.y){
			return legalRail(two,one);
		}
		if(one.y%2==0&Math.abs(one.y-two.y)==1&(one.x-two.x>=0)){
			return true;
		}
		if(one.y%2==1&Math.abs(one.y-two.y)==1&(one.x-two.x<=0)){
			return true;
		}
		return false;
	}
	
	public Rail getRail(Position one, Position two) {
		//returns rail between two points
		return null;
	}
	
	boolean validRailAddition(Rail railtocheck, Player currentPlayer){
		
		
		
		return false;
	}
	public int getBoardwidth() {
		return boardwidth;
	}
	public void setBoardwidth(int boardwidth) {
		this.boardwidth = boardwidth;
	}
	public int getBoardheight() {
		return boardheight;
	}
	public void setBoardheight(int boardheight) {
		this.boardheight = boardheight;
	}
	public static int checkiflargeornot(Position p1, Position p2) throws Exception {
		return mountains.contains(new Rail(p1,p2,null))?2:1;
	}
	static ArrayList<Rail> mountains = new ArrayList<Rail>();
	private void placemountains() {
		try{
			mountains.add(new Rail(new Position(2,3),new Position(2,2),null));
			mountains.add(new Rail(new Position(3,2),new Position(3,3),null));
			mountains.add(new Rail(new Position(3,3),new Position(3,4),null));
		
		}catch(Exception e){
			
		}
	}
}
