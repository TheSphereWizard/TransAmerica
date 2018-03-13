import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class ScoreScreen extends JPanel implements ActionListener {
	private JButton continueButton = new JButton("Continue");
	private Game currentGame;
	private boolean gameOver = false;
	ScoreScreen(ArrayList<Player> players, Game game) {
		continueButton.addActionListener(this);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		currentGame = game;
		Player winner = null;
		for(Player player: players){
			if(player.getPlayerRecord().getScore()==5&&winner==null)
				winner = player;
		}
	}
	public void actionPerformed(ActionEvent e) {
		new MainGameScreen();
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
	}
}