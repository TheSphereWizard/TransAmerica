import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener{


	private JPanel[] panes = new JPanel[4];
	private JButton start = new JButton("Play"), exit = new JButton("Exit");
	private JButton[] buttons = new JButton[] {start, exit};
	private PlayerPanel[] playerPanels = new PlayerPanel[6];

	MainMenu() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));		

		for(int i = 0; i < panes.length; i++) {
			panes[i] = new JPanel();
			panes[i].setBackground(Color.WHITE);
			this.add(panes[i]);
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

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start")) {
			int readyPlayers = 0;
			for(PlayerPanel p:playerPanels){
				if(p.isPlayer()){
					readyPlayers++;
				}
			}
			if(readyPlayers>=2){//starts the game, either human or all ai
				ArrayList<PlayerPanel> validPanels = new ArrayList<PlayerPanel>();
				for(PlayerPanel p:playerPanels){
					if(p.isPlayer()){
						validPanels.add(p);
					}
				}
				boolean humanGame = false;
				for(PlayerPanel p: validPanels){
					if(p.isHuman()){
						humanGame = true;
					}
				}
				if(humanGame){
					ArrayList<Player> players = new ArrayList<Player>();//need to actually get the players
					ArrayList<Color> playerColors = new ArrayList<Color>();
					ArrayList<String> playerNames = new ArrayList<String>();
					ArrayList<String> playerType = new ArrayList<String>();
					for(PlayerPanel p : validPanels){
						if(p.isHuman()){
							playerColors.add(p.getBackground());
							playerNames.add(p.getName());
							playerType.add("Human");
						}else{
							playerColors.add(p.getBackground());
							playerNames.add(p.getName());
							playerType.add(p.getStrategy());
						}
					}
					MainGameScreen screen = new MainGameScreen();
					add(screen);
					screen.generate(playerColors, playerNames, playerType);
					System.out.println("Reached!");
				}else{
					//progress to ai game
//					something.popup;
//					ComputerStrategyScreen screen = new ComputerStrategyScreen();//pass this all the info from popup
//					add(screen);
				}
			}
			
		} else if(e.getActionCommand().equals("Exit"))
			System.exit(0);
	}
	
private class PlayerPanel extends JPanel implements ActionListener{
	
	/* Notes for Jack 
	 * Create textField for name that only shows up when "Human Player" is selected
	 * Create combo box to house strategies, only make it visible when computer player is selected
	 * Create method to return strategy selected in the combo box
	 */
		
		private static final long serialVersionUID = 1L;
		private ButtonGroup group = new ButtonGroup();
		private Color[] colors = new Color[] {new Color(255, 40, 40), Color.YELLOW, Color.GREEN, Color.BLUE , new Color(139,69,19), Color.white};
		private String[] optionNames = {"None", "Human Player", "Computer"};
		private JRadioButton[] options = new JRadioButton[3];
		private String[] stratNames = {"Easy" , "Hard"};
		private JComboBox<String> strategy = new JComboBox<String>(stratNames);
		
		private int noPlayers = 6;
		private boolean player = false;
		private boolean humanPlayer = false;
		private JTextField name;
		private Timer T=new Timer();
		
		public void paint(Graphics g){
			super.paint(g);
			g.drawRect(-10, -10, 20, 20);
		}

		int playernum;

		
		public String getDifficulty() {
			//Should return selected strategy Name
			return null;
		}
		public PlayerPanel(int playerNum) {
			playernum=playerNum-1;
			setBackground(colors[playerNum - 1]);
//			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			setLayout(null);
			JLabel playernumber = new JLabel("Player " + playerNum);
			playernumber.setFont(new Font("Arial",Font.BOLD,24));
			playernumber.setLocation(50,0);
			playernumber.setSize(100, 50);
			add(playernumber);
			name = new JTextField();
			name.setText("Player " + playerNum);
			
			for(int i = 0; i < options.length; i++) {
				options[i] = new JRadioButton(optionNames[i]);
				options[i].addActionListener(this);
				options[i].setActionCommand(optionNames[i]);
				options[i].setBackground(colors[playerNum - 1]);
				options[i].setLocation(50,50*(i+1));
				options[i].setSize(150, 20);
				group.add(options[i]);
				
				add(options[i]);
				
				if(i == 1) {
					add(name);
					name.setVisible(false);
					name.setBounds(70, 120, 60, 25);
				} else if(i == 2) {
					add(strategy);
					strategy.setVisible(false);
					strategy.setBounds(70, 170, 60, 25);
				}
			}
			options[0].setSelected(true);
			
//			for(int i = 0; i < strategies.length; i ++) {
//				strategies[i] = new JComboBox(stratNames);
//			}
			
			this.setPreferredSize(new Dimension(400,200));
		}
		
		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(optionNames[0])) {
				player = false;
				humanPlayer = false;
				name.setVisible(false);
				strategy.setVisible(false);
			} else if(e.getActionCommand().equals(optionNames[1])) {
				noPlayers --;
				player = true;
				humanPlayer = true;
				name.setVisible(true);
				strategy.setVisible(false);
			} else if(e.getActionCommand().equals(optionNames[2])) {
				noPlayers --;
				player = true;
				humanPlayer = false;
				name.setVisible(false);
				strategy.setVisible(true);
			}
			TransAmerica.transamerica.setSize(0, 0);
			TransAmerica.transamerica.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		
		public boolean isPlayer() {
			return player;
		}
		
		public boolean isHuman(){
			return humanPlayer;
		}
		
		public String getName() {
			return name.getText();
		}
		
		public String getStrategy() {
			return (String)strategy.getSelectedItem();
		}

	}
}



