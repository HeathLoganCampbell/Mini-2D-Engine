package com.heathlogancampbell.example.snake.level;

import java.util.ArrayList;
import java.util.Random;

import com.heathlogancampbell.example.snake.player.Egg;
import com.heathlogancampbell.example.snake.player.Entity;
import com.heathlogancampbell.example.snake.player.Snake;
import com.heathlogancampbell.example.snake.utils.Location;
import com.heathlogancampbell.miniengine.inputs.InputListener;
import com.heathlogancampbell.miniengine.utils.Tickable;

public class Level implements Tickable
{

	public static final int MAX_EGGS_ON_SCREEN = 2;
	
	//Entities to render
	private ArrayList<Entity> entities;
	private ArrayList<Entity> spawning;
	
	private int width;
	private int height;
	
	private int score = 0;
	
	private Random random;
	private Snake snake;
	
	private int eggsOnScreen = 0;
	
	public Level(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.random = new Random();
		this.entities = new ArrayList<>();
		this.spawning = new ArrayList<>();
		
	}
	
	public void spawn(Entity entity)
	{	
		this.spawning.add(entity);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public void eatEgg(Egg egg)
	{
		this.getSnake().growTail();
		egg.setDestroy(true);
		this.eggsOnScreen--;
		this.setScore(this.getScore() + 1);
	}
	
	public void spawnEgg()
	{
		int x = this.random.nextInt(this.width - 10) + 5;
		int y = this.random.nextInt(this.height - 10) + 5;
		this.spawn(new Egg(this, new Location(x, y)));
		this.eggsOnScreen++;
	}
	
	@Override
	public void tick(InputListener inputListener) 
	{
//		if(System.currentTimeMillis() % 2000 < 10)
		this.entities.removeIf(entity -> entity.isDestroy());
		this.spawning.forEach(entity -> this.entities.add(entity));
		this.spawning.clear();
		
		this.entities.stream().filter(entity -> entity instanceof Tickable)
							  .forEach(entity -> ((Tickable) entity).tick(inputListener));
		if(this.eggsOnScreen < MAX_EGGS_ON_SCREEN)
			spawnEgg();
		
		if(this.snake == null || this.snake.isDestroy())
		{
			int x = this.getWidth() / 2;
			int y = this.height / 2;
			this.snake = new Snake(this, new Location(x, y));
			this.spawn(this.snake);
			setScore(0);
		}
	}

	public Snake getSnake() {
		return snake;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
