import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PopUp {
	private JPanel popUps;
	private JPanel aiPopup;
	
	public PopUp(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
