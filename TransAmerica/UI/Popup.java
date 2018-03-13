import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Popup extends JFrame{
	private JPanel popUps;
	
	public Popup(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
