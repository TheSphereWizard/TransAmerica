import java.awt.GridLayout;

import javax.swing.*;
public class ComputerStrategyScreen extends JPanel{
	JButton exit = new JButton("Exit");
	JLabel gamesPlayed = new JLabel("Games played: ");
	public ComputerStrategyScreen(int gamesPlayed, int[] gamesWon, int[] gamesLost, int[] rank, double[] winPercentage) {
		setName("Computer Strategy Analyzer");
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(exit);
		//add();
		setLayout(new GridLayout(3,2,10,0));
	}
}