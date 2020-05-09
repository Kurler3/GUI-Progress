package com.tictactoegui.game;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;

public class Screen {
    private static GraphicsDevice vc;  
    public JFrame window;
    public Screen(int HEIGHT, int WIDTH) {
		window = new JFrame();
		window.setSize(WIDTH, HEIGHT);
		window.setResizable(true);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc=env.getDefaultScreenDevice(); //if I eventually want to make the game fullscreen
		
	}
	//making it fullscreen
	public static void setFullScreen(DisplayMode dm, Window w) {
	    vc.setFullScreenWindow(w);
	    if(w!=null && vc.isDisplayChangeSupported()) {
	    	try {
	    		vc.setDisplayMode(dm);
	    	}catch(Exception e) {}
	    }
	}
	public Window getFullScreen(){
		return vc.getFullScreenWindow();
	}
	public static void restore() {
		java.awt.Window w = vc.getFullScreenWindow();
		if(w!=null) {
			w.dispose();
		}
		
		vc.setFullScreenWindow(null);
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
	
}
