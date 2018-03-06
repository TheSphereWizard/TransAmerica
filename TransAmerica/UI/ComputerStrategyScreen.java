import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class ComputerStrategyScreen extends JPanel{
	
	JTextArea a = new JTextArea();
	JTextArea b = new JTextArea();
	JTextArea c = new JTextArea();
	JTextArea d = new JTextArea();
	JTextArea e = new JTextArea();
	
	public ComputerStrategyScreen(int gamesPlayed, int[] gamesWon, int[] gamesLost, int[] rank,
			double[] winPercentage) {
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(d);
		this.add(e);
		a.setText("Games Played \n" +gamesPlayed);
		b.setText("Games Won \n" +gamesWon);
		c.setText("Games Lost \n" +gamesLost);
		d.setText("Rank \n" +rank);
		e.setText("winPercentyage \n" +winPercentage);
		
	}
	public static void main(String[] args){
		
	}

}
