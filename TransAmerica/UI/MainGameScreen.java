import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

/*
 * MainGameScreen extends JPanel{//Screen used for Human players and slow mode strategy
	Map map;
BufferedImage Eagle, Train;
	Game currentGame;
	MainGameScreen(Game game){
		currentGame = game;
}
paintComponent(Graphics g){//calls on getShowScoreScreen in Game, if true changes into the Score Screen, else continues to show MainGameScreen
	}
}

 */
public class MainGameScreen extends JPanel{
	MapofUSA map;
	BufferedImage train, eagle;
	Game currentGame;
	
	private JPanel[] panes = new JPanel[4];
	
	
	public MainGameScreen(){
	}
	
	public void generate(ArrayList<Color> playerColors, ArrayList<String> playerNames, ArrayList<String> playerType){
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 0; i<playerType.size();i++){
			if(playerType.get(i).equals("Human")){
				players.add(new HumanPlayer(playerColors.get(i),cities,0,playerNames.get(i),map));
			}else
		}
		
	}
	
	public void paintComponent(Graphics g){
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
