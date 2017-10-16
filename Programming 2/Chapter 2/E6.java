import java.util.Scanner;
public class E6{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("What phrase would you like to have the \"e\"s and \"o\"s switched in?");
		String s = sc.nextLine();;
		char[] cs = s.toCharArray();
		for (int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 'o'){
				cs[i] = 'e';
			}else if (s.charAt(i) == 'e') {
				cs[i] ='o';	
			}

		}
		//s = String.valueOf(cs);
		System.out.println(String.valueOf(cs));
	}
}