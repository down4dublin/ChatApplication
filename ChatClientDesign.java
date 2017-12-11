package com.ElectricAmbitions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatClientDesign extends JFrame {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton sendButton;
	int buttonClicked;
	JTextField textField1;
	JTextArea messageArea;

	public static void main(String[] args){
		
		new ChatClientDesign();
	}


public ChatClientDesign() {
	this.setSize(400,400);
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	
	Dimension dim = tk.getScreenSize();
	
	int xpos = (dim.width /2) - (this.getWidth()/2);
	int ypos = (dim.height /2  - this.getHeight()/2);
	
	this.setLocation(xpos, ypos);
	this.setResizable(false);
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("My Little Bachelor Chat App");

	//Panel surround the components
	JPanel thePanel = new JPanel();
	JLabel textLabel = new JLabel("Text color");
	JLabel iconLabel = new JLabel("Icons");
	textLabel.setToolTipText("Pick new text color");
	
	thePanel.add(textLabel);	
	
	JButton sendButton = new JButton("Send");
	ListenForButton sendListen = new ListenForButton();
	
	sendButton.addActionListener(sendListen);
	
	thePanel.add(sendButton);
	
	JRadioButton jrb = new JRadioButton();
	//jrb.setText("Online");
	jrb.setText("Offline");
	
	thePanel.add(jrb);
	
	textField1 = new JTextField("", 55);
	
	ListenForKeys lForKeys = new ListenForKeys();
	textField1.addKeyListener(lForKeys);
	textField1.setColumns(10);
	textField1.setText("Enter Message");
	
	thePanel.add(textField1);
	
	messageArea = new JTextArea(20,20);
	messageArea.setText("Welcome to the Chat Session!");
	messageArea.setLineWrap(true);
	messageArea.setWrapStyleWord(true);
	
	thePanel.add(messageArea);
	
	JScrollPane scrollBar = new JScrollPane(messageArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	thePanel.add(scrollBar);
	
	this.add(thePanel);
	
	this.setVisible(true);
	textField1.requestFocus();
	messageArea.requestFocus();
	}

private class ListenForButton implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sendButton) {
			buttonClicked++;
			messageArea.append("button clicked: "+ buttonClicked + " times");
			
		}
	}

}


private class ListenForKeys implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		messageArea.append("Key hit: " + e + ".");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		messageArea.append("Key released: " + e + ".");
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		messageArea.append("Key typed: " + e + ".");
		
		
	}

}


}



