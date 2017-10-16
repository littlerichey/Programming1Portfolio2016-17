import java.util.Scanner;
import java.awt.Color;
import java.util.Random;
public class E11{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		boolean x = true;
		while(x){
			System.out.println("let's roll a die, how many side do you want it to have?");
			int s = sc.nextInt();
			int r = rand.nextInt(s) + 1;
			System.out.println("You got:" + r);
			System.out.println("Would you like to roll again? y/n:");
			char w = sc.next().charAt(0);
			if (w=='y') {
				x=true;	
			}else{
				x=false;
			}	
		}

	
	}
}; 