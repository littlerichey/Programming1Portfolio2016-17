public class Bank{
	private double bal;
	public Bank(){
		bal = 0;
	}
	public Bank(double ibal){
		bal = ibal;
	}
	public void deposit(double amt){
		bal+= amt;
	}
	public void withdraw(double amt){
		bal -= amt;
	}
	public double getBal(){
		return bal;
	}
}