package groupworkFsdd.aliens;

import groupworkFsdd.players.Player;



/**
 * 
 * @author Group 7 FSDD
 *  Trul - subclass for Alien Unit
 */
public class Trul extends Alien {

	
	 /**
	  * Constructor
	  * @param p, is to set the player to the unit
	  */

	public Trul (Player p) {

		this.setLife(70);
		this.setStrength(90);
		this.setAccuracy(1);
		this.setPlayer(p);
		this.setRange(40);
		this.setSpeed(25);
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

	public Trul (Player p, int x, int y) {

		this.setLife(70);
		this.setStrength(90);
		this.setAccuracy(1);
		this.setPlayer(p);
		this.setRange(40);
		this.setSpeed(25);
		this.setShieldIntegrity(1-this.getAccuracy());
		this.setX(x);
		this.setY(y);
	}


	/**
	 * Constructor 
	 * @param alien, this is a constructor to instance this from an alien 
	 */
	public Trul (Alien alien) {

		this.setLife(alien.getLife());
		this.setStrength(alien.getStrength());
		this.setAccuracy(alien.getAccuracy());
		this.setPlayer(alien.getPlayer());
		this.setRange(40);
		this.setX(alien.getX());
		this.setY(alien.getY());
	}
	
}
