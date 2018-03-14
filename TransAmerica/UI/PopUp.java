import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.*;

public class PopUp extends JFrame implements ActionListener{
	
	private JTextField numberofGames = new JTextField();
	private JPanel contentPane = new JPanel();
	private JLabel label = new JLabel("How many games are to be played ?");
	private JRadioButton fast = new JRadioButton("Fast") , slow = new JRadioButton("Slow");
	private JPanel[] panes = new JPanel[3];
	
	
	 PopUp() {
		 
		 contentPane.setLayout(new GridLayout(3,1));
		 
		 for(int i = 0; i < panes.length; i ++) {
			 panes[i]= new JPanel();
			 contentPane.add(panes[i]);
		 }
		
		 panes[0].add(label);
		 panes[1].add(numberofGames);
		 panes[3].setLayout(new GridLayout(1,2));
		 panes[3].add(fast);
		 panes[3].add(slow);
		 
		 add(contentPane);
		 setSize(500,500);
		 setLocationByPlatform(true);
		 setVisible(true);
	}

	 
	 
	 
	public void actionPerformed(ActionEvent e) {
			
	}
	
	public static void main(String args[] ) {
		new PopUp();
	}
}
