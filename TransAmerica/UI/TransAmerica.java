import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
public class TransAmerica{
	public TransAmerica() {
		transamerica = new JFrame();
		transamerica.setTitle("TransAmerica");
		transamerica.add(new MainMenu());
		transamerica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		transamerica.setExtendedState(JFrame.MAXIMIZED_BOTH);
		TransAmerica.transamerica.dispose();
		TransAmerica.transamerica.setUndecorated(true);
		transamerica.setVisible(true);
	}
	static Timer t = new Timer();
	static JFrame transamerica;
	public static void main(String[] args){
		new TransAmerica();
		t.schedule(new TimerTask(){
			public void run() {
				transamerica.repaint();
			}
		}, 0,10);
	}
}