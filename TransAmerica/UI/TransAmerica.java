import javax.swing.JFrame;
public class TransAmerica extends JFrame{
	public TransAmerica() {
		setTitle("TransAmerica");
		setContentPane(new MainMenu());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	public static void main(String[] args){
		new TransAmerica();
	}
}