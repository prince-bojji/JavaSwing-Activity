/*
 * Program created by: Jehan S. Batang
 * Section: BSCS 2-5
 * Subject: Object Oriented Programming
 * 
 * Activity 2 2nd half
 * 
 * A program with a graphic user interface using Swing allows the user to enter the side, length, 
 * and width. Then choose if you want to get the area or perimeter of the square and rectangle.  
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Polygon extends JFrame implements ActionListener, ItemListener{
	private float side1, length, width, areaSquare, perimeterSquare, 
				  areaRectangle, perimeterRectangle;
	//Labels for Title
	private final JLabel lblHeader     = new JLabel("Welcome to Polygon Calculator");
	private final JLabel lblSquare     = new JLabel("Square");
	private final JLabel lblRectangle  = new JLabel("Rectangle");
	private final JLabel lblSquare2    = new JLabel("Square");
	private final JLabel lblRectangle2 = new JLabel("Rectangle");
	private final JLabel lblSide1      = new JLabel("Side 1");
	private final JLabel lblLength     = new JLabel("Length");
	private final JLabel lblWidth      = new JLabel("Width");
	private final JLabel lblArea       = new JLabel("Area");
	private final JLabel lblPerimeter  = new JLabel("Perimeter");
	
	//Labels for Error Messages
	private final String prompt   = "* Input should be a valid numbers";
	private JLabel lblErrorSide1  = new JLabel(prompt);
	private JLabel lblErrorLength = new JLabel(prompt);
	private JLabel lblErrorWidth  = new JLabel(prompt);
	
	//Text Fields for Input and Output
	private JTextField textSide1      = new JTextField(15);
	private JTextField textLength     = new JTextField(15);
	private JTextField textWidth      = new JTextField(15);
	private JTextField textArea       = new JTextField(15);
	private JTextField textArea2      = new JTextField(15);
	private JTextField textPerimeter  = new JTextField(15);
	private JTextField textPerimeter2 = new JTextField(15);
	
	//Radio Buttons and Buttons
	private JRadioButton radioArea       = new JRadioButton("Area",false);
	private JRadioButton radioPerimeter  = new JRadioButton("Perimeter",false);
	private ButtonGroup groupRadio       = new ButtonGroup();
	private JButton buttonReset = new JButton("RESET");
	private JButton buttonClose = new JButton("CLOSE");
	
	public Polygon(String n) {
		super(n);
		Container cont = getContentPane();
		JPanel panel = new JPanel();
		getContentPane().setLayout(null);
		
		positioning(panel);	
	    font(cont);	
		getContent(cont);     
		setTextField();
		window(cont); 
				
		radioArea.addItemListener(this);	
		radioPerimeter.addItemListener(this);
		buttonReset.addActionListener(this);
		buttonClose.addActionListener(this);
	}

	//Position
	public void positioning(JPanel panel) {
		panel.setBounds(0, 0, 10, 10); getContentPane().add(panel);
		lblHeader.setBounds(143, 0, 268, 29); lblSquare.setBounds(19, 48, 54, 14);
		lblRectangle.setBounds(19, 99, 67, 19); lblSide1.setBounds(106, 48, 46, 14); 
		textSide1.setBounds(163, 40, 225, 30); textSide1.setHorizontalAlignment(JTextField.RIGHT);
		lblLength.setBounds(106, 97, 63, 23); textLength.setBounds(163, 94, 225, 31);
		textLength.setHorizontalAlignment(JTextField.RIGHT); lblWidth.setBounds(106, 156, 50, 14); 
		textWidth.setBounds(163, 149, 225, 30); textWidth.setHorizontalAlignment(JTextField.RIGHT);
		lblSquare2.setBounds(166, 279, 54, 14); lblRectangle2.setBounds(385, 277, 83, 19);
		lblArea.setBounds(19, 311, 36, 14); textArea.setBounds(84, 303, 225, 30);
		textArea.setHorizontalAlignment(JTextField.RIGHT); textArea2.setBounds(318, 303, 225, 30);
		textArea2.setHorizontalAlignment(JTextField.RIGHT); lblPerimeter.setBounds(8, 353, 78, 14); 
		textPerimeter.setBounds(84, 346, 225, 28); textPerimeter.setHorizontalAlignment(JTextField.RIGHT);
		textPerimeter2.setBounds(318, 346, 225, 28); textPerimeter2.setHorizontalAlignment(JTextField.RIGHT);
		lblErrorSide1.setBounds(163, 72, 225, 14); lblErrorLength.setBounds(163, 131, 225, 14);
		lblErrorWidth.setBounds(163, 183, 225, 14); radioArea.setBounds(33, 194, 63, 23);
		radioPerimeter.setBounds(30, 233, 101, 23); buttonReset.setBounds(133, 399, 108, 23); 
		buttonClose.setBounds(303, 399, 108, 23);
	}
	
	//Fonts
	public void font(Container cont) {
		lblHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSquare.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRectangle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSide1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textSide1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLength.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWidth.setFont(new Font("Times New Roman", Font.PLAIN, 15));cont.add(lblWidth);
		textWidth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSquare2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRectangle2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPerimeter.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textPerimeter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPerimeter2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblErrorSide1.setForeground(Color.LIGHT_GRAY);
		lblErrorLength.setForeground(Color.LIGHT_GRAY);
		lblErrorWidth.setForeground(Color.LIGHT_GRAY);
		radioArea.setBackground(Color.LIGHT_GRAY);
		radioArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radioPerimeter.setBackground(Color.LIGHT_GRAY);
		radioPerimeter.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonClose.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}
	
	//Get Content
	public void getContent(Container cont) {
		cont.add(lblRectangle); cont.add(lblHeader); cont.add(lblSquare);
		cont.add(lblSide1); cont.add(textSide1); cont.add(lblLength);
		cont.add(textLength); cont.add(lblWidth); cont.add(textWidth);
		cont.add(lblSquare2); cont.add(lblRectangle2); cont.add(lblArea);
		cont.add(textArea); cont.add(textArea2); cont.add(lblPerimeter);
		cont.add(textPerimeter); cont.add(textPerimeter2); cont.add(lblErrorSide1);
		cont.add(lblErrorLength); cont.add(lblErrorWidth); cont.add(radioArea);
		cont.add(radioPerimeter); cont.add(buttonReset); cont.add(buttonClose);
		groupRadio.add(radioArea); groupRadio.add(radioPerimeter);
	}
	
	//Set Text Fields 
	public void setTextField() {
		textSide1.setEditable(true); textLength.setEditable(true);
		textWidth.setEditable(true); textArea.setEditable(false);
		textArea2.setEditable(false); textPerimeter.setEditable(false);
		textPerimeter2.setEditable(false);
	}
	
	//Window
	public void window(Container cont) {
		setResizable(false);
		setVisible(true); 
		setSize(576,472);
		setLocationRelativeTo(null);
		cont.setBackground(Color.LIGHT_GRAY);
	}
	
	//Check if the Input is Valid
	private boolean inputValidation(Float input, String nameLabel) {
		try {
			input = Float.parseFloat(nameLabel);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	//Display Error Messages if Invalid
	public boolean ifValid() {
		boolean validation1 = inputValidation(side1, textSide1.getText());
		boolean validation2 = inputValidation(length, textLength.getText());
		boolean validation3 = inputValidation(width, textWidth.getText());
		
		if(validation1 == false) {
			lblErrorSide1.setForeground(Color.RED); groupRadio.clearSelection();
			textSide1.setText(""); textSide1.requestFocus();
		}
		else
			lblErrorSide1.setForeground(Color.LIGHT_GRAY);
		if(validation2 == false) {
			lblErrorLength.setForeground(Color.RED); groupRadio.clearSelection();
			textLength.setText(""); textLength.requestFocus();
		}
		else
			lblErrorLength.setForeground(Color.LIGHT_GRAY);
		if(validation3 == false) {
			lblErrorWidth.setForeground(Color.RED); groupRadio.clearSelection();
			textWidth.setText(""); textWidth.requestFocus();
		}
		else
			lblErrorWidth.setForeground(Color.LIGHT_GRAY);
		
		return validation1 && validation2 && validation3;
	}
	
	//Compute Area and Perimeter of Square and Rectangle
	public void compute() {
		side1 = Float.parseFloat(textSide1.getText());
		length = Float.parseFloat(textLength.getText());
		width = Float.parseFloat(textWidth.getText());
		
		//Formula of Area
		areaSquare = side1 * side1;
		areaRectangle = length * width;
		
		//Formula of Perimeter
		perimeterSquare = 4 * side1;
		perimeterRectangle = (2 * length) + (2 * width);
		
		deactivateTextField();
	}
	
	//Display Area in 2 Decimal Places, Round Off
	public void displayArea() {
		textArea.setText(String.format("%.2f", areaSquare)); 
		textArea2.setText(String.format("%.2f", areaRectangle));
		textPerimeter.setText(""); textPerimeter2.setText("");
	}
	
	//Display Perimeter in 2 Decimal Places, Round Off
	public void displayPerimeter() {
		textPerimeter.setText(String.format("%.2f", perimeterSquare));
		textPerimeter2.setText(String.format("%.2f", perimeterRectangle));
		textArea.setText(""); textArea2.setText("");
	}
	
	//Clear Text Fields
	public void clear() {
		textSide1.setText("");
		textLength.setText("");
		textWidth.setText("");
		textArea.setText("");
		textArea2.setText("");
		textPerimeter.setText("");
		textPerimeter2.setText("");
		textSide1.requestFocus();
	}
	
	//Clear Error Messages
	public void clearErrorMessages() {
		lblErrorSide1.setForeground(Color.LIGHT_GRAY);
		lblErrorLength.setForeground(Color.LIGHT_GRAY);
		lblErrorWidth.setForeground(Color.LIGHT_GRAY);
	}
	
	//Deactivate Text Field for Input
	public void deactivateTextField() {
		textSide1.setEditable(false);
		textLength.setEditable(false);
		textWidth.setEditable(false);
	}
	
	//Activate Text Field for Input
	public void activateTextField() {
		textSide1.setEditable(true);
		textLength.setEditable(true);
		textWidth.setEditable(true);
	}
	
	//Driver Class
	public static void main(String[] args) {
		Polygon polygon = new Polygon("Polygon");
		polygon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == radioArea) {
			if(ifValid()) {
				compute();
				displayArea();
			}
		}
		else {
			if(ifValid()) {
				compute();
				displayPerimeter();
			}
		}	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonReset) {
			groupRadio.clearSelection();
			clear();
			clearErrorMessages();
			activateTextField();
		}
		else
			System.exit(0);
	}
}