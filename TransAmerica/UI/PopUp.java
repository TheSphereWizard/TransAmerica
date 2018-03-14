<<<<<<< HEAD
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.*;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> branch 'master' of https://github.com/TheSphereWizard/TransAmerica

<<<<<<< HEAD
public class PopUp extends JFrame implements ActionListener{
=======
import javax.swing.*;

public class PopUp extends JPanel{
	private JPanel popUps;
	private JPanel aiPopup;
	private JFrame frame;
	private JLabel question;
	private JTextField gameNumber;
	private JButton fast, slow;
>>>>>>> branch 'master' of https://github.com/TheSphereWizard/TransAmerica
	
<<<<<<< HEAD
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
=======
	public PopUp(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		question = new JLabel("How many games are to be played?");
		this.add(question);
>>>>>>> branch 'master' of https://github.com/TheSphereWizard/TransAmerica
		
<<<<<<< HEAD
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
=======
		gameNumber = new JTextField();
		gameNumber.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
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
>>>>>>> branch 'master' of https://github.com/TheSphereWizard/TransAmerica
	}
}
