import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class PopUp extends JPanel implements ActionListener{
	//private JPanel popUps;
	//private JPanel aiPopup;
	private JFrame frame;
	private JLabel question;
	private JTextField gameNumber;
	private JButton fast, slow;
	private int numberOfGivenGames;
	
	MainMenu main;
	public PopUp(MainMenu m){
		main=m;
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
		int games;
		try {
		     games=Integer.parseInt(gameNumber.getText());
		}
		catch (NumberFormatException num) {
		    return;
		}
		if(games>0){
			if(e.getSource().equals(fast)){
				
			}else if(e.getSource().equals(slow)){
				ArrayList<Player> players = new ArrayList<Player>();//need to actually get the players
				ArrayList<Color> playerColors = new ArrayList<Color>();
				ArrayList<String> playerNames = new ArrayList<String>();
				ArrayList<String> playerType = new ArrayList<String>();
				ArrayList<MainMenu.PlayerPanel> validPanels = new ArrayList<MainMenu.PlayerPanel>();
				for(MainMenu.PlayerPanel p: main.playerPanels){
					if(p.isPlayer()){
						validPanels.add(p);
					}
				}
				for(MainMenu.PlayerPanel p : validPanels){
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
				for(int i=0;i<games;i++){
					MainGameScreen screen = new MainGameScreen(main.generate(playerColors,playerNames,playerType));
					TransAmerica.transamerica.add(screen);
					TransAmerica.transamerica.remove(0);
					TransAmerica.transamerica.dispose();
					JFrame f = new JFrame();
					f.add(screen);
					TransAmerica.transamerica = f;
					TransAmerica.transamerica.setTitle("TransAmerica");
					TransAmerica.transamerica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					TransAmerica.transamerica.dispose();
					TransAmerica.transamerica.setUndecorated(true);
					TransAmerica.transamerica.setExtendedState(JFrame.MAXIMIZED_BOTH);
					TransAmerica.transamerica.setVisible(true);
					TransAmerica.transamerica.repaint();
				}
			}
		}	
	}
	
}
