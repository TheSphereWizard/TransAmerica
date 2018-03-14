import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class ScoreScreen extends JPanel{
	private boolean gameOver = false;
	private Game game;
	ScoreScreen(ArrayList<Player> players, Game game) {
		setLayout(new GridLayout(2,1,0,0));
		this.game = game;
		add(new WinningPlayer(players.get(game.getWinningPlayer())));
	}	
	private class Losers extends JPanel{
		private Losers(ArrayList<Player> players){
			for(int i = 0; i < players.size(); i++)
				if(players.get(i).equals(players.get(game.getWinningPlayer())))
					System.out.println();
		}
	}
	private class Loser extends JPanel{
		private Loser(){
			
		}
	}
	
	private class WinningPlayer extends JPanel {
		private WinningPlayer(Player winner){
			JLabel win = new JLabel(winner.getPlayerRecord().playerName()+" Connected All Their Cities", SwingConstants.CENTER);
			setLayout(new GridLayout(2,0,0,0));
			add(new Title(win));
		}
		private class Title extends JPanel{
			private Title(JLabel text){
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