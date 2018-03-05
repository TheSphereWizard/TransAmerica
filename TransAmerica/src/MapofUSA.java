import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MapofUSA extends JPanel implements MouseListener, MouseMotionListener{
		Player currentPlayer;
		BufferedImage Map;
		int[] lastClick;
		Grid currentGrid;
		static ArrayList<City> allCities;

		void setCurrentGrid(Grid grid){//called at beginning of round
			currentGrid = grid;
		}
		void setCurrentPlayer(Player player){//called at beginning of each turn
			currentPlayer = player;
		}
		
		Position[] returnPlacedRail(){//checks placedMarker in Player, if true, returns marker info instead
			
		}
		public void paint(Graphics g){//redraws map with new rail networks
			
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
