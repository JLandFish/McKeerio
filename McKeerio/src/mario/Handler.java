package mario;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import entity.Entity;
import tile.Tile;
import tile.Wall;

public class Handler {
	
	/**
	 * List of all entities
	 */
	public LinkedList<Entity> entity = new LinkedList<Entity>();
	
	/**
	 * List of all tiles
	 */
	public LinkedList<Tile> tile = new LinkedList<Tile>();

	/**
	 * Renders both tiles and entities in Graphics g
	 * @param g The Graphics Object being used
	 */
	public Handler(){
		createLevel();
	}
	
	/** 
	 * Draws the entities and tiles for the game
	 * @param g
	 */
	public void render(Graphics g){	
		//Loops through Linked List of entites and calls each render
		for(Entity entities : entity){
			entities.render(g);
		}
		
		//Loops through Linked List of tiles and calls each render
		for(Tile tiles : tile){
			tiles.render(g);
		}
	
	}
	
	/**
	 * Ticks through both Tiles and entities
	 */
	public void tick(){
		
		for(Entity entities : entity){
			entities.tick();
		}
		
		//Loops through Linked List of tiles and calls each tick
		for(Tile tiles : tile){
			tiles.tick();
		}
	}

	/**
	 * adds an entity to the linked list of entities
	 * @param newEntity The entity to be added
	 */
	public void addEntity(Entity newEntity){
		entity.add(newEntity); 
	}
	
	/**
	 * removes an entity from the linked list of entities
	 * @param targetEntity the entity to be removed
	 */
	public void removeEntity(Entity targetEntity){
		entity.remove(targetEntity);
	}
	
	/**
	 * Adds a new tile to the linked list of tiles
	 * @param newTile
	 */
	public void addTile(Tile newTile){
		tile.add(newTile);
	}
	
	/**
	 * Removes a tile from the linked list of tiles
	 * @param targetTile The tile to be removed
	 */ 
	public void removeTile(Tile targetTile){
		tile.remove(targetTile);
	}
	public void createSingleWall(int loop, boolean[]ledge, int location){
		if(loop < ledge.length && ledge[loop]){
			addTile(new Wall((location)*64,630, 64, 64, true, Id.wall,this));
			addTile(new Wall((+location)*64,570, 64, 64, true, Id.wall,this));
			addTile(new Wall((+location)*64,510, 64, 64, true, Id.wall,this));
			addTile(new Wall((+location)*64,450, 64, 64, true, Id.wall,this));
		}
	}
	public void createMedWall(int loop, boolean[] ledge, int location){
		if(loop < ledge.length && ledge[loop]){
			addTile(new Wall((loop+location)*64,630, 64, 64, true, Id.wall,this));
			addTile(new Wall((loop+location)*64,570, 64, 64, true, Id.wall,this));
			addTile(new Wall((loop+location)*64,510, 64, 64, true, Id.wall,this));
			addTile(new Wall((loop+location)*64,450, 64, 64, true, Id.wall,this));
		}
	}
	public void createPlatforms(int loop, boolean[] plat){
		if(loop < plat.length && plat[loop]){
			 addTile(new Wall(loop*64, 400, 64, 64, true, Id.wall, this));
		 }
		if(loop < plat.length && plat[loop]){
			addTile(new Wall((loop+4)*64, 200, 64, 64, true, Id.wall, this));
		 }
	}
	public void createBounds(int loop){
		addTile(new Wall(loop*64, Game.HEIGHT*Game.SCALE-64, 64, 64, true, Id.wall, this));
		addTile(new Wall(loop*64, 0, 64, 64, true, Id.wall, this));
	
			
	}
	/**
	 * Creates the new level (Just some floors)
	 */
	public void createLevel(){
		boolean[] plat = {
				false, false,false ,false ,false, 
				false, false,false ,false ,false,
				false, false,false ,false ,false,
				true, true, true, true, 
				false, false,false ,false ,false, 
				true, true, true, true, 
				false, false,false ,false ,false,
				true, true, true, true, 
				false, false,false ,false ,false,
				false, false,false ,false ,false, 
				true, true, true, true, 
				false, false,false ,false ,false,
				true, true, true, true, 
				false, false,false ,false ,false,
				true, true, true, true, 
				false, false,false ,false ,false, 
				true, true, true, true, 
				false, false,false ,false ,false,
				true, true, true, true, 
				false, false,false ,false ,false};
	     boolean[] ledge ={false,true,true,true,
	    		           false,false};
	
		
		for(int i = 0; i <= Game.WIDTH * Game.SCALE /128 * 10; i++){
			 createBounds(i);
			 createPlatforms(i, plat);
			 createMedWall(i, ledge, 4);
			 createMedWall(i, ledge, 10);
			 createSingleWall(i, ledge, 20);
			 createSingleWall(i, ledge, 30);
			 createSingleWall(i, ledge, 40);
		}
	}
	
}
