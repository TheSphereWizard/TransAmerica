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
	Object runTurn(boolean firstPlacedRail, Object map2) {
		MapofUSA map = null;
		try {
			map = (MapofUSA)map2;
		}catch(Exception e){
			System.out.println("Not a Map");
		}
		//accesses lastClick to map until it isn't null
		Object nextRail = null;
		while(nextRail == null){
			try{
				nextRail = map.returnPlacedRail();
			}catch(Exception E){
//				System.out.println(map==null);
			}
		}
		return nextRail;
	}
	
//	Position getStartMarker() {
//		return null;
//	}

}
