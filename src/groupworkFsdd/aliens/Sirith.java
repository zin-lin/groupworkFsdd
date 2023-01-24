package groupworkFsdd.aliens;

import groupworkFsdd.players.Player;



/**
 * 
 * @author Group 7 FSDD
 * Sirith - subclass for Alien Unit
 */
public class Sirith extends Alien {
	

	 /**
	  * Constructor
	  * @param p, is to set the player to the unit
	  */


	public Sirith (Player p) {

		this.setLife(100);
		this.setStrength(30);
		this.setAccuracy(0.4);
		this.setShieldIntegrity(1-this.getAccuracy());
		this.setSpeed(45);
		this.setPlayer(p);
		this.setRange(50);
		this.setX(0);
		this.setY(0);
	}

	/**
	 * Constructor
	 * @param p to set player
	 * @param x to set X direction unit breeding point
	 * @param y to set Y direction unit breeding point
	 */

	public Sirith (Player p, int x, int y) {

		this.setLife(100);
		this.setStrength(30);
		this.setAccuracy(0.4);
		this.setShieldIntegrity(1-this.getAccuracy());
		this.setSpeed(45);
		this.setPlayer(p);
		this.setRange(50);
		this.setX(x);
		this.setY(y);
	}


	/**
	 * Constructor 
	 * @param alien, this is a constructor to instance this from an alien 
	 */
	public Sirith (Alien alien) {

		this.setLife(alien.getLife());
		this.setStrength(alien.getStrength());
		this.setAccuracy(alien.getAccuracy());
		this.setPlayer(alien.getPlayer());
		this.setRange(40);
		this.setX(alien.getX());
		this.setY(alien.getY());
	}
	
}
