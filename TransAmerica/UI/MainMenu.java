import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
					for(PlayerPanel p : validPanels){
						if(p.isHuman()){
							players.add(new HumanPlayer())
						}else{
							
						}
					}
					Game game = new Game(players,true);
					add(new MainGameScreen(game));
				}else{
					//progress to ai game
				}
			}
			
		} else if(e.getActionCommand().equals("Exit"))
			System.exit(0);
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	
//	private class PlayerPanel extends JPanel implements ActionListener{
//
//		private ButtonGroup group = new ButtonGroup();
//		private Color[] colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE , new Color(139,69,19), Color.white};
//		private String[] optionNames = {"None", "Human Player", "Computer"};
//		private JRadioButton[] options = new JRadioButton[3];
//		private JComboBox[] strategies = new JComboBox[2];
//		private String[] stratNames = {"Easy" , "Hard"};
//		private JPanel[] panes = new JPanel[4];
//		private JButton start = new JButton("Play"), exit = new JButton("Exit");
//		private JButton[] buttons = new JButton[] {start, exit};
//		private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		private JLabel errorMessage = new JLabel();
//		private JFrame errorMessageFrame = new JFrame("							Error Message");
//		private JPanel errorPanel = new JPanel();
//
//
//
//		PlayerPanel(int PlayerNum) { 
//
//			
//			this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
//			
//			for(int i = 0; i < options.length; i++) {
//				options[i] = new JRadioButton(optionNames[i]);
//				options[i].addActionListener(this);
//				options[i].setActionCommand(optionNames[i]);
//				options[i].setBackground(colors[i]);
//				group.add(options[i]);
//				this.add(options[i]);
//			}
////			options[0].setSelected(true);			
////			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
////			for(int i = 0; i < 6; i++){
////				this.add(new JLabel("Player " + i+ 1));
////			}
////			
////			for(int i = 0; i < options.length; i++) {
////				options[i] = new JRadioButton(optionNames[i]);
////				options[i].addActionListener(this);
////				options[i].setActionCommand(optionNames[i]);
////				options[i].setBackground(colors[i]);
////				group.add(options[i]);
////				this.add(options[i]);
////			}
////			options[0].setSelected(true);
////
//			for(int i = 0; i < strategies.length; i ++) {
//				strategies[i] = new JComboBox(stratNames);
//				this.setBackground(colors[i]);
//				this.add(new JLabel("Player " + (i+1)));
//			}
//		}
//
//
//
	
private class PlayerPanel extends JPanel implements ActionListener{
		
		private static final long serialVersionUID = 1L;
		private ButtonGroup group = new ButtonGroup();
		private Color[] colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE , new Color(139,69,19), Color.white};
		private String[] optionNames = {"None", "Human Player", "Computer"};
		private JRadioButton[] options = new JRadioButton[3];
		private JComboBox[] strategies = new JComboBox[2];
		private String[] stratNames = {"Easy" , "Hard"};
		private int noPlayers = 6;
		private boolean player = false;
		private boolean humanPlayer = false;

		public PlayerPanel(int playerNum) {
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
		}
		
		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(optionNames[0])) {
				player = false;
				humanPlayer = false;
			} else if(e.getActionCommand().equals(optionNames[1])) {
				noPlayers --;
				player = true;
				humanPlayer = true;
			} else if(e.getActionCommand().equals(optionNames[2])) {
				noPlayers --;
				player = true;
				humanPlayer = false;
			}
			
		}
		
		public boolean isPlayer() {
			return player;
		}
		
		public boolean isHuman(){
			return humanPlayer;
		}

	}
}



