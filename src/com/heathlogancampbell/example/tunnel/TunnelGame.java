package com.heathlogancampbell.example.tunnel;

import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class TunnelGame extends Game
{
	public int tick = 0;
	public double time = 0;
	
	@Override
	public void tick(InputListener inputListener)
	{	
		time += 0.01;
	}
}
