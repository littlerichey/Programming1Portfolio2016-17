import java.awt.Rectangle;
public class P1{
	public static void main(String[] args){
		int x=0,y=0,w=5,l=10;
		Rectangle box = new Rectangle(x,y,w,l);
		System.out.println(box);
		box.setLocation(x+w,y);
		System.out.println(box);
		box.setLocation(x+w,y+l);
		System.out.println(box);
		box.setLocation(x,y+l);
		System.out.println(box);
	}
}