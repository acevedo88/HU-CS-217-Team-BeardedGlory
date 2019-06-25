import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
	protected boolean decimalEnable = true;
	
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
		
		final int DIMR = 4;
		final int DIMC = 3;
		
		JPanel displayPanel = new JPanel();
		
		JPanel inputPanel = new JPanel();
		
		JPanel buttonPanel = new JPanel();
		
		JPanel operationPanel = new JPanel();
		
		//Creates the Number JButtons
		JButton numberButtons[][] = new JButton[DIMR][DIMC];
		//ButtonListener buttonListener = new ButtonListener();
		for (int row = 0; row < DIMR-1; row++) {
			for (int col = 0; col < DIMC; col++) {
				numberButtons[row][col] = new button_Number(""+((row*3)+(col+1)));
				numberButtons[row][col].addActionListener(new button_Number_Event(""+((row*3)+(col+1))));
				numberButtons[row][col].setPreferredSize(new Dimension(128,128));
			}
		}
		numberButtons[3][0] = new button_Number("+/-");
		numberButtons[3][0].addActionListener(new plusMinus_Number_Event("+/-"));
		numberButtons[3][1] = new button_Number("0");
		numberButtons[3][1].addActionListener(new button_Number_Event("0"));
		numberButtons[3][2] = new button_Number(".");
		numberButtons[3][2].addActionListener(new decimal_Number_Event("."));
		
		
		JButton operands = new JButton();
		JButton equals = new JButton();
		equals.setPreferredSize(new Dimension(140,90));
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
		
		//Creates number panel and buttons
		inputPanel.add(buttonPanel);
		buttonPanel.setPreferredSize(new Dimension(620,495));
		buttonPanel.setBorder(BorderFactory.createTitledBorder(""));
		buttonPanel.setLayout(new GridLayout(DIMR,DIMC));
		for (int row = 0; row < DIMR; row++) {
			for (int col = 0; col < DIMC; col++) {
				buttonPanel.add(numberButtons[row][col]);
			}
		}
		
		
		//Creates the operations panel and the operands
		inputPanel.add(operationPanel,BorderLayout.EAST);
		//operationPanel.setLayout(new BoxLayout(operationPanel, BoxLayout.PAGE_AXIS));
		operationPanel.setBorder(BorderFactory.createTitledBorder(""));
		operationPanel.setPreferredSize(new Dimension(150,495));
		for (int amount = 0; amount < 4; amount++) {
			
			operands = new JButton();
			operands.setPreferredSize(new Dimension(140,90));
			operationPanel.add(operands);
			
		}
		
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
		
		public button_Number (String digits) {
			// Empty Constructor
			this.setText(digits);
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
			numberPanel.setText(numberPanel.getText()+buttonText);
			
		}
		
	}
	
	private class plusMinus_Number_Event implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		
		private String buttonText;
		
		public plusMinus_Number_Event (String buttonText) {
			this.buttonText = buttonText;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//numberPanel.setText(numberPanel.getText()+buttonText);
			
		}
		
	}
	private class decimal_Number_Event implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		
		private String buttonText;
		
		public decimal_Number_Event (String buttonText) {
			this.buttonText = buttonText;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//numberPanel.setText(numberPanel.getText()+buttonText);
			if (decimalEnable == true) {
				numberPanel.setText(numberPanel.getText()+buttonText);
				decimalEnable = false;
			}
				
		}
		
	}

}