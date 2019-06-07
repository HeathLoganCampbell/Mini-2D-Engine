package com.heathlogancampbell.example.tunnel;

import com.heathlogancampbell.miniengine.graphics.Screen;

public class TunnelScreen extends Screen<TunnelGame>
{
	private int textureWidth = 256;
	private int textureHeight = 256;
	private int[][] texture = new int[textureHeight][textureWidth];
	private int[][] distanceTable;
	private int[][] angleTable;

	public TunnelScreen(int width, int height) 
	{
		super(width, height);
		
		for(int y = 0; y < textureHeight; y++)
			for(int x = 0; x < textureWidth; x++)
				texture[y][x] = (x * 256 / textureWidth) ^ (y * 256 / textureHeight);
		
		this.distanceTable = new int[this.height * 2][this.width * 2];
		this.angleTable = new int[this.height * 2][this.width * 2];
		
		float ratio = 32.0f;
		
		for(int y = 0; y < this.height * 2; y++)
		{
			for(int x = 0; x < this.width * 2; x++)
			{
				int distance = (int) (ratio * textureHeight / Math.sqrt((x - this.width) * (x - this.width ) + (y - this.height ) * (y - this.height ))) % textureHeight;
				int angle = (int)(0.5 * textureHeight * Math.atan2(y - this.height, x - this.width) / Math.PI);
				distanceTable[y][x] = distance;
			    angleTable[y][x] = angle;
			}
		}
	}
	
	@Override
	public void render(TunnelGame game)
	{
		this.clearScreen();
		
		
		int shiftX = (int) (textureWidth * 1.0 * (game.time));
		int shiftY = (int) (textureHeight * 0.25 * (3 + game.time));
		
		int lookX = this.width / 2 + ((int) (this.height / 2 * Math.sin(game.time )));
		int lookY = this.height / 2 + ((int) (this.height / 2 * Math.sin(game.time * 2)));

		for(int y = 0; y < this.height; y++)
			for(int x = 0; x < this.width; x++)
			{
				long textX = (long)(distanceTable[y + lookY][x + lookX] + shiftX)  % textureWidth;
				long textY = (long)(angleTable[y + lookY][x + lookX] + shiftY) % textureHeight;
				if(textX < 0 || textY < 0) continue;
			    int color = texture[(int) textX][(int) textY];
			    this.setPixel(x,  y, color);
			}
	}

}
