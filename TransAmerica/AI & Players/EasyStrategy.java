import java.util.ArrayList;

public class EasyStrategy extends ComputerPlayer{
	
	public EasyStrategy(int[] scores, Grid grid) {
		super(scores, grid);
	}
	
	private void scanRails(ArrayList<Rail> rail, Position startPos){
		ArrayList<Rail> rails = rail;
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
				scanRails(scanList,endpoint);
			}
		}
		
	}

	Rail[] runTurn() {
		ArrayList<Rail> scanRails = getRailsAtPos(startMarker);//scanRails contains all the rails to be checked
		for(Rail r: scanRails){
			
		}
		
		return null;
	}

}
