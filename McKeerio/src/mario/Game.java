package mario;


import graphics.Sprite;
import graphics.SpriteSheet;
import input.KeyboardInput;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;

import sun.audio.*;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JFrame;

import entity.Entity;
import entity.Player;
//import entity.Trumpser;


public class Game extends Canvas implements Runnable{
	
	
	
	
	private static final long serialVersionUID = 5977555617223559694L;
	public static final int WIDTH = 270;
	public static final int HEIGHT = (WIDTH/14) * 10;
	public static final int SCALE = 4;
	static final String TITLE = "McKeerio";
	private Thread thread;
	private boolean running = false;
	public static Handler handler;
	
	public static SpriteSheet playersheet;
	public static SpriteSheet trumpsheet;
	
	public static Sprite ground;
	
	
	public static Sprite player[] = new Sprite[8];
	public static Sprite playerJumpLeft;
	public static Sprite playerJumpRight;
	
//	public static Sprite trumpser[] = new Sprite[6];
//	public static Sprite trumpJump;
	

	
	public static Camera cam;
	

	public Game(){
		Dimension size  = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
	}
	
	

	
	private void init(){
		handler = new Handler();
		System.out.println("Handler Created...");
		
		playersheet = new SpriteSheet("/res/MarioSpriteSheet.png");
	//	trumpsheet = new SpriteSheet("/res/TrumpserSpriteSheet.gif");
		System.out.println("Spritesheet Imported...");
		
		ground = new Sprite(playersheet, 1, 3);
		
		
		

		for(int i = 0; i < player.length; i++){
			player[i] = new Sprite(playersheet, i+1, 1);
		}
		
	/*	for(int i = 0; i < trumpser.length; i++){
			trumpser[i] = new Sprite(trumpsheet, i+1, 1);
		}
		*/
		
		playerJumpLeft = new Sprite(playersheet, 1, 2);
		playerJumpRight = new Sprite(playersheet, 2, 2);
     //   trumpJump = new Sprite(trumpsheet,1,1);
		cam = new Camera();
		
		addKeyListener(new KeyboardInput());
		System.out.println("Keyboard Listener Created...");
		handler.addEntity(new Player(400, 400, 32, 32, true, Id.player, handler));
 //		handler.addEntity(new Trumpser(700, 512, 100 ,100, true, Id.trump, handler));
		System.out.println("Player Created...");
	}
	

	private synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this, "Game Loop");
		thread.start();
	}
	

	private synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unused")
	public void run(){
		init();
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		double ns = 1000000000/60;
		int frames = 0;
		int ticks = 0;
		while(running){
			long current = System.nanoTime();
			delta+=(current - lastTime) / ns;
			lastTime = current;
			while(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer > 1000){
				timer+=1000;
				System.out.println(frames +"FPS and "+ticks+" Updates per Sec");
				frames=0;
				ticks=0;
			}
		}
		stop();
	}
	
	/**
	 * Displays graphics
	 */
	public void render(){
		BufferStrategy buffStrategy = getBufferStrategy();
		if(buffStrategy == null){
			createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = buffStrategy.getDrawGraphics();
		super.paint(g);
		g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
		g.translate(cam.getX(), cam.getY());
		handler.render(g);
		g.dispose();
		buffStrategy.show();
	}

	public void tick(){
		handler.tick();
		for(Entity e : handler.entity){
			if(e.getId() == Id.player && e.getX()>550){
				cam.tick(e);
			}
		}
	}
	

	public int getFrameWidth(){
		return WIDTH*SCALE;
	}
	

	public int getFrameHeight(){
		return HEIGHT*SCALE;
	}
	
	
	public static void setupFrame(JFrame frame, Game game){
		frame.add(game);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	public static void main(String[] args){
		Game game = new Game();
		JFrame frame = new JFrame(TITLE);
		setupFrame(frame, game);
		game.start();
	}
	
	
	
}
