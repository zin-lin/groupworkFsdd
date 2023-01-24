package groupworkFsdd.items;


/**
 * 
 * @author Group 7 FSDD
 *
 */

import groupworkFsdd.players.Player;

public class Resource {

	private Player player;
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	protected String type;
	
	public Resource (int x, int y) {
		this.x = x;
		this.y = y;
		//Nth
	}
	
	public Player getPlayer () {
		return player;
	}
	
	public void setPlayer (Player player) {
		this.player = player ;
	}

	public String getType () {
		return type;
	}

	@Override
	public String toString() {
		return "x: " + this.x + " y: " + this.y;
	}
	
}
