package com.heathlogancampbell.miniengine.graphics;

import java.util.Random;

import com.heathlogancampbell.miniengine.Game;

public class Screen<G extends Game> extends Bitmap
{
	private Bitmap testBitmap;

	public Screen(int width, int height) {
		super(width, height);		
	}
	
	public void render(G game)
	{
		for(int i = 0; i < this.width * this.height; i++)
			this.pixels[i] = 0;
		for(int i = 0; i < this.area; i++)
		{
			long now = System.currentTimeMillis() + i * 16;
			int x = (int) (Math.sin((now % 2000) / 2000.0 * Math.PI * 2 ) * 40);
			int y = (int) (Math.cos((now % 2000) / 2000.0 * Math.PI * 2) * 40);
			this.setPixel(x + this.width / 2, y + this.height / 2, 0xff00ff);
		}
	}

}
