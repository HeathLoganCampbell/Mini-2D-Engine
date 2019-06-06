package com.heathlogancampbell.example;

import java.awt.event.KeyEvent;

import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class ExampleGame extends Game
{
	public int x = 0;
	public int y = 0;
	
	@Override
	public void tick(InputListener inputListener)
	{	
		
		if(inputListener.isPressed(KeyEvent.VK_D))
		{
			x += 1;
		}
		
		if(inputListener.isPressed(KeyEvent.VK_A))
		{
			x -= 1;
		}
		
		if(inputListener.isPressed(KeyEvent.VK_W))
		{
			y -= 1;
		}
		
		if(inputListener.isPressed(KeyEvent.VK_S))
		{
			y += 1;
		}
	}
}
