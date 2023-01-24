package groupworkFsdd.aliens;

import groupworkFsdd.players.Player;

/**
 * 
 * @author Group 7 FSDD
 * Evu - subclass for Alien Unit
 */
public class Evu extends Alien {

	 /**
	  * Constructor
	  * @param p, is to set the player to the unit
	  */

	public Evu (Player p) {
		
		this.setStrength(45);
		this.setAccuracy(0.3);
		this.setLife(80);
		this.setPlayer(p);
		this.setRange(20);
		this.setSpeed(80);
		this.setShieldIntegrity(1-this.getAccuracy());
		this.setX(0);
		this.setY(0);

	}
	
	/**
	 * Constructor
	 * @param p to set player
	 * @param x to set X direction unit breeding point
	 * @param y to set Y direction unit breeding point
	 */

	public Evu (Player p, int x, int y) {

		this.setStrength(45);
		this.setAccuracy(0.3);
		this.setLife(80);
		this.setPlayer(p);
		this.setRange(20);
		this.setSpeed(80);
		this.setShieldIntegrity(1-this.getAccuracy());
		this.setX(x);
		this.setY(y);

	}

	/**
	 * Constructor 
	 * @param alien, this is a constructor to instance this from an alien 
	 */
	public Evu (Alien alien) {

		this.setLife(alien.getLife());
		this.setStrength(alien.getStrength());
		this.setAccuracy(alien.getAccuracy());
		this.setPlayer(alien.getPlayer());
		this.setRange(40);
		this.setX(alien.getX());
		this.setY(alien.getY());
	}
	
	
}
