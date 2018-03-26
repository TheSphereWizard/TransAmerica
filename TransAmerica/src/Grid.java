import java.awt.Color;
import java.util.ArrayList;

public class Grid {
	City[][] allcities = new City[][]{
		{new City("Houston",new Position(15,3),Color.red),
			new City("Atlanta",new Position(22,6),Color.red),
			new City("Dallas",new Position(14,5),Color.red),
			new City("El Paso",new Position(8,5),Color.red),
			new City("Memphis",new Position(18,7),Color.red),
			new City("New Orleans",new Position(18,3),Color.red),
			new City("Phoenix",new Position(6,6),Color.red),},
		{
			new City("Seattle",new Position(2,18),new Color(0, 204, 0)),
			new City("San Diego",new Position(3,6),new Color(0, 204, 0)),
			new City("San Francisco",new Position(1,9),new Color(0, 204, 0)),
			new City("Sacramento",new Position(1,11),new Color(0, 204, 0)),
			new City("Portland",new Position(2,16),new Color(0, 204, 0)),
			new City("Medford",new Position(2,14),new Color(0, 204, 0)),
			new City("Los Angeles",new Position(2,8),new Color(0, 204, 0)),},
		{
			new City("Duluth",new Position(17,15),Color.blue),
			new City("Buffalo",new Position(21,12),Color.blue),
			new City("Bismark",new Position(13,16),Color.blue),
			new City("Chicago",new Position(19,12),Color.blue),
			new City("Cincinnati",new Position(21,10),Color.blue),
			new City("Helena",new Position(8,16),Color.blue),
			new City("Minneapolis",new Position(16,16),Color.blue),},
		{	
			new City("Boston",new Position(27,14),new Color(255,128,0)),
			new City("Richmond",new Position(25,10),new Color(255,128,0)),
			new City("Washington",new Position(24,11),new Color(255,128,0)),
			new City("Winston",new Position(21,7),new Color(255,128,0)),
			new City("Charleston",new Position(24,6),new Color(255,128,0)),
			new City("Jacksonville",new Position(23,3),new Color(255,128,0)),
			new City("New York",new Position(26,13),new Color(255,128,0)),},
		{					
			new City("Denver",new Position(10,10),new Color(255, 0, 128)),
			new City("Kansas City",new Position(15,10),new Color(255, 0, 128)),
			new City("Oklahoma City",new Position(14,8),new Color(255, 0, 128)),
			new City("Omaha",new Position(15,12),new Color(255, 0, 128)),
			new City("Salt Lake City",new Position(6,11),new Color(255, 0, 128)),
			new City("Santa Fe",new Position(10,8),new Color(255, 0, 128)),
			new City("Saint Louis",new Position(18,10),new Color(255, 0, 128)),},
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
			{0,0,1,1,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,1,1,1,  1,1,1,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,1,0,  0,0,0,0,0,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,0,0,0,  0,0,0,0,0,  0,0,1,1,0,  0,0,0,0,0,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,0,0,  0,0,0,0,0,  0,1,1,1,0,  0,0,0,0,0,},
			{1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,0,  0,0,0,0,1,  1,1,1,0,0,  0,0,0,0,0,},
			{1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,0,1,  1,1,1,0,0,  0,0,0,0,0,},
			{1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,1,1,  1,1,1,0,0,  0,0,0,0,0,},
			{1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,0,0,0,  0,0,0,0,0,},
			{1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,0,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,0,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,1,  1,1,1,1,1,  1,1,1,1,0,  0,0,1,1,1,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,1,1,1,  1,0,0,0,0,  0,0,0,1,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,1,1,1,  0,0,0,0,0,  0,0,0,1,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,0,1,1,  0,0,0,0,0,  0,0,0,0,1,  1,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
			{0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,  0,0,0,0,0,},
		};//needs to be redone to shape of USA
		ArrayList<Rail> all = new ArrayList<Rail>();
		for(int x =0;x<boardwidth;x++){
			for(int y =0;y<boardheight;y++){
				for(int x1 =x-1<0?0:x-1;x1<((x+2>boardwidth)?boardwidth:x+2);x1++){
					for(int y1 =y-1<0?0:y-1;y1<((y+2>boardheight)?boardheight:y+2);y1++){
//						if(alllandpositions[boardheight-y-1][x]==1&alllandpositions[boardheight-1-y1][x1]==1){
							try {
								all.add(new Rail(new Position(x,y),new Position(x1,y1)));
							} catch (Exception e) {}
//						}
					}
				}
			}
		}
		return all;
	}
	int distbetweenpoints(Position p1,Position p2){
		if(p1.equals(p2)){
			return 0;
		}
		if(immediateneighbors2(p1).contains(p2)){
			return 1;
		}
		else{
			if(Math.abs(p1.x-p2.x)<=Math.abs(p1.y-p2.y)){
				if(p2.y%2==0){
					if(p1.y-p2.y>0){
						if(p1.x-p2.x>=0){//-1,0
							return 1+distbetweenpoints(p1,new Position(p2.x,p2.y+1));
						}
						else{
							return 1+distbetweenpoints(p1,new Position(p2.x-1,p2.y+1));
						}
					}
					if(p1.y-p2.y<0){
						if(p1.x-p2.x>=0){//-1,0
							return 1+distbetweenpoints(p1,new Position(p2.x,p2.y-1));
						}
						else{
							return 1+distbetweenpoints(p1,new Position(p2.x-1,p2.y-1));
						}
					}
					System.out.println("THIS SHOULD NOT HAPPEN");
					return -7;
				}
				if(p1.y-p2.y>0){
					if(p1.x-p2.x>0){//1,0
						return 1+distbetweenpoints(p1,new Position(p2.x+1,p2.y+1));
					}
					else{
						return 1+distbetweenpoints(p1,new Position(p2.x,p2.y+1));
					}
				}
				if(p1.y-p2.y<0){
					if(p1.x-p2.x>0){//1,0
						return 1+distbetweenpoints(p1,new Position(p2.x+1,p2.y-1));
					}
					else{
						return 1+distbetweenpoints(p1,new Position(p2.x,p2.y-1));
					}
				}
				System.out.println("THIS SHOULD NOT HAPPEN");
				return -7;
			}else{
				return 1+distbetweenpoints(p1,new Position(p2.x+Math.signum(p1.x-p2.x),p2.y));
			}
		}
	}
	ArrayList<Position> immediateneighbors2(Position p){
		ArrayList<Position> ne = new ArrayList<Position>();
		try {
			ne.add(new Position(p.x-1,p.y));
			ne.add(new Position(p.x+1,p.y));
			ne.add(new Position(p.x,p.y+1));
			ne.add(new Position(p.x,p.y-1));
		
			if(p.y%2==1){
				ne.add(new Position(p.x+1,p.y+1));
				ne.add(new Position(p.x+1,p.y-1));
			}else{
				ne.add(new Position(p.x-1,p.y+1));
				ne.add(new Position(p.x-1,p.y-1));
			}
		} catch (Exception e) {}
		return ne;
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
			System.out.println("what \"Grid\"");
		}else{
			ArrayList<Rail> corners = immediateneighbors(p.startMarker.p);
			for(int i=0;i<corners.size();i++){
				Rail po=corners.get(i);
				if(RailExists(po.p1,po.p2)){
					City c1=CityatPos(po.p1);
					if(c1!=null&&p.record.cities.contains(c1)&&!p.record.citiesReached.contains(c1)){
						p.record.citiesReached.add(c1);
					}
					City c2=CityatPos(po.p2);
					if(c2!=null&&p.record.cities.contains(c2)&&!p.record.citiesReached.contains(c2)){
						p.record.citiesReached.add(c2);
					}
					for(Rail pr : immediateneighbors(po.p2)){
						if(!corners.contains(pr)){
							corners.add(pr);
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
		ArrayList<Rail> network=new ArrayList<Rail>();
		if(p==null){
			return null;
		}else{
			corners = immediateneighbors(p.startMarker.p);
			for(int i=0;i<corners.size();i++){
				Rail po=corners.get(i);
				if(RailExists(po.p1,po.p2)){
					network.add(po);
					for(Rail pr : immediateneighbors(po.p2)){
						if(!corners.contains(pr)){
							corners.add(pr);
						}
					}
				}
			}
		}
		return network;
	}
	int[] railsMissing2(ArrayList<Player> players){
		//For each player
			//Breadthfirst in parrellel from all missing cities
			//IF HITS network, then that city done
			//else if hits other city: cities not done but starts another check from the intersection
			//if that intersection hits city then Ends both other citys.
		
		
		//Don't be shy to make other data types for just this method
		//Also ha lol need to do A*, but prob not happening as due tommorow.
		return null;
	}
	int[] railsMissing(ArrayList<Player> players){
		int[] loss = new int[players.size()];
		//Below is Temporary as it will not always work. Should almost always though
		for(int i=0;i<players.size();i++){
			Player p = players.get(i);
			int totaldist = 0;
			for(City c : p.record.cities){
				int currdist=Integer.MAX_VALUE;
				if(!p.record.citiesReached.contains(c)){
					for(Rail r :allRailsonPlayersNetwork(p)){
						currdist=Math.min(currdist,distbetweenpoints(r.p1,c.p));
						currdist=Math.min(currdist,distbetweenpoints(r.p2,c.p));
					}
				}
				if(currdist!=Integer.MAX_VALUE)
					totaldist+=currdist;
			}
			loss[i]=totaldist;
		}
		
		
		
		//How actual one should work
		//BREADTH FIRST BACK FROM EACH CITY GOAL, WHEN IT HITS OTHER CITY, MERGES,ELSE USES PATH WHEN IT HITS THE RAIL NETWORK
		return loss;
	}
}
