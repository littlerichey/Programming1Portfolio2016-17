import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class E17{
	public static void main(String[] args) throws Exception{
		URL il = new URL("https://cdn.pixabay.com/photo/2013/07/13/11/34/apple-158419__480.png");
		JOptionPane.showMessageDialog(null, "Whapow!", "Apple", JOptionPane.PLAIN_MESSAGE, new ImageIcon(il));
	}
}