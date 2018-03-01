import java.util.ArrayList;

public class Grid {

	Rail[][] railGrid;
	private int boardwidth=100,boardheight=50;
	int[][] grid=new int[boardwidth][];
	
	ArrayList<City> allcities = new ArrayList<City>();
	void placeMarker(int x, int y){//places markers
	}
	void placeRail(Rail rail) {
		//Places a rail on the grid, update all player networks
	}
	int checkRail(int[][] coor){
	}
	City[] getCities() {
		//Returns Cities Connected
	}
	boolean validRailAddition(int x, int y, Player currentPlayer){
		
	}


}
