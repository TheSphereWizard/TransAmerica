
public class Rail {
	int x1,x2,y1,y2;
	Player player;
	int size;//0 is not placed, 1 is placed, 2 is double rail
	Rail(int X1, int Y1, int X2, int Y2, Player p, int Size){
		x1 = X1;
		x2 = X2;
		y1 = Y1;
		y2 = Y2;
		player = p;
		size = Size;
	}
}
