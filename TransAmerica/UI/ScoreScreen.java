import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class ScoreScreen extends JPanel implements ActionListener {

	private JPanel contentPane = new JPanel();
	private PlayerScorePanel[] playerScorePanels = new PlayerScorePanel[6];
	private JButton continueButton = new JButton("Continue");
	private Game currentGame;
	
	private boolean gameOver = false;
	
	ScoreScreen(ArrayList<Player> players, Game game) {
		
		continueButton.addActionListener(this);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		currentGame = game;
		
		
		for
		
		
		
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(continueButton)) {
			MainGameScreen a = new MainGameScreen(currentGame);
		} else {
			
		}
	}
	
	private class PlayerScorePanel extends JPanel {

		private static final long serialVersionUID = 1L;
	
		
		
		
		
		
	}
}
