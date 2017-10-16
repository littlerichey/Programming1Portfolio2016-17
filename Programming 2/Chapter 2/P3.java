import java.awt.Rectangle; 
import java.util.Random;
public class P3{
	public static void main(String[] args){
		Random r = new Random();
		int s = 101, x=r.nextInt(s),y=r.nextInt(s),w=r.nextInt(s),l=r.nextInt(s);
		Rectangle r1 = new Rectangle(x,y,w,l);
		x=r.nextInt(s);
		y=r.nextInt(s);
		w=r.nextInt(s);
		l=r.nextInt(s);
		Rectangle r2 = new Rectangle(x,y,w,l);
		Rectangle r3 = r1.intersection(r2);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3); // if get a negative they don't intersect.

	}
}