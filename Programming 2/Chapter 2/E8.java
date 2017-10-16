import java.util.Scanner;
import java.awt.Color;
public class E8{
	public static void main(String[] args){
		int r=0, g=100, b=150;
		Color rgb = new Color(r, g, b);
		rgb= rgb.brighter();
		System.out.println(rgb); 
	}

}