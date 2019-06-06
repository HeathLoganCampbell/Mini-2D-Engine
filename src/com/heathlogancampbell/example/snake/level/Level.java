package com.heathlogancampbell.example.snake.level;

import java.util.ArrayList;

import com.heathlogancampbell.example.snake.player.Entity;
import com.heathlogancampbell.miniengine.inputs.InputListener;
import com.heathlogancampbell.miniengine.utils.Tickable;

public class Level implements Tickable
{
	//Entities to render
	private ArrayList<Entity> entities;
	
	private int width;
	private int height;
	
	public Level(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.entities = new ArrayList<>();
	}
	
	public void spawn(Entity entity)
	{
		this.entities.add(entity);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	@Override
	public void tick(InputListener inputListener) 
	{
		this.entities.stream().filter(entity -> entity instanceof Tickable)
							  .forEach(entity -> ((Tickable) entity).tick(inputListener));
	}

	
}
