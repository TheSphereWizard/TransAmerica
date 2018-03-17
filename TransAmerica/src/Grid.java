import java.awt.Color;
import java.util.ArrayList;

public class Grid {
	City[][] allcities = new City[][]{
		{new City("Red1",new Position(3,12),Color.red),
			new City("Red2",new Position(1,11),Color.red),
			new City("Red3",new Position(0,9),Color.red),
			new City("Red4",new Position(1,7),Color.red),
			new City("Red5",new Position(3,5),Color.red),
			new City("Red6",new Position(3,7),Color.red),
			new City("Red7",new Position(2,9),Color.red),},
		{
			new City("green1",new Position(13,11),Color.green),
			new City("green2",new Position(8,8),Color.green),
			new City("green3",new Position(9,11),Color.green),
			new City("green4",new Position(11,8),Color.green),
			new City("green5",new Position(17,11),Color.green),
			new City("green6",new Position(6,10),Color.green),
			new City("green7",new Position(14,7),Color.green),},
		{
			new City("blue1",new Position(11,3),Color.blue),
			new City("blue2",new Position(6,4),Color.blue),
			new City("blue3",new Position(7,6),Color.blue),
			new City("blue4",new Position(10,2),Color.blue),
			new City("Austin",new Position(13,1),Color.blue),
			new City("blue6",new Position(13,3),Color.blue),
			new City("blue7",new Position(11,6),Color.blue),},
		{	
			new City("orange1",new Position(18,5),new Color(255,128,0)),
			new City("orange2",new Position(24,12),new Color(255,128,0)),
			new City("orange3",new Position(21,10),new Color(255,128,0)),
			new City("orange4",new Position(21,7),new Color(255,128,0)),
			new City("orange5",new Position(22,6),new Color(255,128,0)),
			new City("orange6",new Position(19,8),new Color(255,128,0)),
			new City("orange7",new Position(18,6),new Color(255,128,0)),},
		{					
			new City("yellow1",new Position(15,2),Color.yellow),
			new City("yellow2",new Position(20,1),Color.yellow),
			new City("yellow3",new Position(19,3),Color.yellow),
			new City("yellow4",new Position(20,5),Color.yellow),
			new City("yellow5",new Position(17,4),Color.yellow),
			new City("yellow6",new Position(16,6),Color.yellow),
			new City("yellow7",new Position(17,2),Color.yellow),},
	};
	
	Rail[][] railGrid;
	static int boardwidth=35, boardheight=25;
	int[][] grid=new int[boardwidth][];
	ArrayList<Rail> allRails = new ArrayList<Rail>();
	ArrayList<Marker> markers= new ArrayList<Marker>();
	Grid(){
		placemountains();
//		allRails = alllegalrails;
	}
	boolean RailExists(Position p1, Position p2){
		try {
			return allRails.contains(new Rail(p1,p2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	void placeMarker(Position p,Player player){//places markers
		markers.add(new Marker(p,player));//THIS NEEDS TO THROW EXCEPTION IF INVALID SO IT CAN BE PLACED AGAIN
	}
	void placeRail(Rail rail) {//Places a rail on the grid, update all player networks
		if(!allRails.contains(rail)&alllegalrails.contains(rail)&checkRail(rail,rail.player))
			allRails.add(rail);
		//THIS NEEDS TO THROW AN EXCEPTION IF INVALID SO IT CAN BE PLACED AGAIN WITHOUT ENDING TURN
		
		//IF CITY IS CONNECTED TO THIS RAIL THEN CHANGE ALL PLAYERS CONNECTED TO THIS CITY TO REALIZE THEY ARE CONNECTED
		
		//MAKE A METHOD THAT RETURNS AN ARRAY/LIST OF OBJECTS THAT ARE CONNECTED TO A POSITION OF aLL TYPES THAT CAN BE ITERATED OVER BY CLASS
	}
	City[][] getCities() {
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
	
	public static int checkiflargeornot(Position p1, Position p2) throws Exception {
		return mountains.contains(new Rail(p1,p2))?2:1;
	}
	ArrayList<Rail> alllegalrails=setalllegalrails();
	
	private ArrayList<Rail> setalllegalrails() {
		int[][] alllandpositions=new int[][]{
			{0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,1,1,1,1,  1,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,0,0,  0,0,0,1,1,  0,0,0,0,0,  0,0,0,1,1,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,0,0,  0,1,1,1,0,  1,1,1,0,0,  0,1,1,1,0,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,0,  0,1,1,1,0,  1,1,1,1,0,  0,1,1,1,0,},
			{1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,1,0,0,  1,1,1,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,0,  0,0,0,0,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,1,1,0,0,  0,0,0,0,0,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,0,  0,0,0,0,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,1,1,0,0,  0,0,0,0,0,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,0,  0,0,0,0,1,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,1,1,0,0,  0,0,0,0,0,  1,0,0,0,0,  1,1,1,1,0,  0,1,1,1,0,},
		};//needs to be redone to shape of USA
		ArrayList<Rail> all = new ArrayList<Rail>();
		for(int x =0;x<boardwidth;x++){
			for(int y =0;y<boardheight;y++){
				for(int x1 =0;x1<boardwidth;x1++){
					for(int y1 =0;y1<boardheight;y1++){
						if(alllandpositions[boardheight-y-1][x]==1&alllandpositions[boardheight-1-y1][x1]==1){
							try {
								all.add(new Rail(new Position(x,y),new Position(x1,y1)));
							} catch (Exception e) {}
						}
					}
				}
			}
		}
		return all;
	}
	int distbetweenpoints(Position p1,Position p2){
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
	
	ArrayList<Rail> immediateneighbors(Position p) throws Exception{
		ArrayList<Rail> ne = new ArrayList<Rail>();
		ne.add(new Rail(p,new Position(p.x-1,p.y)));
		ne.add(new Rail(p,new Position(p.x+1,p.y)));
		ne.add(new Rail(p,new Position(p.x,p.y+1)));
		ne.add(new Rail(p,new Position(p.x,p.y-1)));
		if(p.y%2==1){
			ne.add(new Rail(p,new Position(p.x+1,p.y+1)));
			ne.add(new Rail(p,new Position(p.x+1,p.y-1)));
		}else{
			ne.add(new Rail(p,new Position(p.x-1,p.y+1)));
			ne.add(new Rail(p,new Position(p.x-1,p.y-1)));
		}
		for(int i=0;i<ne.size();i++){
			if(!alllegalrails.contains(ne.get(i))){
				ne.remove(i);
				i--;
			}
		}
		return ne;
	}
	
	boolean checkRail(Rail r, Player p){//checks whether the passed rail is on the player's network
		if(p==null){
			return true;
		}else{
			try {
				return allValidMovesForPlayer(p).contains(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	ArrayList<ArrayList<City>> setofgoalCities(int numberofplayers){
		ArrayList<ArrayList<City>> yo = new ArrayList<ArrayList<City>>();
		for(int i=0;i<numberofplayers;i++){
			ArrayList<City> bo = new ArrayList<City>();
			yo.add(bo);
			for(int j=0;j<5;j++){
				int rand = (int)(Math.random()*allcities[j].length);
				boolean ok = true;
				for(int k=0;k<yo.size()-2;k++){
					ArrayList<City> c = yo.get(k);
					if(c.get(j).equals(allcities[j][rand])){
						ok=false;
					}
				}
				if(ok){
					bo.add(allcities[j][rand]);
				}
			}
		}		
		return yo;
	}
	
	//TODO below:
	static ArrayList<Rail> mountains = new ArrayList<Rail>();
	private void placemountains() {
		try{
			mountains.add(new Rail(new Position(2,3),new Position(2,2)));
			mountains.add(new Rail(new Position(3,2),new Position(3,3)));
			mountains.add(new Rail(new Position(3,3),new Position(3,4)));
		}catch(Exception e){}
	}

	ArrayList<Rail> allValidMovesForPlayer(Player p) throws Exception{//returns all Rails on Players Network
		ArrayList<Rail> allvalid;
		if(p==null){
			return null;
		}else{
			ArrayList<Rail> corners = immediateneighbors(p.startMarker.p);
			allvalid = new ArrayList<Rail>();
			for(int i=0;i<corners.size();i++){
				Rail po=corners.get(i);
				if(RailExists(po.p1,po.p2)){
					for(Rail pr : immediateneighbors(po.p2)){
						if(!corners.contains(pr)){
							corners.add(pr);
						}
					}
				}else{
					try {
						allvalid.add(new Rail(po.p2,po.p1));
					} catch (Exception e) {System.out.println("here");}
				}
			}
		}
		return allvalid;
	}
	int[] railsMissing(){
		//throwexception if one is not 0, 
		//idk return sum of smallest distances from any rail on players network each missing city?
		
		
		//temporarlily just try to minimize by adding shortest path to each city, then checking next city from new path arangement
		//not perfect but good enough
		ArrayList<Rail> fred = new ArrayList<Rail>();
		//May need to make whole new Grids to test different cases.
		
		
		
		
		/*
		 * I think the general algorithum will go as follows;
		 * for each city: 
		 * 	Add to a grid all possible rails that go together with the smallest possible route
		 * 	
		 */
		
		
		
//		int totaldist=0;
//		for(City c :p.record.getCities()){
//			if(!p.record.getCitiesReached().contains(c)){
//				int max ;
//			}
//		}
		return null;
	}
}
