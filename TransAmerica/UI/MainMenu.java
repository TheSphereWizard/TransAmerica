import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
//TransAmerica JPanel
public class MainMenu extends JPanel implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play") && noPlayers == 6) {
			errorMessageFrame.setVisible(true);
		} else if(e.getActionCommand().equals("Play") && noPlayers < 6) {

		} else if(e.getActionCommand().equals("Exit")) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}

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
	this.pack();
	this.setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
	this.setVisible(true);

}
private Class PlayerOptions(){
	private ButtonGroup group = new ButtonGroup();
	private Color[] colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE , new Color(139,69,19), Color.white};
	private String[] optionNames = {"None", "Human Player", "Computer"};
	private JRadioButton[] options = new JRadioButton[3];
	private JComboBox[] strategies = new JComboBox[2];
	private String[] stratNames = {"Easy" , "Hard"};
	private JPanel[] panes = new JPanel[4];
	private JButton start = new JButton("Play"), exit = new JButton("Exit");
	private JButton[] buttons = new JButton[] {start, exit};
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel errorMessage = new JLabel();
	private JFrame errorMessageFrame = new JFrame("							Error Message");
	private JPanel errorPanel = new JPanel();
	//private int noPlayers = 6;
	private PlayerOptions(){
		this.setBackground(colors[playerNum - 1]);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(new JLabel("Player " + playerNum));


		for(int i = 0; i < options.length; i++) {
			options[i] = new JRadioButton(optionNames[i]);
			options[i].addActionListener(this);
			options[i].setActionCommand(optionNames[i]);
			options[i].setBackground(colors[playerNum - 1]);
			group.add(options[i]);
			this.add(options[i]);
		}
		options[0].setSelected(true);

		for(int i = 0; i < strategies.length; i ++) {
			strategies[i] = new JComboBox(stratNames);
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(optionNames[0])) {

			} else if(e.getActionCommand().equals(optionNames[1])) {
				noPlayers --;
			} else if(e.getActionCommand().equals(optionNames[2])) 
				noPlayers --;

		}
		private JLabel backgroundPic = new JLabel(new ImageIcon("TransAmerica\\Pix\\TransAmerica\\Background.jpg"));
	}
}
}
