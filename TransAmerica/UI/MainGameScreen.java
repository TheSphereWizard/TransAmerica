import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGameScreen extends JPanel {
	private BufferedImage backg;
	MapofUSA map;
	BufferedImage train , eagle;

	Game currentGame;
	private JPanel[] panes = new JPanel[4];
	private JLabel[] playerLabels = new JLabel[6];
	private JLabel[] cityLabels = new JLabel[5];
	private Color[] playerColors = new Color[] {Color.red, Color.yellow, Color.green, Color.blue, new Color(139,69,19),Color.white};
	private Color[] cityColors = new Color[] {Color.red, Color.blue, Color.yellow, Color.green, Color.orange};
	private JFrame frame;

	private JLabel transAmericaLabel;
	
	MainGameScreen(Grid grid) {
		
		this.map = new MapofUSA(0,200,1000,500,grid);
		map.currentPlayer = 
		try{
			backg= ImageIO.read(new File("Pix/TransAmerica Background.jpg"));
		}catch(Exception E){}
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		transAmericaLabel = new JLabel("TransAmerica");
		for(int i = 0; i < panes.length; i++) {
			panes[i] = new JPanel();
			this.add(panes[i]);
		}
		
		for(int i = 0; i < playerLabels.length; i++) {
			playerLabels[i] = new JLabel("Player " + i+1);
			playerLabels[i].setBackground(playerColors[i]);
			panes[2].setLayout(new GridLayout(1,6));
			panes[2].add(playerLabels[i]);
		}
		
		for(int i = 0; i < cityLabels.length; i++) {
			cityLabels[i] = new JLabel("City " + i+1);
			cityLabels[i].setBackground(cityColors[i]);
			panes[3].setLayout(new GridLayout(1,5));
			panes[3].add(cityLabels[i]);
		}
		
		panes[0].add(transAmericaLabel);
		panes[1].add(map);
	}
	

	
	public void paintComponent(Graphics g){
		g.drawImage(backg, 0, 0, 1600, 900, null);
	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setContentPane(new MainGameScreen());
		Map
		frame.setVisible(true);
	}
	
}
