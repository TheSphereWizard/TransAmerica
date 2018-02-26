import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TransAmerica extends JPanel {
	
	JFrame screen;
	
	ArrayList<JRadioButton> radioButtons;
	
	ArrayList<Player> player;
	
	JComboBox combo1, combo2, combo3, combo4, combo5 , combo6;
	
	JPanel popUpForAiGame;
	
	
	
	public void main(String args[]) {
		new TransAmerica();
	}
	
	public void paint(Graphics g){
		
	}
	
	/**
	 * Makes the JFrame, adds main menu to it 
	 * make time to update everything every 1/60th frame
	 * @param none
	 */
	TransAmerica() {
		screen = new JFrame("Screen");
		
	}
	
	public void runGame() {
		
	}

	
	public void runAIGame() {
		
	}
	

}
