# Mini-2D-Engine
A mini 2d Pixel based engine in java for experiments 

## Install

### Eclipse
1. Download this repo into the folder/workspace you want with (it'll create a new folder called mini-2D-Engine with all the code)
```
git clone git@github.com:HeathLoganCampbell/Mini-2D-Engine.git
```

2. Open eclipse in the same workspace
3. file -> import -> general -> existing projects into workspace
4. select the "mini-2D-Engine" folder
5. create a new project
  5.a. file -> new -> Java Project
  5.b. Call it whatever you want
  5.c. Click ok/create
6. Right click the newly created project folder -> properties -> java build path -> projects -> add...
7. select mini-2d-engine 
8. Done

## How to use

This engine is a two step process, we have state and view represented in game and screen respectively. 

### Step 1: getting a blank screen up
Quickly create a class called Main, this is the bootstrap class that we will run to start up our program.
```

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
    		// creates a window with the size (120 * 5) x (120 * 5)
    		// The smaller the scale, the small the pixels will be
    		// making a higher resolution
		Engine engine = new Engine<>(120, 120, 5);
    		//starts game loop
		engine.start();
	}
}
```

Now if you run that, we'll get a blank screen

### Step 2: Putting a pixel on the screen
create a new class, this will be the screen class so it must extend screen and have a render function
```
import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.graphics.Screen;

public class ExampleScreen extends Screen<Game>
{

	public ExampleScreen(int width, int height) 
	{
		super(width, height);
	}
	
	@Override
	public void render(ExampleGame game)
	{
		this.clearScreen();
		//will place a pixel in the middle of the screen
    		//with the RGB colour 0x0ff0ff aka https://www.htmlcsscolor.com/hex/0FF0FF
		this.setPixel(this.width / 2, this.height / 2, 0x0ff0ff);
	}

}
```

We also update our starter/bootstrap class
```

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
    		// creates a window with the size (120 * 5) x (120 * 5)
    		// The smaller the scale, the small the pixels will be
    		// making a higher resolution
		Engine engine = new Engine<>(120, 120, 5);
   		//Adds screen of size of engine
    		engine.setScreen(new ExampleScreen(engine.getScreenWidth(), engine.getScreenHeight()));
    		//starts game loop
		engine.start();
	}
}
```

### Step 3: Adding State
create a new class that extends game
```
import java.awt.event.KeyEvent;

import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class ExampleGame extends Game
{
	public int x = 0;
	public int y = 0;
	
	@Override
	public void tick(InputListener inputListener)
	{	
		//When D is pressed we go right...
		if(inputListener.isPressed(KeyEvent.VK_D))
		{
			x += 1;
		}
		
		//When A is pressed we go left...
		if(inputListener.isPressed(KeyEvent.VK_A))
		{
			x -= 1;
		}
		
		//When W is pressed we go Up... (up and down have to be revised)
		if(inputListener.isPressed(KeyEvent.VK_W))
		{
			y -= 1;
		}
		
		//When S is pressed we go Down... (up and down have to be revised)
		if(inputListener.isPressed(KeyEvent.VK_S))
		{
			y += 1;
		}
	}
}
```

go back to the screen class and update it
```
import com.heathlogancampbell.miniengine.graphics.Screen;

//We add <ExampleGame> 
public class ExampleScreen extends Screen<ExampleGame>
{

	public ExampleScreen(int width, int height) 
	{
		super(width, height);
	}
	
	@Override
	public void render(ExampleGame game) //We change Game to ExampleGame 
	{
		this.clearScreen();
		//We can now use variables in the ExampleGame class :)
		this.setPixel(game.x, game.y, 0x0ff0ff);
	}

}

```

Finally we update the bootstrap/starter/main class
```
import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
		Engine<ExampleGame> engine = new Engine<ExampleGame>(120, 120, 5);
		engine.setScreen(new ExampleScreen(engine.getScreenWidth(), engine.getScreenHeight()));
		engine.setGame(new ExampleGame());
		engine.start();
	}

}
```

### Step 4: Done

## Demo Projects
* none yet
