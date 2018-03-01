import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
	public MainGameScreen(Game game){
		currentGame = game;
	}
	
	public void paintComponent(Graphics g){
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
