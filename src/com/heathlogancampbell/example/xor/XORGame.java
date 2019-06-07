package com.heathlogancampbell.example.xor;

import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class XORGame extends Game
{
	public double time = 0;
	
	@Override
	public void tick(InputListener inputListener)
	{	
		time+= 0.5;
	}
}
