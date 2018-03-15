import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
public class TransAmerica extends JFrame{
	public TransAmerica() {
		setTitle("TransAmerica");
		add(new MainMenu());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	static Timer t = new Timer();
	static TransAmerica transamerica;
	public static void main(String[] args){
		transamerica=new TransAmerica();
		t.schedule(new TimerTask(){
			public void run() {
				transamerica.repaint();
			}
		}, 0,10);
	}
}