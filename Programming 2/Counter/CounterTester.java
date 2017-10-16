  
public class CounterTester{
	public static void main(String[] args){
		Counter c1 = new Counter();
		System.out.println(c1.getValue());
		c1.click();
		System.out.println(c1.getValue());
		c1.click();
		System.out.println(c1.getValue());
		c1.reset();
		System.out.println(c1.getValue());
	}
}
