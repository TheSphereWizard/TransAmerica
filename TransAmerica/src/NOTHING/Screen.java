import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
	public static void makeScreen(final BrianPanel O,int i,boolean f) {
		frame.dispose();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(O);
		o=O;
        T.schedule(new TimerTask(){
        	public void run(){
        		O.dostuff();
        	}
        }, 10,i);
        addMouseListener();
        addMouseMotionListener();
        frame.setVisible(true);
	}
	public static void makeScreen(final BrianPanel O) {
		frame.dispose();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(O);
		o=O;
        T.schedule(new TimerTask(){
        	public void run(){
        		O.dostuff();
        		if (O.drawing)
        		frame.repaint();
        	}
        }, 10);
        addMouseListener();
        addMouseMotionListener();
        frame.setVisible(true);
	}
	public static void makeScreen(final BrianPanel O,int xsiz,int ysiz) {
		frame.dispose();
		frame.setUndecorated(true);
		frame.setSize(xsiz,ysiz);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(O);
		o=O;
        T.schedule(new TimerTask(){
        	public void run(){
        		O.dostuff();
        		if (O.drawing)
        		frame.repaint();
        	}
        }, 10);
        addMouseListener();
        addMouseMotionListener();
        frame.setVisible(true);
	}
	public static void makeScreen(final BrianPanel O, int i){
		frame.dispose();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(O);
		o=O;
        T.schedule(new TimerTask(){
        	public void run(){
        		O.dostuff();
        		if (O.drawing)
        		frame.repaint();
        	}
        }, 0,i);
        addMouseListener();
        addMouseMotionListener();
        frame.setVisible(true);
        
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
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
	static void addMouseMotionListener(){
		frame.addMouseMotionListener(new MouseMotionListener(){
        	public void mouseDragged(MouseEvent e) {
        		cur = new int[]{e.getX(),e.getY()};
        		if (once){
        			prev = new int[]{e.getX(),e.getY()};
        			once=false;
        		}
        		trans = new int[]{trans[0]+cur[0]-prev[0],trans[1]+cur[1]-prev[1]};
    			prev=cur.clone();
    			o.dodrag(e);
			}
			public void mouseMoved(MouseEvent e) {o.domove(e);}
        });
	}
	static class MyDispatcher implements KeyEventDispatcher {
        public boolean dispatchKeyEvent(KeyEvent e) {
        	o.keything(e);
            if (e.getID() == KeyEvent.KEY_PRESSED||e.getID()==402) {
            	if (e.getKeyCode() == KeyEvent.VK_SPACE){
            		trans=new int[]{0,0};
            	}
            }
            return false;
            
        }
	}
}

