package NOTHING;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class BrianPanel extends JPanel{
	static boolean drawing = true;
	public void dostuff(){
		this.repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		g.translate(Screen.trans[0],Screen.trans[1]);
	}
	public void doclick(MouseEvent e) {}
	public void doclick(boolean b) {}
	public void  dodrag(MouseEvent e){}
	public void  dopress(MouseEvent e){}
	public void  dorelease(MouseEvent e){}
	public void  keything(KeyEvent e){}
	public void domove(MouseEvent e) {}
}
