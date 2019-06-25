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
	private double resultObtained = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
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
		
		//operand buttons
		
		JButton addition = new operandButton("+");
		addition.setPreferredSize(new Dimension(140,90));
		addition.setSize(300, 500);
		addition.addActionListener(new operandButtonListener("+"));
		
		JButton subtraction = new operandButton("-");
		subtraction.setPreferredSize(new Dimension(140,90));
		subtraction.setSize(300, 500);
		subtraction.addActionListener(new operandButtonListener("-"));
		
		JButton multiplication = new operandButton("*");
		multiplication.setPreferredSize(new Dimension(140,90));
		multiplication.setText("x");
		multiplication.setSize(300, 500);
		multiplication.addActionListener(new operandButtonListener("*"));
		
		JButton division = new operandButton("/");
		division.setPreferredSize(new Dimension(140,90));
		division.setText("/");
		division.setSize(300, 500);
		division.addActionListener(new operandButtonListener("/"));
		
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
		
		operationPanel.add(addition);
		operationPanel.add(subtraction);
		operationPanel.add(multiplication);
		operationPanel.add(division);
		operationPanel.add(equals);
		
		
		frame.pack();
		frame.setVisible(true);
		
	} // end startGUI
	
	private double calculate() 
	{
		
		
		while (numbers.isEmpty() == false) 
		{
			double tmp1 = numbers.pop();
			double tmp2 = numbers.pop();
			String operation = operators.pop();
			//loop pablo created here
			
			if(operation == "+")
			{
				resultObtained = resultObtained + (tmp1+tmp2);
			}
			
			else if(operation == "-")
			{
				resultObtained = resultObtained + (tmp1-tmp2);
			}
			
			else if(operation == "*")
			{
				resultObtained = resultObtained + (tmp1*tmp2);
			}
			
			else if(operation == "/")
			{
				resultObtained = resultObtained + (tmp1/tmp2);
			}
			
		}	
		
		return resultObtained;
	}
	
	// Equals button event handler.
	private class equalButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			// Sets results panel to calculated numbers.
			if (numberPanel.getText().length()>1) 
			{
				numbers.push(Double.parseDouble(numberPanel.getText().substring(1, numberPanel.getText().length())));
			}
			if (numberPanel.getText().length()==1) 
			{
				numbers.push(Double.parseDouble(numberPanel.getText()));
			}
			
			numberPanel.setText(""+calculate());
			
		}
		
	}
	
	
	private class operandButton extends JButton {
		public operandButton (String operation) {
			
			this.setText(operation);
		}
		
	}
	
	
	private class operandButtonListener implements ActionListener {
		private String operation;
		
		public operandButtonListener(String operation) {
			this.operation = operation;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			// Sets results panel to calculated numbers.
			
			//substring manipulation goes here
			
			if (numberPanel.getText().length()>1) {
			numbers.push(Double.parseDouble(numberPanel.getText().substring(1, numberPanel.getText().length())));
			}
			if (numberPanel.getText().length()==1) 
			{
				numbers.push(Double.parseDouble(numberPanel.getText()));
				
			}
		
			
					
			//numbers.push(Double.parseDouble(numberPanel.getText()));
			//numbers.push(numToPush);
			operators.push(operation);
			numberPanel.setText(operation+"");
					
			
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