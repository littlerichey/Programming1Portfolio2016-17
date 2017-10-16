import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import javafx.scene.shape.Circle;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
public class P9{
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Point p1 = new Point(100,100);
		Point p2 = new Point(200,200);
		Point p3 = new Point(100,200);
		Point p4 = new Point(150,150);
		Point p5 = new Point(250,50);
		Ellipse2D.Float c1 = new Ellipse2D.Float(100,100,2,2);
		Ellipse2D.Float c2 = new Ellipse2D.Float(200,200,2,2);
		Ellipse2D.Float c3 = new Ellipse2D.Float(100,200,2,2);
		Ellipse2D.Float c4 = new Ellipse2D.Float(150,150,2,2);
		Ellipse2D.Float c5 = new Ellipse2D.Float(250,50,2,2);
		Line2D.Float l1 = new Line2D.Float(p1,p2);
		g2.draw(c1);
	}
	public static void main(String[] args){
		JFrame f = new JFrame("lines");
		f.setSize(400,400);
		JPanel jp = new JPanel();
		f.setVisible(true);

 
		
		
	}
}