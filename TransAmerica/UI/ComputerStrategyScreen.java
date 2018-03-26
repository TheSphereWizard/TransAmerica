import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
//1600x900
public class ComputerStrategyScreen extends JPanel{
	private JPanel players = new JPanel();
	private BufferedImage backg;
	public ComputerStrategyScreen(int gamesPlayed, int[] gamesWon, int[] gamesLost, int[] rank, double[] winPercentage) {
		try{
			backg= ImageIO.read(new File("Pix/TransAmerica Background.jpg"));
		}catch(Exception E){}
		add(new GeneralInfo(gamesPlayed));
		players.setLayout(new GridLayout(2,3,10,10));
		setPlayers(gamesWon, gamesLost, rank, winPercentage);
		add(players);
		setLayout(new GridLayout(2,1,0,0));
	}
	public void paint(Graphics g){
		g.drawImage(backg, 0, 0, 1600, 900, null);
	}
	private void setPlayers(int[] gamesWon, int[] gamesLost, int[] rank, double[] winPercentage){
		Color[] colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE , new Color(139,69,19), Color.white};
		for(int i = 0; i < 6; i++){
			players.add(new PlayerInfo(gamesWon[i], gamesLost[i], rank[i], winPercentage[i], colors[i], i+1));
		}
	}
	private class PlayerInfo extends JPanel{
		private PlayerInfo(int gamesWon, int gamesLost, int playerRank, double winPercentage, Color color, int playerNum){
			setLayout(new GridLayout(5,1,0,0));
			String filling = new String("                  ");
			JLabel won = new JLabel(filling+"Games Won: " + gamesWon), lost = new JLabel(filling+"Games Lost: " + gamesLost),
					rank = new JLabel(filling+"Rank: " + playerRank), percentage = new JLabel(filling+"Win Percentage: " + winPercentage), 
					name = new JLabel(filling+"Strategy "+playerNum);
			setBackground(color);
			add(name);
			add(won);
			add(lost);
			add(rank);
			add(percentage);
		}
	}
	private class GeneralInfo extends JPanel{
		private GeneralInfo(int gamesPlayed){
			JLabel played = new JLabel("Games played: "+gamesPlayed, SwingConstants.CENTER),
					title = new JLabel("Computer Strategy Analyzer", SwingConstants.CENTER);
			JButton exit = new JButton("Back to Main Menu");
			setLayout(new GridLayout(3,0,0,0));
			title.setFont(title.getFont().deriveFont (64.0f));
			add(new Text(title));
			exit.setFont(played.getFont().deriveFont (48.0f));
			add(new Button(exit));
			played.setFont(played.getFont().deriveFont (48.0f));
			add(new Text(played));
		}
		private class Text extends JPanel{
			private Text(JLabel text){
				add(text);
			}
		}
		private class Button extends JPanel implements ActionListener{
			private Button(JButton but){
				but.addActionListener(this);
				add(new JLabel(""));
				add(but);
				add(new JLabel(""));
			}
			public void actionPerformed(ActionEvent e) {
				TransAmerica.transamerica.setVisible(false);
				//TransAmerica.transamerica.remove(0);
				TransAmerica.transamerica.setContentPane(new MainMenu());
				TransAmerica.transamerica.setVisible(true);
			}
		}
	}
}