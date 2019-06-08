package com.heathlogancampbell.miniengine.utils;

import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.graphics.Screen;

public interface Renderable<G extends Game, S extends Screen<G>>
{
	public void render(S screen, G game);
}
