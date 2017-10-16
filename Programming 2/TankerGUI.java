// Import layout, Listeners and Controls
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.net.URL;
import javax.swing.ImageIcon;

public class TankerGUI{
	//Controls for App
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JTextField ozEntry, yrEntry;
	//URL timg = new URL("");
	//Constructor
	public TankerGUI(){
		prepareGUI();
	}
	//Entry Point
	public static void main(String[] args){
		TankerGUI swingTankerGUI = new TankerGUI();
		swingTankerGUI.showTextField();
	}

	//Setup for the GUI
	private void prepareGUI(){
		//Setup App Frame
		mainFrame = new JFrame("Tanker");
		mainFrame.setSize(400,400);

		//Setup Labels
		headerLabel = new JLabel("Tanker Truck Calculator",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(350,100);
		ozEntry = new JTextField(4);
		yrEntry = new JTextField(4);
		JLabel oztxt = new JLabel("Enter ounces: ");
		JLabel yrtxt = new JLabel("Enter years: ");
		//Setup Layout
		mainFrame.setLayout(new GridLayout(3,1));
		//Add controls
		/*mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});*/
		controlPanel = new JPanel();
		controlPanel.add(oztxt);
		controlPanel.add(ozEntry);
		controlPanel.add(yrtxt);
		controlPanel.add(yrEntry);

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
	}

	//Display Controls
	private void showTextField(){
		//set values for controls
		JButton run = new JButton("Calculate");
		//Action Listener for Button click
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click){
				float oz = (float) Float.valueOf(ozEntry.getText());
				float yr = (float) Float.valueOf(yrEntry.getText());
				oz *= (yr*365.25);
				oz /= (128*11000);
				statusLabel.setText("You'll drink " + oz + " Tankers full of fluid in your lifetime.");
				//timg = new URL("https://upload.wikimedia.org/wikipedia/commons/9/9b/Water_Tanker_Truck_20%2C_US_Air_Force.jpg");
				mainFrame.setVisible(true);
			}
		});
		//Place Controls on Panels
		controlPanel.add(run);

		//Don't forget to Set Visibility
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
}