import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainGameScreen extends JPanel{
	private BufferedImage backg;
	MapofUSA map;
	BufferedImage train , eagle;
	Grid grid;
	Game currentGame;

	private JLabel[] playerLabels = new JLabel[6];
	private JLabel[] cityLabels = new JLabel[5];
	private Color[] playerColors = new Color[] {Color.red, Color.yellow, Color.green, Color.blue, new Color(139,69,19),Color.white};
	private Color[] cityColors = new Color[] {Color.red, Color.blue, Color.yellow, Color.green, new Color(255,128,0)};
	
	MainGameScreen(Game game) {
//		game.Round();
		currentGame=game;
		map = new MapofUSA(25,125,1100,550,grid);//game may want map to alter players
		//on weekend need to get game to use map
		map.currentPlayer = game.players.get(0);
		if(map.currentPlayer==null){
			System.out.println("player is null");
		}
		map.currentGrid=game.grid;
		if(map.currentGrid==null){
			System.out.println("grid is null");
		}
		this.add(map);
//		System.out.println(map.getY());
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
		Font fontf = new Font("Arial",1,25);
		for(int i = 0; i < playerLabels.length; i++) {
//			System.out.println(i);
			playerLabels[i] = new JLabel("Player " + (i+1));
			playerLabels[i].setSize(100,50);
			playerLabels[i].setFont(fontf);
			playerLabels[i].setLocation(70+150*i,675);
			this.add(playerLabels[i]);
		}
//		System.out.println(TransAmerica.transamerica.getComponentCount());
		for(int i = 0; i < cityLabels.length; i++) {
			cityLabels[i] = new JLabel("City " + (i+1));
			cityLabels[i].setSize(100,50);
			cityLabels[i].setFont(fontf);
			cityLabels[i].setLocation(70+200*i,725);
			this.add(cityLabels[i]);
			System.out.println(this.getComponentCount());
		}
		TransAmerica.transamerica.repaint();
		game.Round();
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
		for(int i = 0; i < cityLabels.length; i++) {
			JLabel l=null;
			try{
				 l =(JLabel)this.getComponents()[7+i];
				 l.setText(map.currentPlayer.record.getCities().get(i).getName());
				 l.setHorizontalAlignment(SwingConstants.CENTER);
				 g.setColor(map.currentPlayer.record.getCities().get(i).color);
				 g.fillRect(l.getX(),l.getY(),l.getWidth(),l.getHeight());
				
			}catch(Exception e){
				System.out.println("WRONG COMPONENT"+(7+i));
			}
			 if(map.currentPlayer.record.getCitiesReached().contains(new City(map.currentPlayer.record.getCities().get(i).getName(),new Position(0,0),Color.black))){
				 g.setColor(Color.green);
				 g.drawRect(l.getX()+l.getWidth(),l.getY(), 15, 15);
			 }
		}
		for(int i=0;i<this.getComponentCount();i++){//ha lolhalollasttest
			g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
			this.getComponent(i).paint(g);
			g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
		}
		g.fillRect(map.getX()+map.getWidth()+50,map.getY()+50, 150, 150);//change to be button image
		g.setColor(Color.white);
		g.setFont(new Font("Arial",1,172));
		g.drawString(""+currentGame.placesleft, map.getX()+map.getWidth()+50+25,map.getY()+50+135);
		
	}
//	public void mouseMoved(MouseEvent e) {
//		
//		if(e.getX()>=map.getX()&e.getX()<=map.getX()+map.getWidth()){
//			if(e.getY()>=map.getY()&e.getY()<=map.getY()+map.getHeight()){
//				map.mouseMoved(e);
//			}
//		}
//	}
//	public void mouseClicked(MouseEvent e) {
////		System.out.println("a");
////		if(e.getX()>=map.getX()&e.getX()<=map.getX()+map.getWidth()){
////			if(e.getY()>=map.getY()&e.getY()<=map.getY()+map.getHeight()){
////				map.mouseClicked(new MouseEvent(null,0,0 ,0,e.getX(),e.getY()-200,0,false,0));
////			}
////		}
//	}
//	public void mouseEntered(MouseEvent e) {}
//	public void mouseExited(MouseEvent e) {}
//	public void mousePressed(MouseEvent e) {}
//	public void mouseReleased(MouseEvent e) {}
//	public void mouseDragged(MouseEvent arg0) {}
}
