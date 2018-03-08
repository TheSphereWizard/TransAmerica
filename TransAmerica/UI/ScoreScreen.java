import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScoreScreen extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private PlayerScorePanel[] playerScorePanels = new PlayerScorePanel[6];
	
	
	private JButton continueButton = new JButton("Continue");
	
	ScoreScreen(ArrayList<Player> players) {
		
		continueButton.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Scores");
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		
		
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private class PlayerScorePanel extends JPanel {

		private static final long serialVersionUID = 1L;
	
		
		
		
		
		
	}
}
