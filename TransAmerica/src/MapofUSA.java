import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
		private void runtestcode() {
			setCurrentGrid(new Grid());
			Player p =new HumanPlayer(Color.blue, null, 4, "fish", this);
			currentGrid.placeMarker(new Position(15,14), p);
			try {
				currentGrid.placeRail(new Rail(new Position(0,0),new Position(0,1),p));
				currentGrid.placeRail(new Rail(new Position(0,1),new Position(1,1),p));
				currentGrid.placeRail(new Rail(new Position(1,1),new Position(1,2),p));
				currentGrid.placeRail(new Rail(new Position(1,1),new Position(2,1),p));
				currentGrid.placeRail(new Rail(new Position(21,1),new Position(22,1),p));
			} catch (Exception e) {
				e.printStackTrace();
			}
			Player p2 =new HumanPlayer(Color.red, null, 4, "fish", this);
			currentGrid.placeMarker(new Position(5,6), p2);
			try {
				currentGrid.placeRail(new Rail(new Position(10,0),new Position(10,1),p2));
				currentGrid.placeRail(new Rail(new Position(10,1),new Position(11,1),p2));
				currentGrid.placeRail(new Rail(new Position(11,1),new Position(11,2),p2));
				currentGrid.placeRail(new Rail(new Position(11,1),new Position(12,1),p2));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		private int[] siz;
		private int[] mappos;
		MapofUSA(int x, int y, int width, int height){
			mappos = new int[]{x,y};
			siz=new int[]{width,height};
			this.setBounds(x, y, width, height);
			runtestcode();
			scalefactor = new int[]{siz[0]/currentGrid.getBoardwidth(),siz[1]/currentGrid.getBoardheight()};
			try {
				highlighted=new Rail(new Position(0,0),new Position(0,1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final MapofUSA test = this;
			this.addMouseMotionListener(new MouseMotionListener(){
				public void mouseDragged(MouseEvent e) {}
				public void mouseMoved(MouseEvent e) {
					test.mouseMoved(e);
				}
			});
		}
		
		void setCurrentGrid(Grid grid){//called at beginning of round
			currentGrid = grid;
		}
		void setCurrentPlayer(Player player){//called at beginning of each turn
			currentPlayer = player;
		}
		Object returnPlacedRail(){//checks placedMarker in Player, if true, returns marker info instead
			if(firstturn){
				return placedmarker;
			}
			else{
				return placedRail;
			}
		}
		Rail highlighted;
		int[] scalefactor;
		public void paint(Graphics g){//redraws map with new rail networks
			g.translate(mappos[0], mappos[1]);
			g.drawRect(0, 0, siz[0], siz[1]);
			Graphics2D g2d = (Graphics2D)g;
			
			g2d.setStroke(new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			g.drawLine((int)(scalefactor[0]*(highlighted.p1.y%2==1?highlighted.p1.x+0.5d:highlighted.p1.x)), siz[1]-scalefactor[1]*highlighted.p1.y, (int)(scalefactor[0]*(highlighted.p2.y%2==1?highlighted.p2.x+0.5d:highlighted.p2.x)), siz[1]-scalefactor[1]*highlighted.p2.y);
			
			g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			for(Rail r: currentGrid.allRails){
				if(r.player!=null){
					g.setColor(r.player.record.getColor());
					g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}else{
					g.setColor(Color.black);
					g2d.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}
				g.drawLine((int)(scalefactor[0]*(r.p1.y%2==1?r.p1.x+0.5d:r.p1.x)), siz[1]-scalefactor[1]*r.p1.y, (int)(scalefactor[0]*(r.p2.y%2==1?r.p2.x+0.5d:r.p2.x)), siz[1]-scalefactor[1]*r.p2.y);
			}
			int markersize=9;
			for(Marker r: currentGrid.markers){
				if(r.player!=null){
					g.setColor(r.player.record.getColor());
					g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}else{
					g.setColor(Color.black);
					g2d.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}
				g.fillOval((int)(scalefactor[0]*(r.p.y%2==1?r.p.x+0.5d:r.p.x))-markersize/2, siz[1]-scalefactor[1]*r.p.y-markersize/2, markersize, markersize);
			}
		}
		boolean firstturn=true;
		Marker placedmarker;
		Rail placedRail;
		public void mouseClicked(MouseEvent e) {//when mouse is clicked, converts click (x, y) coordinates to grid coordinates, and then uses the grid validrail method to determine if rail is valid, if it is then add to lastClick, else ignore that it was clicked
			if(firstturn){
				placedmarker=new Marker(nearestPosition(e.getX(),e.getY()));
			}else{
				placedRail = nearestRail(e.getX(),e.getY());
			}
		}
		public void mouseMoved(MouseEvent e) {//updates highlighting of rail lines
			highlighted=nearestRail(e.getX(),e.getY());
		}
		//TODO below
		
		Rail nearestRail(int x, int y){
			x-=mappos[0];
			y-=mappos[1];
			try {
				return new Rail(new Position((int)Math.round(((double)x)/scalefactor[0]),(siz[1]-y)/scalefactor[1]),new Position(x/scalefactor[0]+1,(siz[1]-y)/scalefactor[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		Position nearestPosition(int x, int y){
			return null;
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseDragged(MouseEvent e) {}
}
