import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PopUp extends JPanel implements ActionListener{
	//private JPanel popUps;
	//private JPanel aiPopup;
	private JFrame frame;
	private JLabel question;
	private JTextField gameNumber;
	private JButton fast, slow;
	private int numberOfGivenGames;
	
	public PopUp(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		question = new JLabel("How many games are to be played?");
		this.add(question);
		
		gameNumber = new JTextField();
		gameNumber.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String numOfGames = gameNumber.getText();
				int number = Integer.parseInt(numOfGames);
				numberOfGivenGames = number;
			}
			
		});
		this.add(gameNumber);
		
		fast = new JButton("Fast Mode");
		fast.addActionListener(this);
		this.add(fast);
		
		slow = new JButton("Slow Mode");
		slow.addActionListener(this);
		this.add(slow);
		
		frame = new JFrame("Strategy Analysis Mode");
		frame.setSize(300, 150);
		frame.setResizable(false);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public int numberOfGamesToBeRun(){
		return numberOfGivenGames;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			try {
			     Integer.parseInt(gameNumber.getText());
			}
			catch (NumberFormatException num) {
			    ErrorMessage error = new ErrorMessage();
			    return;
			}
		if(e.getSource().equals(fast)){
			
		}else if(e.getSource().equals(slow)){
			
		}
		
	}
	
}
