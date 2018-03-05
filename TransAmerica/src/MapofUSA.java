import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import NOTHING.*;

public class MapofUSA extends BrianPanel implements MouseListener, MouseMotionListener{
		Player currentPlayer;
		BufferedImage Map;
		private Rail lastClick;
		Grid currentGrid;
		static ArrayList<City> allCities;
		public static void main(String[] red){
			MapofUSA map = new MapofUSA(0,100,1400,700);
			Screen.makeScreen(map,10);
		}
		private int[] siz;
		private int[] mappos;
		MapofUSA(int x, int y, int width, int height){
			mappos = new int[]{x,y};
			siz=new int[]{width,height};
			this.setBounds(x, y, width, height);
		}
		void setCurrentGrid(Grid grid){//called at beginning of round
			currentGrid = grid;
		}
		void setCurrentPlayer(Player player){//called at beginning of each turn
			currentPlayer = player;
		}
		
		Rail returnPlacedRail(){//checks placedMarker in Player, if true, returns marker info instead
			return lastClick;
		}
		public void paint(Graphics g){//redraws map with new rail networks
			g.translate(mappos[0], mappos[1]);
			g.drawRect(0, 0, siz[0], siz[1]);
			
		}
		public void mouseClicked(MouseEvent e) {//when mouse is clicked, converts click (x, y) coordinates to grid coordinates, and then uses the grid validrail method to determine if rail is valid, if it is then add to lastClick, else ignore that it was clicked
			
		}
		public void mouseMoved(MouseEvent e) {//updates highlighting of rail lines
			
		}
		
		
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseDragged(MouseEvent e) {}
}
