package my.tdl.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import my.project.gop.main.GameWindow;
import my.tdl.MoveableObjects.Player;
import my.tdl.gameLoop.GameLoop;

public class Main {
	//static SpriteSheet blocks = new SpriteSheet();
	
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static int width = gd.getDisplayMode().getWidth();
	public static int height = gd.getDisplayMode().getHeight();
	
	public static void main(String[] args) {
		GameWindow frame = new GameWindow("TheDlooter", 1280, 720);
		frame.setFullscreen(1);
		frame.addKeyListener(new Player());
		frame.add(new GameLoop(width,height));
		frame.setVisible(true);
		//blocks.getTile(0,0,8,8);
	}

}
