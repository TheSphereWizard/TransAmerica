import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PopUp extends JPanel{
	private JPanel popUps;
	private JPanel aiPopup;
	private JFrame frame;
	private JLabel question;
	private JTextField gameNumber;
	private JButton fast, slow;
	
	public PopUp(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		question = new JLabel("How many games are to be played?");
		this.add(question);
		
		gameNumber = new JTextField();
		gameNumber.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String numOfGames = 
				
			}
			
		});
		this.add(gameNumber);
		
		fast = new JButton("Fast Mode");
		fast.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		this.add(fast);
		
		slow = new JButton("Slow Mode");
		slow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		this.add(slow);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
