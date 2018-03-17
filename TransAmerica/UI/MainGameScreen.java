import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGameScreen extends JPanel {
	private BufferedImage backg;
	MapofUSA map;
	BufferedImage train , eagle;
	Grid grid;
	Game currentGame;

	private JLabel[] playerLabels = new JLabel[6];
	private JLabel[] cityLabels = new JLabel[5];
	private Color[] playerColors = new Color[] {Color.red, Color.yellow, Color.green, Color.blue, new Color(139,69,19),Color.white};
	private Color[] cityColors = new Color[] {Color.red, Color.blue, Color.yellow, Color.green, Color.orange};
	
	MainGameScreen(Game game) {
		map = new MapofUSA(0,100,1000,500,grid);//game may want map to alter players
		//on weekend need to get game to use map
		map.currentPlayer = game.players.get(0);
		map.currentGrid=game.grid;
		this.add(map);
		System.out.println(map.getY());
		//THIS IS TEMPORARILY REWRITTEN TO SCALE ON 1368/768 screen as This is my screen resolution:
		//-BRIAN
		
		try{
			backg= ImageIO.read(new File("Pix/TransAmerica Background.jpg"));
		}catch(Exception E){}

		this.setLayout(null);
		//THings needs on this Screen:
		/* 
			players, and their cities below:
			boxes that get hidden and closed
			
			the train scores at top
			
			the moves left on Right
			
			the map... and double check it works
			
			and also technically making sure going to scorescreen works
		*/
		for(int i = 0; i < playerLabels.length; i++) {
			System.out.println(i);
			playerLabels[i] = new JLabel("Player " + i+1);
//			playerLabels[i].setBackground(playerColors[i]);
			playerLabels[i].setSize(100,50);
			playerLabels[i].setLocation(100+100*i,600);
//			panes[2].setLayout(new GridLayout(1,6));
			this.add(playerLabels[i]);
		}
		System.out.println(TransAmerica.transamerica.getComponentCount());
		for(int i = 0; i < cityLabels.length; i++) {
			cityLabels[i] = new JLabel("City " + i+1);
//			cityLabels[i].setBackground(cityColors[i]);
			cityLabels[i].setSize(100,50);
			cityLabels[i].setLocation(100+100*i,700);
//			panes[3].setLayout(new GridLayout(1,5));
			this.add(cityLabels[i]);
		}
		TransAmerica.transamerica.repaint();
	}
	
	public void generate(ArrayList<Color> playerColors, ArrayList<String> playerNames, ArrayList<String> playerType){
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<ArrayList<City>> cities = map.currentGrid.setofgoalCities(playerType.size());
		boolean slowMode = false;
		for(int i = 0; i<playerType.size();i++){
			if(playerType.get(i).equals("Human")){
				players.add(new HumanPlayer(playerColors.get(i),cities.get(i),playerNames.get(i)));
				slowMode = true;
			}else if(playerType.get(i).equals("Easy")){
				players.add(new EasyStrategy(playerColors.get(i),cities.get(i),playerNames.get(i)));
			}else{
				int[] playerScores = new int[players.size()];
				for(int j = 0;j<playerScores.length;j++){
					playerScores[j] = 12;
				}
				players.add(new HardStrategy(playerColors.get(i),cities.get(i),playerScores, playerNames.get(i)));
			}
		}
		currentGame = new Game(players,slowMode);
		
	}
	
	public void paint(Graphics g){
		g.drawImage(backg, 0, 0, 1600, 900, null);
		for(int i=0;i<this.getComponentCount();i++){
			g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
			this.getComponent(i).paint(g);
			g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
		}
	}	
}
