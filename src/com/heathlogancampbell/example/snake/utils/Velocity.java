package com.heathlogancampbell.example.snake.utils;

public class Velocity {
	private double x, y;

	public Velocity(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void increaseX(double amount)
	{
		this.x += amount;
	}
	
	public void increaseY(double amount)
	{
		this.y += amount;
	}
}
