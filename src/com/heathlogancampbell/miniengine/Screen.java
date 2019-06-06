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
		long now = System.currentTimeMillis();
		int x = (int) (Math.sin((now % 2000) / 2000.0 * Math.PI * 2 ) * 40);
		int y = (int) (Math.cos((now % 2000) / 2000.0 * Math.PI * 2) * 60);
		this.draw(this.testBitmap, x + (this.width  - this.testBitmap.width) / 2 , y+ (this.height  - this.testBitmap.height) / 2);
	}

}
