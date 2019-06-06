package com.heathlogancampbell.miniengine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Engine extends Canvas implements Runnable
{
	private static final int WIDTH = 160
						   , HEIGHT = 120
						   , SCALE = 4;
	
	private boolean running;
	private Thread thread;
	
	private Screen screen;
	private Game game;
	
	private BufferedImage image;
	private int[] pixels;
	
	public Engine()
	{
		Dimension dimesion = new Dimension(WIDTH * SCALE,HEIGHT * SCALE );
		this.setPreferredSize(dimesion);
		this.setMaximumSize(dimesion);
		this.setMinimumSize(dimesion);
		
		this.screen = new Screen(WIDTH, HEIGHT);
		this.game = new Game();
		
		this.image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.pixels = ((DataBufferInt) this.image.getRaster().getDataBuffer()).getData();
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
	
	public void tick() {
		game.tick();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		this.screen.render(this.game);

		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(this.image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g.dispose();
		bs.show();
		
	}
	
	@Override
	public void run() 
	{
		int frames = 0;

		double unprocessedSeconds = 0;
		long lastTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;

		requestFocus();

		while (running) {
			long now = System.nanoTime();
			long passedTime = now - lastTime;
			lastTime = now;
			if (passedTime < 0) passedTime = 0;
			if (passedTime > 100000000) passedTime = 100000000;

			unprocessedSeconds += passedTime / 1000000000.0;

			boolean ticked = false;
			while (unprocessedSeconds > secondsPerTick) {
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;

				tickCount++;
				if (tickCount % 60 == 0) {
					System.out.println(frames + " fps");
					lastTime += 1000;
					frames = 0;
				}
			}

			if (ticked) {
				render();
				frames++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

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
		
		engine.start();
	}
}
