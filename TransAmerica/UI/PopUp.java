
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PopUp extends JFrame implements ActionListener {


	private JPanel popUps;
	private JPanel aiPopup;
	private JFrame frame;
	private JLabel question;
	private JTextField gameNumber;
	private JButton fast, slow;

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

	
	
	public static void main(String args[] ) {
		new PopUp();

		gameNumber = new JTextField();
		gameNumber.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		this.add(gameNumber);
		
		fast = new JButton("Fast Mode");
		fast.addActionListener(new ActionListener(){

			
		});
		this.add(fast);
		
		slow = new JButton("Slow Mode");
		slow.addActionListener(new ActionListener(){

			
		});
		this.add(slow);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
