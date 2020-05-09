package com.tictactoegui.game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstScreen extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1657636569513398722L;
	private static final int HEIGHT=500, WIDTH=500;  
	public Screen first;
	
    
    public FirstScreen(JLabel title) {
    	 first = new Screen(HEIGHT,WIDTH);
    	 first.window.add(title);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public void addComponent(Component a) {
		this.first.window.add(a);
	}
	public void changeBackgroundColor(Color color) {
		this.first.window.setBackground(color);
	}
	
	public static void main(String[] args) {
		JLabel title = new JLabel();
		//editing the text
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(JLabel.TOP);
		title.setText("Tic-Tac-Toe");
		title.setFont(new Font("Arial",50,40));
		//editing the image
		ImageIcon image = new ImageIcon("C:\\Users\\User\\Desktop\\tictactoe.jpg");
		Image scaled = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		image = new ImageIcon(scaled);
		
        FirstScreen front = new FirstScreen(title);
		//title and image
		JPanel panel = (JPanel) front.first.window.getContentPane();
		title.setIcon(image);
		title.setVerticalAlignment(JLabel.TOP);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setIconTextGap(30);
		//buttons
		JLabel buttons = new JLabel(); //going to add a new JLabel to the panel just for the buttons
		JButton start = new JButton("Start");
		start.setVisible(true);
		
		
		//adding the JLabel to the panel
		panel.add(title);
		
		
	    
	}
}
