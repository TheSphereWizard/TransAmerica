import java.awt.GridLayout;
import javax.swing.*;
public class ComputerStrategyScreen extends JPanel{
	private JButton exit = new JButton("Exit");
	private JLabel gameDisplay = new JLabel("Games played: ");
	public ComputerStrategyScreen(int gamesPlayed, int[] gamesWon, int[] gamesLost, int[] rank, double[] winPercentage) {
		setName("Computer Strategy Analyzer");
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		add(exit);
		add(gameDisplay);
		setLayout(new GridLayout(3,2,10,0));
	}
	private void buttonsLabels(){
		exit.addActionListener();
	}
}