package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mario.Game;
import entity.Entity;

public class KeyboardInput implements KeyListener{
	public static final int  UP = KeyEvent.VK_UP;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int  LEFT = KeyEvent.VK_LEFT;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final double GRAVITY = 9;

	
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		for(Entity en : Game.handler.entity){
			switch(key){
			case UP:
				
				if(!en.jumping){
					en.jumping = true;
					en.gravity=GRAVITY;
				}
				break;
		
			case RIGHT:
				en.setVelX(5);
				en.facing = 1;
				break;
			case LEFT:
				en.setVelX(-5);
				en.facing = 0;
				break;
			}
		}
		

			
	}

	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
			switch(key){
			case UP:
				en.setVelY(0);
				break;
			case RIGHT:
				en.setVelX(0);
				break;
			case LEFT:
				en.setVelX(0);
				break;
			}
		}
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
