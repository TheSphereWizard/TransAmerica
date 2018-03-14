import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class ScoreScreen extends JPanel{
	
	private JButton continueButton = new JButton("Continue");
	private boolean gameOver = false;
	
	ScoreScreen(ArrayList<Player> players, Game game) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new WinningPlayer(players.get(game.getWinningPlayer())));
	}
	
	private class Loser extends JPanel{
		
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