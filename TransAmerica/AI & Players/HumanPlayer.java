import java.awt.Color;
import java.util.ArrayList;

/*
 * HumanPlayer extends Player{
Rail[] runTurn() {}
String playerName() {}
}
test
 */
public class HumanPlayer extends Player {
	HumanPlayer(Color c, ArrayList<City> cities, String name){
		super(c, cities, name);
	}
	Object runTurn(boolean firstturn,boolean firstPlacedRail, Object map2) {
		MapofUSA map = null;
		try {
			map = (MapofUSA)map2;
		}catch(Exception e){
			System.out.println("Not a Map");
		}
		//accesses lastClick to map until it isn't null
		Object nextRail = null;
		map.currentPlayer=this;
		boolean ok = true;
		while(nextRail == null||ok){
			ok=true;
//			System.out.println("stuck here?");//AMAZING, DO NOT REMOVE THIS PRINT STATEMENT, DOING SO WILL BREAK EVERYTHING
			//ok fine maybe just need to add a sleep statement instead...
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try{
				nextRail = map.returnPlacedRail();
			}catch(Exception E){
				System.out.println(map==null);
			}
			try{
				Marker m = (Marker) nextRail;
				ok=false;
			}catch(Exception E){
				try{
					Rail r = (Rail) nextRail;
					if(r!=null&map.currentGrid.checkRail(r, this)){
						ok=false;
					}
//					System.out.println("ok "+ok);
				}catch(Exception er){
					
				}
			}
		}
		System.out.println("ok "+ok);
		return nextRail;
	}
	
//	Position getStartMarker() {
//		return null;
//	}

}
