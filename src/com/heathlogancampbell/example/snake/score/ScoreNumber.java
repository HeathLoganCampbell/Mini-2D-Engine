package com.heathlogancampbell.example.snake.score;

import com.heathlogancampbell.miniengine.graphics.Bitmap;

public class ScoreNumber 
{
	public int number;
	public Bitmap bitmap;
	
	public ScoreNumber(int number, Bitmap bitmap)
	{
		this.number = number;
		this.bitmap = bitmap;
	}
	
	public static ScoreNumber[] NUMBERS = new ScoreNumber[11];
	
	
	static
	{
		int[][][] miniNumbers =
			{
					{
						//0
						{0, 1, 1, 0},
						{1, 0, 0, 1},
						{1, 0, 1, 1},
						{1, 1, 0, 1},
						{1, 0, 0, 1},
						{1, 0, 0, 1},
						{0, 1, 1, 0},
					},
					{
						//1
						{0, 1, 0, 0},
						{1, 1, 0, 0},
						{0, 1, 0, 0},
						{0, 1, 0, 0},
						{0, 1, 0, 0},
						{0, 1, 0, 0},
						{1, 1, 1, 0},
					},
					{
						//2
						{0, 1, 1, 0},
						{1, 0, 0, 1},
						{0, 0, 0, 1},
						{0, 0, 1, 0},
						{0, 1, 0, 0},
						{1, 0, 0, 0},
						{1, 1, 1, 1},
					},
					{
						//3
						{0, 1, 1, 0},
						{1, 0, 0, 1},
						{0, 0, 0, 1},
						{0, 1, 1, 0},
						{0, 0, 0, 1},
						{1, 0, 0, 1},
						{0, 1, 1, 0},
					},
					{
						//4
						{0, 0, 1, 1},
						{0, 1, 0, 1},
						{1, 0, 0, 1},
						{1, 1, 1, 1},
						{0, 0, 0, 1},
						{0, 0, 0, 1},
						{0, 0, 0, 1},
					},
					{
						//5
						{1, 1, 1, 1},
						{1, 0, 0, 0},
						{1, 1, 1, 0},
						{0, 0, 0, 1},
						{0, 0, 0, 1},
						{0, 0, 0, 1},
						{1, 1, 1, 0},
					},
					{
						//6
						{0, 0, 1, 0},
						{0, 1, 0, 0},
						{1, 0, 0, 0},
						{1, 1, 1, 0},
						{1, 0, 0, 1},
						{1, 0, 0, 1},
						{0, 1, 1, 0},
					},
					{
						//7
						{1, 1, 1, 1},
						{0, 0, 0, 1},
						{0, 0, 0, 1},
						{0, 0, 1, 0},
						{0, 1, 0, 0},
						{0, 1, 0, 0},
						{0, 1, 0, 0},
					},
					{
						//8
						{0, 1, 1, 0},
						{1, 0, 0, 1},
						{1, 0, 0, 1},
						{0, 1, 1, 0},
						{1, 0, 0, 1},
						{1, 0, 0, 1},
						{0, 1, 1, 0},
					},
					{
						//9
						{0, 1, 1, 0},
						{1, 0, 0, 1},
						{1, 0, 0, 1},
						{0, 1, 1, 1},
						{0, 0, 0, 1},
						{0, 0, 1, 0},
						{0, 1, 0, 0},
					},
					
					{
						//BLAKN
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0},
					}
			};
		
		for(int i = 0; i < miniNumbers.length; i++)
		{
			int[][] numberBitmap = miniNumbers[i];
			Bitmap bitmap = new Bitmap(8, 14);
			
			
			for(int y = 0; y < numberBitmap.length * 2; y++)
				for(int x = 0; x < numberBitmap[(int) (y / 2)].length * 2; x++)
				{
					if(numberBitmap[(int) (y / 2)][(int) (x / 2)] == 1)
					{
						bitmap.setPixel(x, y, 0x333333);
					}
				}
			ScoreNumber scoreNum = new ScoreNumber(i, bitmap);
			NUMBERS[i] = scoreNum;
					
		}
	}
}
