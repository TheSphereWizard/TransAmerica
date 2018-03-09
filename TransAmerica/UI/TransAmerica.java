import javax.swing.JFrame;
import javax.swing.JPanel;
public class TransAmerica extends JFrame{
	public TransAmerica() {
		setTitle("TransAmerica");
		setContentPane(new MainMenu());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void changeContentPane(JPanel newPanel){
		setContentPane(newPanel);
		setTitle(newPanel.getName());
	}
	public static void main(String[] args) {
		new TransAmerica();
	}
}