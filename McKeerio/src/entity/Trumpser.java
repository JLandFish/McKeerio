package entity;

import java.awt.Graphics;
import java.util.LinkedList;

import tile.Tile;
import mario.Game;
import mario.Handler;
import mario.Id;

/*public class Trumpser extends Entity {
    

	private int frame = 0;
	private int frameDelay = 0;
	private boolean isWalking = false;
	
	
	public Trumpser(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}
	public void moveTrump(){
		
	}
	public void checkCollision(){
		
		for(Tile t : handler.tile){
			if(!t.isSolid())
				continue;
			if(t.getId() == Id.wall){
				if(getBoundsTop().intersects(t.getBounds())){
					setVelY(0);
						if(jumping){
						jumping = false;
						gravity = 0.8; 
						falling = true;
					}
				}
				
				else if(!falling && !jumping){
					gravity = 0.8;
					falling = true;
				}
			
				if(getBoundsBottom ().intersects(t.getBounds())){
					setVelY(0);
					if(falling)
						falling = false;
				}
				
				if(getBoundsLeft ().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX() + t.width;
				}
				if(getBoundsRight ().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX() - t.width;
				}
			}				
		}
	}
	

	@Override
	public void render(Graphics g) {
		if(facing == 0){
			if(jumping){
				g.drawImage(Game.trumpJump.getBufferedImage(), x , y, width, height, null);
			}
			else if(isWalking){
				g.drawImage(Game.trumpser[frame].getBufferedImage(), x , y, width, height, null);
			}
			else{
				g.drawImage(Game.trumpser[3].getBufferedImage(), x , y, width, height, null);
			}
			
		}
		else if(facing == 1){
			if(jumping){
				g.drawImage(Game.trumpJump.getBufferedImage(), x , y, width, height, null);
			}
			else if(isWalking){
				g.drawImage(Game.trumpser[frame+5].getBufferedImage(), x , y, width, height, null);
			}
			else{
				g.drawImage(Game.trumpser[4].getBufferedImage(), x , y, width, height, null);
			}
			
		}
		
	}

	public void checkYBounds(){
		if(y+height>=771)
			y = 771-height;
		if(x<=0)
			x=0;
	}
	public void checkJumping(){
		//Controls deceleration going up.
		if(jumping){
			gravity-=0.11;
			setVelY((int)-gravity);
			//You reached the top of your jump
			if(gravity <= 0){
				jumping = false;
				falling = true;
			}
		}
	}

	public void animateWalking(){
		frameDelay++;
		if(isWalking){
			if(frameDelay>=4){
				frame++;
				if(frame>=3){
					frame = 0;
				}
				frameDelay = 0;
			}
		}
	}
	public void checkWalking(){
		if(velX!=0){
			isWalking = true;
		}else{
			isWalking = false;
		}
	}
	public void checkFalling(){
		//Controls acceleration going down
		if(falling){
			gravity+=0.11;
			setVelY((int)gravity);
		}
	}
	
	@Override
	public void tick() {
		moveTrump();
		
		checkYBounds();	
		
		checkWalking();
		
		checkCollision();
		
		checkJumping();
		
		checkFalling();
		
		animateWalking();
		
	}

}
*/
