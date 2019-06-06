package com.heathlogancampbell.miniengine.utils;

import com.heathlogancampbell.miniengine.Game;

public interface Renderable<G extends Game>
{
	public void render(G game);
}
