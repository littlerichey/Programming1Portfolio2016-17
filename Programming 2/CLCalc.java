import java.util.Scanner;
public class CLCalc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean x = true;
		while(x){
			System.out.println("Welcome to a basic calculator. \nInput your first number:");
			float f = sc.nextFloat();
			System.out.println("What operater would you like to use?");
			char o = sc.next().charAt(0);
			System.out.println("Input your second number:");
			float s = sc.nextFloat();
			if(o=='+'){
				float e = f+s;
				System.out.println("Your result is " + e);  
			} else if (o=='-') {
				float e = f-s;
				System.out.println("Your result is " + e); 
			} else if (o=='*') {
				float e = f*s;
				System.out.println("Your result is " + e); 
			} else if (o=='/') {
				float e = f/s;
				System.out.println("Your result is " + e); 
			} else{
				System.out.println("invalid operater");
			}
			System.out.println("Would you like to try again? y/n:");
			char w = sc.next().charAt(0);
			if (w=='y') {
				x=true;	
			}else{
				x=false;
			}	
		}
	}
}