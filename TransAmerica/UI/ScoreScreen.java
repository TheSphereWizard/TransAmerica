//POINTS LOST
//RAILS MISSING
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
public class ScoreScreen extends JPanel{
	private Game game;
	private BufferedImage backg;
	ScoreScreen(Game game){
		try{
			backg= ImageIO.read(new File("Pix/TransAmerica Background.jpg"));
		}catch(Exception E){}
		setLayout(null);
		this.game = game;
		WinningPlayer wp =new WinningPlayer(game.players.get(game.getWinningPlayerforRound()));
		wp.setSize(1600, 900);
		add(wp);
		add(new Losers(game.players));
		
		/*
		 * 
		 * PLEASE whoever is making this, if you can't figure out how to get this to come up properly, 
		 * Just feed it custom data, and make sure it displays, I can get it to come up but I don't want to
		 * display it.
		 * -Brian
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		
	}
	private class WinningPlayer extends JPanel{
		private WinningPlayer(Player winner){
			
			JLabel win = new JLabel(winner.getName()+" Connected All Their Cities", SwingConstants.CENTER);
			win.setLocation(500, 0);
			win.setSize(300, 100);
			add(win);
			String names = "";
			for(int i = 0; i < 5; i++)
				names = names+" "+winner.getPlayerRecord().getCitiesReached().get(i).getName();
			setLayout(null);
			WinnerInfo w =new WinnerInfo(new JLabel(names));
			w.setLocation(0, 200);
			w.setSize(300, 100);
		
			add(w);
		}
		public void paint(Graphics g){
			for(int i=0;i<this.getComponentCount();i++){
				g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
				this.getComponent(i).paint(g);
				g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
			}
		}
		private class WinnerInfo extends JPanel implements ActionListener{
			private WinnerInfo(JLabel text){
				JButton exit = new JButton("Continue");
				exit.setLocation(800, 200);
				exit.setSize(100, 100);
				exit.addActionListener(this);
				add(text);
				add(exit);
			}
			public void actionPerformed(ActionEvent e){
				
			}
		}
	}
	public void paint(Graphics g){
		g.drawImage(backg, 0, 0, 1600, 900, null);
		for(int i=0;i<this.getComponentCount();i++){//ha lolhalollasttest
			g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
			this.getComponent(i).paint(g);
			g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
		}
	}
	/**
	 * Displays the game losers
	 */
	private class Losers extends JPanel{
		private Losers(ArrayList<Player> players){
			setBounds(100, 100, 1300, 500);
			
			for(int i = 0; i < players.size(); i++) {
				if(!players.get(i).equals(players.get(game.getWinningPlayerforRound()))){
					Loser l =new Loser(players.get(i));
					l.setLocation(100*(i+1), 200);
					add(l);
				}
			}
			
		}
	}
	
	public ScoreScreen getScoreScreen() {
		return this;
	}
	/**
	 * An individual loser
	 */
	private class Loser extends JPanel{
		
		public Loser(Player player){
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			setBackground(player.getColor());
			JLabel name = new JLabel(player.getName()), 
					unconnected = new JLabel(unconnectedCities(player)),
					railsMissing = new JLabel(),
					pointsLost = new JLabel(),
					score = new JLabel("Score: "+player.getPlayerRecord().getScore());
			add(name);
			add(unconnected);
			add(railsMissing);
			add(pointsLost);
			add(score);
			setSize(300, 300);
		}
		/**
		 * @param player
		 * @return a String containing players unconnected cities
		 */
		private String unconnectedCities(Player player){
			String content = "";
			for(City c : player.record.cities){
				if(!player.record.citiesReached.contains(c)){
					content+=" "+c.getName();
				}
			}
			return content;
		}
	}
}