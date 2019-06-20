import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * @author TEAM BeardedGlory
 * 
 * 
 * The Calculator class is the main class that will instantiate the GUI and 
 * calculate class for user interactions.
 * 
 */
public class Calculator {

	//fields
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GUI();
	}
	
	/**
	 * GUI creates a new JFrame object, 
	 * creates an instance of the inner class GUI and
	 * displays it 
	 */
	private static void GUI() {
		
		// new JFrame with exit option
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create and add main panel
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel);
		
		// Fill out the GUI here....
		mainPanel.setPreferredSize(new Dimension(800, 600));
		mainPanel.setLayout(new BorderLayout());
		
		JPanel displayPanel = new JPanel();
		
		JPanel inputPanel = new JPanel();
		
		mainPanel.add(displayPanel, BorderLayout.NORTH);
		mainPanel.add(inputPanel, BorderLayout.CENTER);
		
		
		
		frame.pack();
		frame.setVisible(true);
		
	} // end startGUI
	

}
