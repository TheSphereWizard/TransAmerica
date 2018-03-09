import javax.swing.JFrame;
import javax.swing.JPanel;
public class TransAmerica extends JFrame{
	public TransAmerica() {
		setTitle("TransAmerica");
		setContentPane(new MainMenu());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	public void changeContentPane(JPanel newPanel){
		setContentPane(newPanel);
	}
	public static void main(String[] args) {
		new TransAmerica();
	}
}


