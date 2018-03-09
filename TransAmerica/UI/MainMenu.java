import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

private class PlayerPanel extends JPanel implements ActionListener{

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



	MainMenu() { 

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(new JLabel("Player " + 6));
		for(int i = 0; i < options.length; i++) {
			options[i] = new JRadioButton(optionNames[i]);
			options[i].addActionListener(this);
			options[i].setActionCommand(optionNames[i]);
			options[i].setBackground(colors[i]);
			group.add(options[i]);
			this.add(options[i]);
		}
		options[0].setSelected(true);

		for(int i = 0; i < strategies.length; i ++) {
			strategies[i] = new JComboBox(stratNames);
			this.setBackground(colors[i]);
			this.add(new JLabel("Player " + (i+1)));
		}
	}
	public void actionPerformed(ActionEvent e) {


	}
}
public class MainMenu extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image background;

		g.drawImage(background, 0, 0, null);

	}

	g.drawImage(background, 0, 0, null);

	MainMenu() {

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

	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	this.setContentPane(contentPane);
	this.pack();
	this.setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
	this.setVisible(true);
	}
}

