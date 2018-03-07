import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
			map.setCurrentGrid(new Grid());
			Player p =new HumanPlayer(Color.blue, null, 4, "fish", map);
			try {
				map.currentGrid.placeRail(new Rail(new Position(0,0),new Position(0,1),p));
				map.currentGrid.placeRail(new Rail(new Position(0,1),new Position(1,1),p));
				map.currentGrid.placeRail(new Rail(new Position(1,1),new Position(1,2),p));
				map.currentGrid.placeRail(new Rail(new Position(1,1),new Position(2,1),p));
				map.currentGrid.placeRail(new Rail(new Position(21,1),new Position(22,1),p));
			} catch (Exception e) {
				e.printStackTrace();
			}
			Player p2 =new HumanPlayer(Color.red, null, 4, "fish", map);
			try {
				map.currentGrid.placeRail(new Rail(new Position(10,0),new Position(10,1),p2));
				map.currentGrid.placeRail(new Rail(new Position(10,1),new Position(11,1),p2));
				map.currentGrid.placeRail(new Rail(new Position(11,1),new Position(11,2),p2));
				map.currentGrid.placeRail(new Rail(new Position(11,1),new Position(12,1),p2));
				//map.currentGrid.placeRail(new Rail(new Position(121,1),new Position(122,1),p));
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			int[] scalefactor = new int[]{siz[0]/currentGrid.getBoardwidth(),siz[1]/currentGrid.getBoardheight()};
			for(Rail r: currentGrid.allRails){
				g.setColor(r.player.record.getColor());
				g.drawLine((int)(scalefactor[0]*(r.p1.y%2==0?r.p1.x+0.5d:r.p1.x)), siz[1]-scalefactor[1]*r.p1.y, (int)(scalefactor[0]*(r.p2.y%2==0?r.p2.x+0.5d:r.p2.x)), siz[1]-scalefactor[1]*r.p2.y);
			}
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
