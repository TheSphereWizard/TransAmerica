import javax.swing.JFrame;
public class TransAmerica extends JFrame{
	public TransAmerica() {
		setTitle("TransAmerica");
		add(new MainMenu());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	static TransAmerica transamerica;
	public static void main(String[] args){
		transamerica=new TransAmerica();
	}
	
	//I have now pushed
}