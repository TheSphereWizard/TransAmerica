import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
public class ComputerStrategyScreen extends JPanel{
	Image img;
	public ComputerStrategyScreen(int gamesPlayed, int[] gamesWon, int[] gamesLost, int[] rank,
			double[] winPercentage) {
		JFrame frame = new JFrame();
		frame.setContentPane(this);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img = Toolkit.getDefaultToolkit().createImage("Screen.PNG");

		frame.setVisible(true);
	}
}
