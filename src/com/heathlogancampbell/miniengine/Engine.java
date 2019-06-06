package com.heathlogancampbell.miniengine;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Engine extends Canvas implements Runnable
{
	private static final int WIDTH = 160
						   , HEIGHT = 120
						   , SCALE = 4;
	
	private boolean running;
	private Thread thread;
	
	
	public Engine()
	{
		Dimension dimesion = new Dimension(WIDTH * SCALE,HEIGHT * SCALE );
		this.setPreferredSize(dimesion);
		this.setMaximumSize(dimesion);
		this.setMinimumSize(dimesion);
	}
	
	public synchronized void start()
	{
		if(running) return;
		this.running = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running) return;
		this.running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {}
	public void render() {}
	
	@Override
	public void run() 
	{
		while(running)
		{
			tick();
			render();
		}
	}

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Engine");
		Engine engine = new Engine();
		frame.add(engine);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
