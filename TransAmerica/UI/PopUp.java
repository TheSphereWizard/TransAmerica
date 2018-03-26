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
	
	public double[] sort(double[] gamesWon){
		double[] sorted = new double[gamesWon.length];
		int maximum = 0;
		for(int counter = 1; counter<=sorted.length;counter++){
			int i = 0;
			int maxIndex = 0;
			for(;i<gamesWon.length;i++){
				if(gamesWon[i]>maximum){
					maximum = (int) gamesWon[i];
					maxIndex = i;
				}
			}
			sorted[maxIndex]=counter;
			gamesWon[maxIndex]=0;
			maximum = 0;
		}
		return sorted;
	}
	
	public double[][] runGames(int games, ArrayList<Player> players){
		double[] gamesWon = new double[players.size()];
		double[] gamesLost = new double[players.size()];
		for(;games>0;games--){
			Game game = new Game(players, false);
			game.runGame();
			ArrayList<Player> winningPlayers = game.getWinningPlayerforGame();
			for(Player p: winningPlayers){
				for(int i = 0;i<players.size();i++){
					if(p.equals(players.get(i))){
						gamesWon[i]++;
					}else{
						gamesLost[i]++;
					}
				}
			}
		}
		double[] rank = sort(gamesWon);
		double[] winPercentage = new double[players.size()];
		for(int i = 0;i<players.size();i++){
			double winPer = gamesWon[i]/(gamesWon[i]+gamesLost[i]);
			winPercentage[i]=winPer;
		}
		double[][] bigArray = {gamesWon,gamesLost,rank,winPercentage};
		return bigArray;
		
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
				ArrayList<Player> players = new ArrayList<Player>();
				double[][] info = runGames(games,players);
				ComputerStrategyScreen screen = new ComputerStrategyScreen(games,info[0],info[1],info[2],info[3]);
					StrategyAnalyzer analyzer = new StrategyAnalyzer(players);
					TransAmerica.transamerica.add(analyzer);
					TransAmerica.transamerica.remove(this);
					TransAmerica.transamerica.dispose();
					JFrame f = new JFrame();
					f.add(analyzer);
					TransAmerica.transamerica = f;
					TransAmerica.transamerica.setTitle("TransAmerica");
					TransAmerica.transamerica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					TransAmerica.transamerica.dispose();
					TransAmerica.transamerica.setUndecorated(true);
					TransAmerica.transamerica.setExtendedState(JFrame.MAXIMIZED_BOTH);
					TransAmerica.transamerica.setVisible(true);
					TransAmerica.transamerica.repaint();
				
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
