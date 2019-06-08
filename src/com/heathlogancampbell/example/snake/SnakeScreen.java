package com.heathlogancampbell.example.snake;

import com.heathlogancampbell.example.snake.score.ScoreNumber;
import com.heathlogancampbell.example.snake.utils.Location;
import com.heathlogancampbell.miniengine.graphics.Screen;

public class SnakeScreen extends Screen<SnakeGame> 
{

	public SnakeScreen(int width, int height) 
	{
		super(width, height);
	}

	public void render(SnakeGame game)
	{
		this.clearScreen();
		
		int x = this.width / 2;
		int y = this.height / 2;
		
		int score = game.level.getScore();
		if(score < 10)
		{
			// 8 / 2 = 4
			this.draw(ScoreNumber.NUMBERS[score].bitmap, x - 4, y - 7);
		}
		else if(score < 100)
		{
			// (8 + 9) / 2
			this.draw(ScoreNumber.NUMBERS[score / 10].bitmap, x - 8, y - 7);
			this.draw(ScoreNumber.NUMBERS[score % 10].bitmap, x + 9 - 8, y - 7);
		}
		else if(score < 1000)
		{
			// (8 + 9 + 9) / 2
//			this.draw(ScoreNumber.NUMBERS[score % 100 ].bitmap, x - 16, y - 7);
//			this.draw(ScoreNumber.NUMBERS[score % 100 / 10].bitmap, x - 16, y - 7);
//			this.draw(ScoreNumber.NUMBERS[score % 10].bitmap, x + 9  + 9 - 16, y - 7);
		}
		
		game.level.getEntities().forEach(entity -> {
			Location loc = entity.getLocation();
			this.setPixel(loc.getX(), loc.getY(), entity.getColor());
		});
	}
}
