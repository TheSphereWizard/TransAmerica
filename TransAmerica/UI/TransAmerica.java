import javax.swing.JFrame;
public class TransAmerica extends JFrame{
	private static int[] TESTWINS = new int[6], TESTLOSS= new int[6], TESTRANK= new int[6];
	private static double[] TESTPERCENTAGE= new double[6];
	public TransAmerica() {
		setTitle("TransAmerica");
		add(new ComputerStrategyScreen(10, TESTWINS, TESTLOSS, TESTRANK, TESTPERCENTAGE));
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