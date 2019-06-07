package com.heathlogancampbell.example.tunnel;

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
		Engine<TunnelGame> engine = new Engine<TunnelGame>(640, 480, 2);
		engine.setScreen(new TunnelScreen(engine.getScreenWidth(), engine.getScreenHeight()));
		engine.setGame(new TunnelGame());
		engine.setTitle("Tunnel Pattern Example");
		engine.start();
	}

}
