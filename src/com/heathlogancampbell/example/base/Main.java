package com.heathlogancampbell.example.base;

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
		Engine<ExampleGame> engine = new Engine<ExampleGame>(120, 120, 5);
		engine.setScreen(new ExampleScreen(engine.getScreenWidth(), engine.getScreenHeight()));
		engine.setGame(new ExampleGame());
		engine.setTitle("Base Example");
		engine.start();
	}

}
