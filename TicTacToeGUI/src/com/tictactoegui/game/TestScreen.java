package com.tictactoegui.game;

import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestScreen extends Canvas implements Runnable {
    
	private static final long serialVersionUID = 2023040761382580965L;
	private static JFrame frame;
	public boolean running = false;
	public TestScreen() {
    	
		
		frame = new JFrame("Test");
    	frame.setVisible(true);
    	frame.setSize(400, 400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	frame.setLayout(new BorderLayout());
    	frame.add(this,BorderLayout.CENTER); //putting the canvas on the middle of the frame
    	frame.pack(); //keeps everything sized correctly
    	
    	//a text field
    	//two buttons
    	//an image
    	JTextField title = new JTextField("Tic-Tac-Toe");
    	title.setEditable(false);
    	title.setVisible(true);
    	frame.add(title);
    	
    	
    	
    	
    }
	public synchronized void stop() {
		
		running=false;
	}
	public synchronized void start() {
		running = true;
		new Thread(this).start();
		
	}
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int frames = 0;
		int ticks = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta +=(now-lastTime) / nsPerTick;
			lastTime = now;
			while(delta>=1) {
				ticks++;
				tick();
				delta-=1;
			}
			frames++;
			render();
			
			System.out.println(frames + ", " + ticks);
		}
	}
	public void tick() {
		
	}
	public void render() {
		
	}
	public static void main(String[] args) {
		new TestScreen().start();
		
	}
	

}
