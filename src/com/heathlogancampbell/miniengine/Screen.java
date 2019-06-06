package com.heathlogancampbell.miniengine;

import java.util.Random;

public class Screen extends Bitmap
{
	private Bitmap testBitmap;

	public Screen(int width, int height) {
		super(width, height);
		
		Random ran = new Random();
		testBitmap = new Bitmap(32, 32);
		for(int i = 0; i < this.testBitmap.width * this.testBitmap.height; i++)
		{
			this.testBitmap.pixels[i] = ran.nextInt();
		}
	}
	
	public void render(Game game)
	{
//		int x = (int) (Math.sin(System.currentTimeMillis()) * 100);
//		int y = (int) (Math.cos(System.currentTimeMillis()) * 100);
		this.draw(this.testBitmap, (this.width  - this.testBitmap.width) / 2 , (this.height  - this.testBitmap.height) / 2);
	}

}
