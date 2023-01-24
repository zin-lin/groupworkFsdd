package groupworkFsdd.aliens;

import groupworkFsdd.players.Player;


/**
 * 
 * @author Group 7 FSDD
 * Lunzar - subclass for Alien Unit
 */
public class Lunzar extends Alien {
	

	 /**
	  * Constructor
	  * @param p, is to set the player to the unit
	  */


	public Lunzar (Player p) {
		
		this.setStrength(40);
		this.setLife(45);
		this.setAccuracy(0.6);
		this.setPlayer(p);
		this.setShieldIntegrity(1-this.getAccuracy());
		this.setSpeed(55);
		this.setRange(85);
		this.setX(0);
		this.setY(0);
	}
	
	/**
	 * Constructor
	 * @param p to set player
	 * @param x to set X direction unit breeding point
	 * @param y to set Y direction unit breeding point
	 */

	public Lunzar (Player p, int x, int y) {

		this.setStrength(40);
		this.setLife(45);
		this.setAccuracy(0.6);
		this.setPlayer(p);
		this.setShieldIntegrity(1-this.getAccuracy());
		this.setSpeed(55);
		this.setRange(85);
		this.setX(x);
		this.setY(y);
	}
	

	/**
	 * Constructor 
	 * @param alien, this is a constructor to instance this from an alien 
	 */

	public Lunzar (Alien alien) {

		this.setLife(alien.getLife());
		this.setStrength(alien.getStrength());
		this.setAccuracy(alien.getAccuracy());
		this.setPlayer(alien.getPlayer());
		this.setRange(40);
		this.setX(alien.getX());
		this.setY(alien.getY());
	}
	
	
}
