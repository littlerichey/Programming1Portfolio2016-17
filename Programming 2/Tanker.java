import java.util.Scanner;
public class Tanker {
	public static void main(String[] args) {
		String[] truck = {"____________________________","|                          |","|                          |______","|                          |   |\\ \\","|                          |   |_| \\_","|                          |        |","|__________________________|________|","     0                0","    0 0              0 0","     0                0"};
		int t=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to tanker calculator. \nInput your daily fluid consumption in ounces:");
		float f = sc.nextFloat();
		System.out.println("Input your estimated longevity:");
		float s = sc.nextFloat();
		f *= (s*365.25);
		f /= (128*11000);
		System.out.println("In your life you'll drink " + f + " tankers full of fluid");	
		while(f >= 0.1){
			System.out.println(truck[t]);
			t++;
			if (t==10){
				t = 0;
			}
			f -= 0.1;
		}
	}
}