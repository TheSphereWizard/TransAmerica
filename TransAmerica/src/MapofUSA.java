import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapofUSA extends JPanel implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = 1L;

		/*
		rounding error on left side of screen
		make rails not be placed at all if invalid, 
		make markers be placed in valid position	
	
		*/
	
	
		//Need to Make turns not skipped and make sure turns work properly
		//ALSO NEEDS TO DRAW MOUNTAINS SOMEHOW: BIGGER SIZE RAIL?
		BufferedImage Map;
		
		Player currentPlayer;
		static Grid currentGrid;
		
		private int[] siz;
		private int[] mappos;
		
		static ArrayList<City> allCities;
//		public static void main(String[] red){
////			System.out.println(oddmod(16,2));
//			//MapofUSA map = new MapofUSA(0,100,1200,600);
//			//Screen.makeScreen(map,10);
//		}
		private void runtestcode() {
			setCurrentGrid(new Grid());
//			Player p =new HumanPlayer(Color.blue, null, 4, "fish", this);
//			currentGrid.placeMarker(new Position(15,14), p);
//			try {
//				currentGrid.placeRail(new Rail(new Position(0,0),new Position(0,1),p));
//				currentGrid.placeRail(new Rail(new Position(0,1),new Position(1,1),p));
//				currentGrid.placeRail(new Rail(new Position(1,1),new Position(1,2),p));
//				currentGrid.placeRail(new Rail(new Position(1,1),new Position(2,1),p));
//				currentGrid.placeRail(new Rail(new Position(21,1),new Position(22,1),p));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			ArrayList<City> pi = new ArrayList<City>();
			Player p2 =new HumanPlayer(Color.red, pi, "fish");
//			currentGrid.placeMarker(new Position(5,6), p2);
//			try {
//				currentGrid.placeRail(new Rail(new Position(10,0),new Position(10,1),p2));
//				currentGrid.placeRail(new Rail(new Position(10,1),new Position(11,1),p2));
//				currentGrid.placeRail(new Rail(new Position(11,1),new Position(11,2),p2));
//				currentGrid.placeRail(new Rail(new Position(11,1),new Position(12,1),p2));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			this.setCurrentPlayer(p2);
		}
		

		MapofUSA(int x, int y, int width, int height,Grid grid){
			currentGrid=grid;

			try {
				Map=ImageIO.read(new File("Pix\\mapofusa.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mappos = new int[]{x,y};
			siz=new int[]{width,height};
			this.setBounds(x, y, width, height);
			//runtestcode();
			scalefactor = new int[]{siz[0]/Grid.boardwidth,siz[1]/Grid.boardheight};
			scalefactord = new double[]{((double)siz[0])/Grid.boardwidth,((double)siz[1])/Grid.boardheight};
			System.out.println(scalefactord[0]+" "+scalefactord[1]);
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
			this.addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {test.mouseClicked(e);}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
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
				if(placedmarker!=null){
					Marker red = placedmarker;
					placedmarker=null;
//					System.out.println("Reeded");
					return red;
				}
//				System.out.println("Radfsadfafdafdeeded");
				return null;
			}
			else{
//				System.out.println("Rsdfdse");
				Rail r =placedRail;
				placedRail=null;
				return r;
			}
		}
		
		Rail highlighted;
		Position highlightedmarker=new Position(0,0);
		int[] scalefactor;
		double[] scalefactord;
		int[] mos=new int[]{0,0};
		int[] mos2=new int[]{0,0};
		int markersize=26;
		int citysize=14;
		
		void drawposline(double x1, double y1, double x2, double y2, Graphics g){
			y1++;
			y2++;
			g.drawLine((int)(scalefactor[0]*(y1%2==0?x1+0.5d:x1)), (int)(siz[1]-scalefactor[1]*y1), (int)(scalefactor[0]*(y2%2==0?x2+0.5d:x2)), (int) (siz[1]-scalefactor[1]*y2));
		}
		
		public void paint(Graphics g){//redraws map with new rail networks
			Graphics2D g2d = (Graphics2D)g;
			
//			g.translate(mappos[0], mappos[1]);
			g.setColor(Color.gray);
			g2d.setStroke(new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			g.drawRect(0, 0, siz[0], siz[1]);
			g.drawImage(Map,-50, -30, siz[0]+100, siz[1]+60, null);
//			g.drawString(dist+"", 0, 10);
//			g.drawString(nearest.x+" "+nearest.y, 0, 30);
//			g.drawString(((siz[1]-mos[1]-1)/scalefactor[1])%2+"", 0, 50);
//			g2d.setStroke(new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			
//			g.drawLine(x1, y1, x2, y2);
//			drawposline(4,5,6,7,g);
//			g.drawOval(mos[0]-5, mos[1]-5, 10, 10);
			
			
//			for(int i=siz[0]/3;i<siz[0];i++){
//				for(int j=3*siz[1]/4;j<siz[1];j++){
////					try {
////						Rail r= nearestRail(i,j);
////						
////					} catch (Exception e) {}
//					int c= colorcode(i,j);
//					if(c==0){
//						g.setColor(Color.BLACK);//doesn't work for x=0
//					}
//					if(c==1){
//						g.setColor(Color.yellow);
//					}
//					if(c==2){
//						g.setColor(Color.BLUE);
//					}
//					if(c==3){
//						g.setColor(Color.green);
//					}
////					g.fillRect(i, j, 2, 2);
//					g.drawLine(i, j, i, j);
//				}
//			}
			if(currentGrid!=null&currentPlayer!=null){
			g.setColor(currentPlayer.record.getColor());
			if(firstturn){
				g.fillOval((int)(scalefactor[0]*(highlightedmarker.y%2==1?highlightedmarker.x+0.5d:highlightedmarker.x))-markersize/2, siz[1]-scalefactor[1]*(highlightedmarker.y+1)-markersize/2, markersize, markersize);
				
			}else{
				g2d.setStroke(new BasicStroke(8,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				if(currentGrid.alllegalrails.contains(highlighted))
					g.drawLine((int)(scalefactor[0]*(highlighted.p1.y%2==1?highlighted.p1.x+0.5d:highlighted.p1.x)), siz[1]-scalefactor[1]*(highlighted.p1.y+1), (int)(scalefactor[0]*(highlighted.p2.y%2==1?highlighted.p2.x+0.5d:highlighted.p2.x)), siz[1]-scalefactor[1]*(highlighted.p2.y+1));
			}
			g.drawString(highlightedmarker.x+" "+highlightedmarker.y, 0, 50);
			g.setColor(Color.black);
			for(Rail r: currentGrid.alllegalrails){
				g2d.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				g.drawLine((int)(scalefactor[0]*((r.p1.y)%2==1?r.p1.x+0.5d:r.p1.x)), siz[1]-scalefactor[1]*(r.p1.y+1), (int)(scalefactor[0]*((r.p2.y)%2==1?r.p2.x+0.5d:r.p2.x)), siz[1]-scalefactor[1]*(r.p2.y+1));
				//g.drawLine((int)(scalefactor[0]*(r.p1.x)), siz[1]-scalefactor[1]*(r.p1.y+1), (int)(scalefactor[0]*(r.p2.x)), siz[1]-scalefactor[1]*(r.p1.y+1));
			}
			for(int i=0;i<currentGrid.allRails.size();i++){
				Rail r = currentGrid.allRails.get(i);
				if(r.player!=null){
					g.setColor(r.player.record.getColor());
					g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}else{
					g.setColor(Color.black);
					g2d.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}
				
				g.drawLine((int)(scalefactor[0]*((r.p1.y)%2==1?r.p1.x+0.5d:r.p1.x)), siz[1]-scalefactor[1]*(r.p1.y+1), (int)(scalefactor[0]*((r.p2.y)%2==1?r.p2.x+0.5d:r.p2.x)), siz[1]-scalefactor[1]*(r.p2.y+1));
			}
			
			for(Marker r: currentGrid.markers){
				if(r.player!=null){
					g.setColor(r.player.record.getColor());
					g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}else{
					g.setColor(Color.black);
					g2d.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				}
				g.fillOval((int)(scalefactor[0]*((r.p.y)%2==1?r.p.x+0.5d:r.p.x))-markersize/2, siz[1]-scalefactor[1]*(r.p.y+1)-markersize/2, markersize, markersize);
			}
			
			
			for(City[] cer : currentGrid.allcities){
				for(City c : cer){
					g.setColor(c.color);
					g.drawString(c.getName(), (int)(scalefactor[0]*((c.p.y)%2==1?c.p.x+0.5d:c.p.x))-citysize/2, siz[1]-scalefactor[1]*(c.p.y+1)-citysize/2);
					g.fillOval((int)(scalefactor[0]*((c.p.y)%2==1?c.p.x+0.5d:c.p.x))-citysize/2, siz[1]-scalefactor[1]*(c.p.y+1)-citysize/2, citysize, citysize);
				}
			}
			for(int i=0;i<currentPlayer.record.citiesReached.size();i++){
				g.setColor(Color.black);
				g.drawString(currentPlayer.record.citiesReached.get(i).getName(), 0, -10-10*i);
			}
//			int sizer = 20;
//			ArrayList<Rail> ne=new ArrayList<Rail>();
//			try{
//				ne = currentGrid.immediateneighbors(nearest);
//			}catch(Exception E){}
//			for(int i=0;i<ne.size();i++){
//				sizer = 20-i*2;
//				Position p =ne.get(i);
//				g.fillOval((int)(scalefactor[0]*((p.y)%2==1?p.x+0.5d:p.x))-sizer/2, siz[1]-scalefactor[1]*(p.y+1)-sizer/2, sizer, sizer);
//			}
//			Position p =nearest;
//			g.setColor(Color.red);
//			g.fillOval((int)(scalefactor[0]*((p.y)%2==1?p.x+0.5d:p.x))-sizer/2, siz[1]-scalefactor[1]*(p.y+1)-sizer/2, sizer, sizer);
			
			if(currentPlayer.startMarker!=null){
				try {
					ok = currentGrid.allValidMovesForPlayer(currentPlayer);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Rail r : ok){
					g2d.setStroke(new BasicStroke(2));
					drawposline(r.p1.x,r.p1.y,r.p2.x,r.p2.y,g);
				}
			}
			}
		}
		ArrayList<Rail> ok =new ArrayList<Rail>();
		
		Rail colortoRail(int one,int x, int y){
			Rail returnrail=null;
			Position p1,p2;
			switch (one){
				case 2: 
					if(((siz[1]-y-scalefactor[1]/2-1)/scalefactor[1])%2==1){
						x-=scalefactor[0]/2;
					}
					p1=new Position(x/scalefactor[0],((siz[1]-y-scalefactor[1]/2-1)/scalefactor[1]));
					p2=new Position(x/scalefactor[0]+1,((siz[1]-y-scalefactor[1]/2-1)/scalefactor[1]));
					try {
						returnrail=new Rail(p1,p2,currentPlayer);
					} catch (Exception e) {}
					
				break;
				case 1: 
					if(((siz[1]-y-1)/scalefactor[1])%2==1){
						x-=scalefactor[0]/2;
						p1=new Position(x/scalefactor[0]+1,((siz[1]-y-1)/scalefactor[1])-1);
						p2=new Position(x/scalefactor[0]+1,((siz[1]-y-1)/scalefactor[1]));
					}else{
						p1=new Position(x/scalefactor[0],((siz[1]-y-1)/scalefactor[1])-1);
						p2=new Position(x/scalefactor[0]+1,((siz[1]-y-1)/scalefactor[1]));
					}
					try {
						returnrail=new Rail(p1,p2,currentPlayer);
					} catch (Exception e) {}
				
				break;
				case 3: one=3;
					if(((siz[1]-y-1)/scalefactor[1])%2==1){
						x-=scalefactor[0]/2;
						p1=new Position(x/scalefactor[0]+1,((siz[1]-y-1)/scalefactor[1])-1);
						p2=new Position(x/scalefactor[0],((siz[1]-y-1)/scalefactor[1]));
					}else{
						p1=new Position(x/scalefactor[0],((siz[1]-y-1)/scalefactor[1])-1);
						p2=new Position(x/scalefactor[0],((siz[1]-y-1)/scalefactor[1]));
					}
					try {
						returnrail=new Rail(p1,p2,currentPlayer);
					} catch (Exception e) {}
				break;
			}
			return returnrail;
		}
		int colorcode(int x,int y){
			if(y+scalefactor[1]>siz[1])
				return 0;
			int[] init= new int[]{x,y};
			if(((siz[1]-y-scalefactor[1]/2-1)/scalefactor[1])%2==1){
				x-=scalefactor[0]/2;
			}
			if(y%scalefactor[1]<oddmod(x,scalefactord[0]/2)/2){
				return 2;
			}
			y=siz[1]-y;
			if(y%scalefactor[1]<oddmod(x,scalefactord[0]/2)/2){
				return 2;
			}
			x=init[0];
			if(x%scalefactord[0]<scalefactord[0]/2){
				if(((siz[1]-y-1)/scalefactor[1])%2==1){
					return 3;
				}
				return 1;
				
			}
			if(((siz[1]-y-1)/scalefactor[1])%2==1){
				return 1;
			}
			return 3;
		}
		Rail nearestRail(int x, int y) throws Exception{
			int c = colorcode(x,y);
			return colortoRail(c,x,y);
		}
		
		
		static double oddmod(double ee, double er){
			ee%=er*2;
			if(ee<er){
				return ee;
			}
			return er-ee%er;
		}
		static boolean firstturn=true;
		static Marker placedmarker;
		Rail placedRail;
		public void mouseClicked(MouseEvent e) {//when mouse is clicked, converts click (x, y) coordinates to grid coordinates, and then uses the grid validrail method to determine if rail is valid, if it is then add to lastClick, else ignore that it was clicked
//			System.out.println("hello");
			int x = e.getX();//-mappos[0];
			int y = e.getY();//-mappos[1];
			if(firstturn){
				placedmarker=new Marker(nearestPosition2(x,y),currentPlayer);
//				firstturn=false;
//				System.out.println("Re");
			}else{
				try {
					if(nearestRail(x,y)!=null)
						placedRail = nearestRail(x,y);
				} catch (Exception e1) {}
			}
//			System.out.println(mos[0]+" "+mos[1]);
		}
		public void mouseMoved(MouseEvent e) {//updates highlighting of rail lines
			int x = e.getX();//-mappos[0];
			int y = e.getY();//-mappos[1];
//			mos=new int[]{(int) (x+oddmod(y,scalefactor[1])/2),y};
			mos=new int[]{x,(int) (y-oddmod(x,scalefactor[0]/2)/2)};
			if(firstturn){
				highlightedmarker = nearestPosition2(x,y);
			}else{
				try {
					if(nearestRail(x,y)!=null)
						highlighted = nearestRail(x,y);
				} catch (Exception e1) {}
			}
			nearest=nearestPosition2(x,y);
		}
		private Position nearestPosition2(int x, int y) {
			if(((siz[1]-y-scalefactor[1]/2-1)/scalefactor[1])%2==1)
				return new Position((int)Math.round(((double)(x-scalefactor[0]/2))/scalefactor[0]),(siz[1]-(y+scalefactor[1]/2)-1)/scalefactor[1]);
			else
				return new Position((int)Math.round(((double)x)/scalefactor[0]),(siz[1]-(y+scalefactor[1]/2)-1)/scalefactor[1]);
		}
		
		//TODO below
		
		double dist =0;
		Position nearest=new Position(0,0);
		double[] exact = new double[]{0,0};		
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseDragged(MouseEvent e) {}
}
