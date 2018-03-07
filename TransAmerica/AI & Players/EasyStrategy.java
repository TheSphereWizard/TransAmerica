import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class EasyStrategy extends ComputerPlayer{
	
	public EasyStrategy(Color c, ArrayList<City> cities, int score, int[] scores, String name, Grid grid) {
		super(c, cities, score, scores, name, grid);
	}
	
	private ArrayList<Rail> scanRails(ArrayList<Rail> rail, Position startPos){
		ArrayList<Rail> rails = rail;
		ArrayList<Rail> newRails = new ArrayList<Rail>();
		for(Rail r: rails){
			if(r.size()){//rail attached to network
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
		rails.addAll(newRails);
		return rails;
		
	}

	Rail runTurn() {
		ArrayList<Rail> totalRails = scanRails(getRailsAtPos(startMarker),startMarker);//scanRails contains all the rails to be checked
		Random rand = new Random();
		int pos = rand.nextInt(totalRails.size()+1);
		return totalRails.get(pos);
	}

}
