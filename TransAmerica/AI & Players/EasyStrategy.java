import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class EasyStrategy extends ComputerPlayer{

	public EasyStrategy(Color c, ArrayList<City> cities, int score, String name, Grid grid) {
		super(c, cities, score, name, grid);
	}

	Rail runTurn() {
		ArrayList<Rail> totalRails = scanRails(getRailsAtPos(startMarker),startMarker);//totalRails contains all the rails to be checked
		Random rand = new Random();
		int pos = rand.nextInt(totalRails.size()+1);
		return totalRails.get(pos);
	}

}
