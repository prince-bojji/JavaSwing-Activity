/*
 * Program created by: Jehan S. Batang
 * Section: BSCS 2-5
 * Subject: Object Oriented Programming
 * 
 * Activity 2
 */

import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.awt.Font;

public class Menu extends JFrame implements ActionListener, ItemListener{
	public int fact = 1, sum = 0, output;
	public String pattern = "";
	
	//Label for Titles
	JLabel lblHeader = new JLabel("Choose any of the following:");
	JLabel lblLength = new JLabel("Input the length of the sequence:");
	JLabel lblOutput = new JLabel("Output:");
	
	//Label Error Messages
	JLabel lblErrorInput = new JLabel("*Please enter an integer");
	JLabel lblExceed = new JLabel("*Input exceed the maximum number of terms (Please enter number 1-22)");
	
	//Text Field for Input and Output
	JTextField txtLength = new JTextField(3);
	JTextField txtOutput = new JTextField(10);
	
	//Radio Button and Button
	JRadioButton radNumberPattern      = new JRadioButton("Number Pattern",false);
	JRadioButton radFibonacciSequence  = new JRadioButton("Fibonacci Sequence",false);
	JRadioButton radSumOfSequence      = new JRadioButton("Sum of Sequence",false);
	JRadioButton radFactorial          = new JRadioButton("Factorial",false);
	ButtonGroup grpRadio               = new ButtonGroup();
	JButton btnOk   = new JButton("OK");
	JButton btnReset = new JButton("RESET");
	JButton btnClose = new JButton("CLOSE");
	
	public Menu(String n) {
		super(n);
		Container cont = getContentPane(); 
		getContentPane().setLayout(null);
	
		//Fonts
		lblHeader.setForeground(Color.WHITE);lblHeader.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblLength.setForeground(Color.WHITE);lblLength.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtLength.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOutput.setForeground(Color.WHITE);lblOutput.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtOutput.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		radNumberPattern.setForeground(Color.BLACK);radNumberPattern.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radFibonacciSequence.setForeground(Color.BLACK);radFibonacciSequence.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radSumOfSequence.setForeground(Color.BLACK);radSumOfSequence.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radFactorial.setForeground(Color.BLACK);radFactorial.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 15));btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		//Position
		lblHeader.setBounds(129, 59, 377, 31);lblErrorInput.setBounds(480, 50, 144, 14);
		lblExceed.setBounds(129, 316, 469, 14);lblLength.setBounds(145, 17, 471, 31);
		txtLength.setBounds(504, 19, 67, 29);txtLength.setHorizontalAlignment(JTextField.RIGHT);
		lblOutput.setBounds(251, 232, 95, 31);txtOutput.setBounds(23, 274, 575, 31);
		radNumberPattern.setBounds(234, 112, 158, 23);radFibonacciSequence.setBounds(234, 138, 158, 23);
		radSumOfSequence.setBounds(234, 164, 163, 23);radFactorial.setBounds(234, 190, 131, 23);
		btnOk.setBounds(129, 356, 85, 31);btnReset.setBounds(262, 356, 84, 31);btnClose.setBounds(403, 356, 85, 31);
	
		//Adding to the Container
		cont.add(lblHeader);cont.add(lblErrorInput);cont.add(lblExceed);cont.add(lblLength);
		cont.add(txtLength);cont.add(lblOutput);cont.add(txtOutput);cont.add(radNumberPattern); 
		radNumberPattern.addItemListener(this);cont.add(radFibonacciSequence); 
		radFibonacciSequence.addItemListener(this);cont.add(radSumOfSequence); 
		radSumOfSequence.addItemListener(this);	cont.add(radFactorial); radFactorial.addItemListener(this);
		grpRadio.add(radNumberPattern);grpRadio.add(radFibonacciSequence);grpRadio.add(radSumOfSequence);
		grpRadio.add(radFactorial);cont.add(btnOk); btnOk.addActionListener(this);cont.add(btnReset); 
		btnReset.addActionListener(this);cont.add(btnClose); btnClose.addActionListener(this);
	
		//Set the Text Field
		txtLength.setEditable(true);txtOutput.setEditable(false);
		
		//Window
		setResizable(false);
		setVisible(true); 
		cont.setBackground(new Color(56,53,53,255));
		setSize(650,470); 
		setLocationRelativeTo(null);
	}
	
	//Check if the Input is Valid
	public boolean inputValidation() {
		try {
			Integer.parseInt(txtLength.getText());
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	//Calculate Pattern
	public void calculatePattern() {
		int length = Integer.parseInt(txtLength.getText()), num = 1;
		if(length > 23)
			lblExceed.setForeground(Color.RED);
		else
			lblExceed.setForeground(Color.DARK_GRAY);
		
		for(int i = 0; i < length; i++) {
			num += i;
			pattern += num+" ";
		}
	}
	
	//Calculate Fibonacci Sequence
	public void calculateFiboSequence() {
		int length = Integer.parseInt(txtLength.getText());
		if(length > 21)
			lblExceed.setForeground(Color.RED);
		else
			lblExceed.setForeground(Color.DARK_GRAY);
		
		int numFirst = 1, numSecond = 1, numNext;
		for(int i = 0; i < length; i++) {
			pattern += numFirst+" ";
			numNext = numFirst + numSecond;
			numFirst = numSecond;
			numSecond = numNext;
		}
	}
	
	//Calculate Sum of Sequence
	public void calculateSumOfSequence() {
		int length = Integer.parseInt(txtLength.getText());
		for(int i = 1; i <= length; i++) {
			sum += i;
		}
	}

	//Calculate Factorial
	public void calculateFactorial() {
		int length = Integer.parseInt(txtLength.getText());
		for(int i = 1; i <= length; i++) {
			fact *= i;
		}
	}
	
	//Display Output
	public void displayOutput() {
		if(output == 1)
			txtOutput.setText("Pattern: "+pattern);
		else if(output == 2)
			txtOutput.setText("Sequence: "+pattern);
		else if(output == 3)
			txtOutput.setText("Sum is: "+String.valueOf(sum));
		else
			txtOutput.setText("Factorial is: "+String.valueOf(fact));	
	}
	
	//Reset All Components
	public void reset() {
		grpRadio.clearSelection();txtLength.setText("");txtOutput.setText("");
		lblExceed.setForeground(Color.DARK_GRAY);lblHeader.setForeground(Color.WHITE);
		pattern = "";removeError();fact = 1;sum = 0;
	}
	
	//Display Error Messages
	public void displayError() {
		grpRadio.clearSelection();lblErrorInput.setForeground(Color.RED);
	}
	
	//Remove Error Messages
	public void removeError() {
		lblErrorInput.setForeground(Color.DARK_GRAY);lblHeader.setForeground(Color.DARK_GRAY);
	}
	
	//Driver Class
	public static void main(String[] args) {
		Menu menu = new Menu("Menu");
	    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) {
			if(inputValidation() == true) {
				if(output == 1 || output == 2 || output == 3 || output == 4) {
					displayOutput();removeError();lblHeader.setForeground(Color.DARK_GRAY);
				}
				else
					lblHeader.setForeground(Color.RED);
			}
			else
				displayError();
		}
		else if(e.getSource() == btnReset)
			reset();
		else
			System.exit(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == radNumberPattern) {
			if(inputValidation() == true) {
				calculatePattern();output = 1;removeError();
		    } 
			else
				displayError();
		}
		else if(e.getSource() == radFibonacciSequence) {
			if(inputValidation() == true) {
				calculateFiboSequence();output = 2;removeError();
			}
			else
				displayError();
		}
		else if(e.getSource() == radSumOfSequence) {
			if(inputValidation() == true) {
				calculateSumOfSequence();output = 3;removeError();
			}
			else
				displayError();
		}
		else if(e.getSource() == radFactorial) {
			if(inputValidation() == true) {
				calculateFactorial();output = 4;removeError();
			}
			else
				displayError();
		}
	}
}

