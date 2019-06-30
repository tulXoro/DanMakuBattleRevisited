package game;

import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends EnemyB{

	private Player p;
	public BasicEnemy(int x, int y, int damage, int eneHP, Player p, Game game) {
		super(x, y, damage, eneHP, game);
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		sprite = ss.grabImage(2, 1, 32, 32);
		this.p = p;//adds player to set tracking
	}

	public void tick() {
		velX=5;
		velY=5;
		
		//super complex AI which tracks the player and changes the enemy's velocity to move towards player
		if(p.getX()>x+5) x+=velX;
		else if(p.getX()<x-5) x-=velX;
		
		if(p.getY()>y+5) y+=velY;
		else if(p.getY()<y-5) y-=velY;
	}

	public void render(Graphics g) {		
		//Graphics2D g2d = (Graphics2D) g;
		
		g.drawImage(sprite, x, y, 45, 45,null);
		
		//g2d.draw(getHitBox());
	}

	public Rectangle getHitBox() {
		return new Rectangle (x+4, y+2, 34, 37);
	}
	
}
