import java.awt.Rectangle;
public class P2{
	public static void main(String[] args){
		int x=100,y=100,w=50,l=50;
		Rectangle square = new Rectangle(x,y,w,l);
		System.out.println(square);
		square.grow(w/2,l/2);
		square.setLocation(x,y);
		System.out.println(square);
	}
}