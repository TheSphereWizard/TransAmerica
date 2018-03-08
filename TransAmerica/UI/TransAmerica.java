import javax.swing.JFrame;
import javax.swing.JPanel;
public class TransAmerica extends JFrame{
	public TransAmerica() {
<<<<<<< HEAD
		setTitle("TransAmerica");
		setContentPane(new MainMenu());
		setVisible(true);
=======
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("TransAmerica");
		
		errorMessage.setText("                      Error! Not Enough Players");
		errorMessage.setAlignmentX(CENTER_ALIGNMENT);
		errorPanel.setLayout(new GridLayout(2,1));
		errorPanel.add(errorMessage);
		errorPanel.add(exit);
		errorMessageFrame.setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
		errorMessageFrame.setSize(300, 150);
		errorMessageFrame.setResizable(false);
		errorMessageFrame.add(errorPanel);
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));		
		
		for(int i = 0; i < panes.length; i++) {
			panes[i] = new JPanel();
			panes[i].setBackground(Color.WHITE);
			contentPane.add(panes[i]);
		}
		
		panes[0].add(new JLabel("TransAmerica"));
		
		for(int i = 0; i < playerPanels.length - 3; i++) {
			playerPanels[i] = new PlayerPanel(i + 1);
			panes[1].add(playerPanels[i]);
		}
		
		for(int i = 3; i < playerPanels.length; i++) {
			playerPanels[i] = new PlayerPanel(i + 1);
			panes[2].add(playerPanels[i]);
		}
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand(buttons[i].getText());
			panes[3].add(buttons[i]);
		}
				
		this.setContentPane(contentPane);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
>>>>>>> branch 'master' of https://github.com/TheSphereWizard/TransAmerica
	}
	public void changeContentPane(JPanel newPanel){
		setContentPane(newPanel);
	}
	public static void main(String[] args) {
		new TransAmerica();
	}
}