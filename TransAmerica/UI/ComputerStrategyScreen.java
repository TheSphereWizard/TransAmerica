import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class ComputerStrategyScreen extends JPanel{
	Image img;
	ComputerStrategyScreen(){
		JFrame frame = new JFrame();

		frame.setContentPane(this);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 img = Toolkit.getDefaultToolkit().createImage("Screen.PNG");
		 
		frame.setVisible(true);
	}
	public static void main(String[] args){
		new ComputerStrategyScreen();
	}

}
