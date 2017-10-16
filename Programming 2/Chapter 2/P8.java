import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Point;
public class P8{
	public static void main(String[] args){
		Point p1 = new Point(100,100);
		Point p2 = new Point(200,200);
		Point p3 = new Point(100,200);
		Point p4 = new Point(150,150);
		Point p5 = new Point(250,50);
		Line2D.Float l1 = new Line2D.Float(p1,p2);
		l1.setLine(p1, p2);
		System.out.println(l1.ptSegDist(p3));
		System.out.println(l1.ptSegDist(p4));
		System.out.println(l1.ptSegDist(p5));
	}
}