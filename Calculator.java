import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/*
 * @author TEAM BeardedGlory
 * 
 * 
 * The Calculator class is the main class that will instantiate the GUI and 
 * calculate class for user interactions.
 * 
 */
public class Calculator {
	
	static JTextArea numberPanel;
	
	//fields
	private Stack<String> operators = new Stack<String>();
	private Stack<Double> numbers = new Stack<Double>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
		
		
		//GUI();
		
		
	}
	
	private static Double calculate() {
		
		
		return (double) 0;
	}
	
	/**
	 * GUI creates a new JFrame object, 
	 * creates an instance of the inner class GUI and
	 * displays it 
	 */
	private Calculator() {
		
		
		
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
		
		JPanel buttonPanel = new JPanel();
		
		JPanel operationPanel = new JPanel();
		
		JButton equals = new JButton();
		equals.setText("=");
		equals.setSize(300, 500);
		equals.addActionListener(new equalButtonListener());
		
		//Display panel displays
		mainPanel.add(displayPanel, BorderLayout.NORTH);
		displayPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		numberPanel = new JTextArea(5,65);
		displayPanel.add(numberPanel);
		numberPanel.setEditable(false);
		
		
		
		//Button panel displays
		mainPanel.add(inputPanel, BorderLayout.CENTER);
		inputPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		inputPanel.add(buttonPanel);
		buttonPanel.setPreferredSize(new Dimension(620,495));
		buttonPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		inputPanel.add(operationPanel,BorderLayout.EAST);
		operationPanel.setBorder(BorderFactory.createTitledBorder(""));
		operationPanel.setPreferredSize(new Dimension(150,495));
		
		operationPanel.add(equals);
		
		frame.pack();
		frame.setVisible(true);
		
	} // end startGUI
	
	
	// Equals button event handler.
	private class equalButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			// Sets results panel to calculated numbers.
			
			numberPanel.setText(calculate().toString());
			
		}
		
	}
	
	private class button_Number extends JButton {
		
		public button_Number () {
			// Empty Constructor
		}
		
	}
	
	private class button_Number_Event implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		
		private String buttonText;
		
		public button_Number_Event (String buttonText) {
			this.buttonText = buttonText;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}