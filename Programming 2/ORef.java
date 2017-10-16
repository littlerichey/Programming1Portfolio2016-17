import javafx.scene.shape.Circle;
public class ORef{
	public static void main(String[] args){
		Circle c1 = new Circle(3); // this stores the constructed object in memory and c1 is a reference to the memory location where it is stored
		Circle c2 = c1;
		c1.setRadius(4);
		System.out.println(c2.getRadius()); // prints out "4"
	}
}