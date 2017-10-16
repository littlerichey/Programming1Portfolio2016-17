import java.lang.Math;
public class E4 {
	public static void main(String[] args){
		float p = 1000;
		double r = 0.05;
		for(int t = 1; t <=3; t++){
			System.out.println("year " + t + ":  " + (p*java.lang.Math.pow((1+r),t)));
		}
	}
}