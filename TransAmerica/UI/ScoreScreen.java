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
		add(new WinningPlayer(game.players.get(game.getWinningPlayer())));
		add(new Losers(game.players));
	}
	private class WinningPlayer extends JPanel{
		private WinningPlayer(Player winner){
			JLabel win = new JLabel(winner.getPlayerRecord().playerName()+" Connected All Their Cities", SwingConstants.CENTER);
			String names = "";
			System.out.println("hi "+winner.getPlayerRecord().getCitiesReached().size());
			for(int i = 0; i < 5; i++)
				names = names+" "+winner.getPlayerRecord().getCitiesReached().get(i).getName();
			setLayout(new GridLayout(2,0,0,0));
			add(new Title(win, winner.getPlayerRecord().getColor()));
			add(new WinnerInfo(new JLabel(names)));
		}
		private class Title extends JPanel{
			private Title(JLabel text, Color background){
				setBackground(background);
				add(text);
			}
		}
		private class WinnerInfo extends JPanel implements ActionListener{
			private WinnerInfo(JLabel text){
				JButton exit = new JButton("Continue");
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
		g.drawString("Score Screen other stuff disabled because it crashes", 400, 400);
	}
	/**
	 * Displays the game losers
	 */
	private class Losers extends JPanel{
		private Losers(ArrayList<Player> players){
			for(int i = 0; i < players.size(); i++)
				if(!players.get(i).equals(players.get(game.getWinningPlayer()))){
					Loser l =new Loser(players.get(i));
					l.setLocation(100*(i+1), 200);
					add(l);
				}
		}
	}
	/**
	 * An individual loser
	 */
	private class Loser extends JPanel{
		private Loser(Player player){
			this.setSize(100, 100);
			setBackground(player.getPlayerRecord().getColor());
			JLabel name = new JLabel(player.getPlayerRecord().playerName()), 
					unconnected = new JLabel(unconnectedCities(player)),
					railsMissing = new JLabel(),
					pointsLost = new JLabel(),
					score = new JLabel("Score: "+player.getPlayerRecord().getScore());
			add(name);
			add(unconnected);
			add(railsMissing);
			add(pointsLost);
			add(score);
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
	/**
	 * Displays the winning player, the order of the cities they connected,
	 * and the continue button
	 */
	
}