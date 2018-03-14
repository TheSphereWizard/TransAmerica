//POINTS LOST
//RAILS MISSING
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class ScoreScreen extends JPanel{
	private Game game;
	ScoreScreen(ArrayList<Player> players, Game game) {
		setLayout(new GridLayout(2,1,0,0));
		this.game = game;
		add(new WinningPlayer(players.get(game.getWinningPlayer())));
		add(new Losers(players));
	}	
	private class Losers extends JPanel{
		private Losers(ArrayList<Player> players){
			for(int i = 0; i < players.size(); i++)
				if(!players.get(i).equals(players.get(game.getWinningPlayer())))
					add(new Loser(players.get(i)));
		}
	}
	private class Loser extends JPanel{
		private Loser(Player player){
			setBackground(player.getPlayerRecord().getColor());
			JLabel name = new JLabel(player.getPlayerRecord().playerName()), 
					unconnected = new JLabel(unconnectedCities(player)), railsMissing, pointsLost, score;
			add(name);
			add(unconnected);
			
		}
		private String unconnectedCities(Player player){
			String content = "";
			for(int i = 0; i < player.getPlayerRecord().getCities().size(); i++)
				for(int j = 0; j < player.getPlayerRecord().getCitiesReached().size(); i++)
					if(player.getPlayerRecord().getCities().get(i).equals(player.getPlayerRecord().getCitiesReached().get(j)))
						content = content + player.getPlayerRecord().getCities().get(i).getName();
						return content;
		}
	}

	private class WinningPlayer extends JPanel {
		private WinningPlayer(Player winner){
			JLabel win = new JLabel(winner.getPlayerRecord().playerName()+" Connected All Their Cities", SwingConstants.CENTER);
			String names = "";
			for(int i = 0; i < 5; i++)
				names = names+winner.getPlayerRecord().getCitiesReached().get(i).getName();
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
			public void actionPerformed(ActionEvent e) {

			}
		}
	}
}