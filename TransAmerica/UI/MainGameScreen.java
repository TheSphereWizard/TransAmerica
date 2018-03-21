import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainGameScreen extends JPanel{
	private BufferedImage backg;
	static MapofUSA map;
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
		map = new MapofUSA(25,125,1080,1080/2,grid);//pls don't change dimensions of the Map without Asking
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
		for(int i = 0; i < currentGame.players.size(); i++) {
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
			cityLabels[i].setSize(175,50);
			cityLabels[i].setFont(fontf);
			cityLabels[i].setLocation(70+200*i,725);
			this.add(cityLabels[i]);
//			System.out.println(this.getComponentCount());
		}
		TransAmerica.transamerica.repaint();
		game.Round();
	}
	
	public void paint(Graphics g){
		g.drawImage(backg, 0, 0, 1600, 900, null);
		for(int i = 0; i < currentGame.players.size(); i++) {
			JLabel l=null;
			try{
				 l =(JLabel)this.getComponents()[1+i];
				 l.setText(currentGame.players.get(i).record.playerName());
				 l.setHorizontalAlignment(SwingConstants.CENTER);
				 g.setColor(currentGame.players.get(i).record.getColor());
				 g.fillRect(l.getX(),l.getY(),l.getWidth(),l.getHeight());
				
			}catch(Exception e){
				System.out.println("WRONG COMPONENT"+(1+i));
			}
		}
		for(int i = 0; i < cityLabels.length; i++) {
			JLabel l=null;
			try{
				 l =(JLabel)this.getComponents()[1+currentGame.players.size()+i];
				 l.setText(map.currentPlayer.record.getCities().get(i).getName());
				 l.setHorizontalAlignment(SwingConstants.CENTER);
				 g.setColor(map.currentPlayer.record.getCities().get(i).color);
				 g.fillRect(l.getX(),l.getY(),l.getWidth(),l.getHeight());
				
			}catch(Exception e){
				System.out.println("WRONG COMPONENT"+(7+i));
			}
			 if(map.currentPlayer.record.getCitiesReached().contains(new City(map.currentPlayer.record.getCities().get(i).getName(),new Position(0,0),Color.black))){
				 g.setColor(Color.green);
				 g.fillRect(l.getX()+l.getWidth()+5,l.getY()+5, 15, 15);
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
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g2d.drawLine(20, 100, 1100, 100);
		g2d.drawLine(20, 50, 1100, 50);
		int increment = 10;
		for(int i = 0; i < 12; i++){
			g2d.drawLine(50 + increment, 40, 50 + increment, 110);
			increment += 90;
		}
		g.setFont(new Font("Arial",1,16));
		for(int i=0;i<currentGame.players.size();i++){
			g.drawString(currentGame.players.get(i).record.score+" ", 50*i, 20);
		}
		
		//Below is Debug info:
		g.setFont(new Font("Arial",0,13));
		g.setColor(Color.black);
		for(int j=0;j<currentGame.players.size();j++){
			Player p=currentGame.players.get(j);
			g.setColor(p.record.getColor());
			g.drawString(p.record.playerName(), map.getX()+map.getWidth()+5+70*j, map.getY()+250+15*(-1));
			g.setColor(Color.BLACK);
			for(int i=0;i<5;i++){
				g.drawString(p.record.cities.get(i).getName(), map.getX()+map.getWidth()+5+70*j, map.getY()+250+15*i);
			}
		}
		
	}
}
