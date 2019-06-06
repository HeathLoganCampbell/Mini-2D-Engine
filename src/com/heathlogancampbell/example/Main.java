package com.heathlogancampbell.example;

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
		Engine<ExampleGame> engine = new Engine<ExampleGame>(120, 120, 5);
		engine.setScreen(new ExampleScreen(120, 120));
		engine.setGame(new ExampleGame());
		engine.start();
	}

}
