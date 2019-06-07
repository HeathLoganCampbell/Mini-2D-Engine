package com.heathlogancampbell.example.xor;

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
		Engine<XORGame> engine = new Engine<XORGame>(120, 120, 5);
		engine.setScreen(new XORScreen(engine.getScreenWidth(), engine.getScreenHeight()));
		engine.setGame(new XORGame());
		engine.setTitle("XOR Pattern Example");
		engine.start();
	}

}
