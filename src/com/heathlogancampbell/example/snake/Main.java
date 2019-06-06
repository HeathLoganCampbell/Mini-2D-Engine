package com.heathlogancampbell.example.snake;

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) {
		Engine<SnakeGame> engine = new Engine<SnakeGame>(120, 120, 5);
		engine.setScreen(new SnakeScreen(engine.getScreenWidth(), engine.getScreenHeight()));
		engine.setGame(new SnakeGame());
		engine.start();
	}

}