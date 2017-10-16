public class BankTester{
	public static void main(String[] args){
		Bank harold = new Bank(700);
		System.out.println(harold.getBal());
		harold.deposit(8);
		System.out.println(harold.getBal());
		harold.withdraw(97);
		System.out.println(harold.getBal());
	}
}