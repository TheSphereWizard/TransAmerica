import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ComputerStrategyScreen extends JPanel{
	private JPanel players = new JPanel();
	public ComputerStrategyScreen(int gamesPlayed, int[] gamesWon, int[] gamesLost, int[] rank, double[] winPercentage) {
		add(new GeneralInfo(gamesPlayed));
		players.setLayout(new GridLayout(2,3,0,0));
		setPlayers(gamesWon, gamesLost, rank, winPercentage);
		add(players);
		setLayout(new GridLayout(2,1,0,0));
	}
	private void setPlayers(int[] gamesWon, int[] gamesLost, int[] rank, double[] winPercentage){
		Color[] colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE , new Color(139,69,19), Color.white};
		for(int i = 0; i < 6; i++){
			players.add(new PlayerInfo(gamesWon[i], gamesLost[i], rank[i], winPercentage[i], colors[i]));
		}
	}
	private class PlayerInfo extends JPanel{
		private PlayerInfo(int gamesWon, int gamesLost, int playerRank, double winPercentage, Color color){
			setLayout(new GridLayout(4,1,0,0));
			JLabel won = new JLabel("Games Won: " + gamesWon), lost = new JLabel("Games Lost: " + gamesLost),
					rank = new JLabel("Rank: " + playerRank), percentage = new JLabel("Win Percentage: " + winPercentage);
			setBackground(color);
			add(won);
			add(lost);
			add(rank);
			add(percentage);
		}
	}
	private class GeneralInfo extends JPanel implements ActionListener{
		private GeneralInfo(int gamesPlayed){
			JLabel played = new JLabel("Games played: "+gamesPlayed, SwingConstants.CENTER),
					title = new JLabel("Computer Strategy Analyzer", SwingConstants.CENTER);
			JButton exit = new JButton("Back to Main Menu");
			setLayout(new GridLayout(3,0,0,0));
			title.setFont(title.getFont().deriveFont (64.0f));
			add(title);
			exit.setFont(played.getFont().deriveFont (48.0f));
			exit.addActionListener(this);
			add(exit);
			played.setFont(played.getFont().deriveFont (48.0f));
			add(played);
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}