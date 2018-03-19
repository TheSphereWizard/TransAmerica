import java.awt.Color;
import java.util.ArrayList;

public class Grid {
	City[][] allcities = new City[][]{
		{new City("Houston",new Position(3,12),Color.red),
			new City("Atlanta",new Position(1,11),Color.red),
			new City("Dallas",new Position(0,9),Color.red),
			new City("El Paso",new Position(1,7),Color.red),
			new City("Memphis",new Position(3,5),Color.red),
			new City("New Orleans",new Position(3,7),Color.red),
			new City("Phoenix",new Position(2,9),Color.red),},
		{
			new City("Seattle",new Position(13,11),Color.green),
			new City("San Diego",new Position(8,8),Color.green),
			new City("San Francisco",new Position(9,11),Color.green),
			new City("Sacramento",new Position(11,8),Color.green),
			new City("Portland",new Position(17,11),Color.green),
			new City("Medford",new Position(6,10),Color.green),
			new City("Los Angeles",new Position(14,7),Color.green),},
		{
			new City("Duluth",new Position(11,3),Color.blue),
			new City("Buffalo",new Position(6,4),Color.blue),
			new City("Bismark",new Position(7,6),Color.blue),
			new City("Chicago",new Position(10,2),Color.blue),
			new City("Cincinnati",new Position(13,1),Color.blue),
			new City("Helena",new Position(13,3),Color.blue),
			new City("Minneapolis",new Position(11,6),Color.blue),},
		{	
			new City("Boston",new Position(18,5),new Color(255,128,0)),
			new City("Richmond",new Position(24,12),new Color(255,128,0)),
			new City("Washington",new Position(21,10),new Color(255,128,0)),
			new City("Winston",new Position(21,7),new Color(255,128,0)),
			new City("Charleston",new Position(22,6),new Color(255,128,0)),
			new City("Jacksonville",new Position(19,8),new Color(255,128,0)),
			new City("New York",new Position(18,6),new Color(255,128,0)),},
		{					
			new City("Denver",new Position(15,2),Color.yellow),
			new City("Kansas City",new Position(20,1),Color.yellow),
			new City("Oklahoma City",new Position(19,3),Color.yellow),
			new City("Omaha",new Position(20,5),Color.yellow),
			new City("Salt Lake City",new Position(17,4),Color.yellow),
			new City("Santa Fe",new Position(16,6),Color.yellow),
			new City("Saint Louis",new Position(17,2),Color.yellow),},
	};
	
	Rail[][] railGrid;
	static int boardwidth=30, boardheight=20;
	int[][] grid=new int[boardwidth][];
	ArrayList<Rail> allRails = new ArrayList<Rail>();
	ArrayList<Marker> markers= new ArrayList<Marker>();
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
		City c=CityatPos(p);
		if (c!=null){
			player.record.citiesReached.add(c);
		}
	}
	void placeRail(Rail rail) {//Places a rail on the grid, update all player networks
		if(!allRails.contains(rail)&alllegalrails.contains(rail)&checkRail(rail,rail.player)){
			allRails.add(rail);
			connectCities(rail.player);
			//This will only update at end of a players turn, if connecting another players turn, it should end imediately
			//AKA NEEDS TO UPDATE ALL PLAYERS CONNECTED CITES
		}
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
//		if(){
//			
//		}
		return 1;
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
	
	ArrayList<Rail> immediateneighbors(Position p){
		ArrayList<Rail> ne = new ArrayList<Rail>();
		try {
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
		} catch (Exception e) {}
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
				while(bo.size()==j){
					int rand = (int)(Math.random()*allcities[j].length);
					boolean ok = true;
					for(int k=0;k<yo.size()-1;k++){
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
		}		
		return yo;
	}
	City CityatPos(Position p){
		for(City[] car:allcities){
			for(City c:car){
				if(c.p.equals(p)){
					return c;
				}
			}
		}
		return null;
	}
	void connectCities(Player p){
		if(p==null){
			
		}else{
			ArrayList<Rail> corners = immediateneighbors(p.startMarker.p);
			for(int i=0;i<corners.size();i++){
				Rail po=corners.get(i);
				if(RailExists(po.p1,po.p2)){
					for(Rail pr : immediateneighbors(po.p2)){
						if(!corners.contains(pr)){
							corners.add(pr);
							City c1=CityatPos(pr.p1);
							if(c1!=null&&!p.record.citiesReached.contains(c1)){
								p.record.citiesReached.add(c1);
							}
							City c2=CityatPos(pr.p1);
							if(c2!=null&&!p.record.citiesReached.contains(c2)){
								p.record.citiesReached.add(c2);
							}
						}
					}
				}
			}
		}
	}
	
	ArrayList<Rail> allValidMovesForPlayer(Player p){//returns all validmoves
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
						allvalid.add(new Rail(po.p2,po.p1,p));
					} catch (Exception e) {System.out.println("here");}
				}
			}
		}
		return allvalid;
	}
	ArrayList<Rail> allRailsonPlayersNetwork(Player p){//returns all rails on players network
		ArrayList<Rail> corners;
		if(p==null){
			return null;
		}else{
			corners = immediateneighbors(p.startMarker.p);
			for(int i=0;i<corners.size();i++){
				Rail po=corners.get(i);
				if(RailExists(po.p1,po.p2)){
					for(Rail pr : immediateneighbors(po.p2)){
						if(!corners.contains(pr)){
							corners.add(pr);
						}
					}
				}
			}
		}
		return corners;
	}
	int[] railsMissing(ArrayList<Player> players){
		int[] loss = new int[players.size()];
		//Below is Temporary as it will not always work.
		for(int i=0;i<players.size();i++){
			Player p=players.get(i);
			int totaldist =0;
			for(City c : p.record.cities){
				int currdist=Integer.MAX_VALUE;
				if(!p.record.citiesReached.contains(c)){
					for(Rail r :allRailsonPlayersNetwork(p)){
						currdist=Math.min(currdist,distbetweenpoints(r.p1,c.p));
						currdist=Math.min(currdist,distbetweenpoints(r.p2,c.p));
					}
				}
				totaldist+=currdist;
			}
			loss[i]=totaldist;
		}
		
		
		
		//How actual one should work
		//BREADTH FIRST BACK FROM EACH CITY GOAL, WHEN IT HITS OTHER CITY, MERGES,ELSE USES PATH WHEN IT HITS THE RAIL NETWORK
		
		//idk throwexception if one is not 0? 
		return loss;
	}
}
