package NOTHING;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Screen {
	private static int[] cur = new int[]{0,0};
	private static int[] prev = new int[]{0,0};
	protected static int[] trans = new int[]{0,0};
	private static boolean once = true;
	public static JFrame frame = new JFrame();
	static Timer T=new Timer();
	static BrianPanel o;
	public static void makeScreen(final BrianPanel O, int i){
		frame.dispose();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(O);
		o=O;
        T.schedule(new TimerTask(){
        	public void run(){
        		frame.repaint();
        	}
        }, 0,i);
        frame.setVisible(true);
	}
	static void addMouseListener(){
		frame.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				o.doclick(e);}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {o.dopress(e);}
			public void mouseReleased(MouseEvent e) {
				once=true;
				o.dorelease(e);
			}
        }
        );
	}
}

