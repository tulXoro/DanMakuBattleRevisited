package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class TrackerEnemy extends EnemyB{

	private Player p;
	public TrackerEnemy(int x, int y, int damage, int eneHP, Player p, Game game) {
		super(x, y, damage, eneHP, game);
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		sprite = ss.grabImage(2, 1, 32, 32);
		this.p = p;//adds player to set tracking
		
	}

	public void tick() {
		velX=5;
		velY=5;
		
		//super complex AI which tracks the player and changes the enemy's velocity to move towards player
		/*
		if(p.getX()>x+5) x+=velX;
		else if(p.getX()<x-5) x-=velX;
		
		if(p.getY()>y+5) y+=velY;
		else if(p.getY()<y-5) y-=velY;
		*/
		
		predictPlayer(p.getX(), p.getY(), p.getVelX(), p.getVelY());
		
		
		
		
	}

	public void render(Graphics g) {
		g.drawImage(sprite, x, y, 45, 45,null);
		
	}

	public Rectangle getHitBox() {
		return new Rectangle (x+4, y+2, 34, 37);
	}
	
	public void predictPlayer(int p_x, int p_y, int p_velX, int p_velY) {
		
		if(p_velX>0) p_x+=p_velX*4;
		else if(p_velX<0) p_x-=p_velX*4;
		
		if(p_velY>0) p_y+=velY*4;
		else if(p_velY<0) p_y-=velY*4;
		
		if(p_x>x+5) x+=velX;
		else if(p_x<x-5) x-=velX;
		
		if(p_y>y+5) y+=velY;
		else if(p_y<y-5) y-=velY;
	}

}
