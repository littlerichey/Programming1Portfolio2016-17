import javax.swing.JOptionPane;

public class E15{
	public static void main(String[] args){
		String name = JOptionPane.showInputDialog("What is your name?");
		JOptionPane.showMessageDialog(null, "Hello, " + name);
	}
}