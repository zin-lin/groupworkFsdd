package groupworkFsdd.aliens;

import groupworkFsdd.items.Resource;
import groupworkFsdd.players.Player;

import java.util.ArrayList;


/**
 * 
 * @author Group 7 FSDD
 * Alien class - for each units
 */
public class Alien {

	
	private double accuracy;
	private double shield;
	private int range;
	private int speed;
	private double strength;
	private double shieldIntegrity;
	private Player player;
	private int x;
	private int y;

	/**
	 * constructors 
	 */
	public Alien () {
		
	// Nth here
	this.shield = 10;	
	}

	public static void print(Object obj){
		System.out.println(obj);
	}
	/**
	 * 
	 * @param life to set shield
	 */
	public void setLife (double life) {
		this.shield = life;
	}
	
	public double getLife () {
		return this.shield;
	}

	/**
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 *
	 * @param speed, to set speed
	 */

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the distance between two Aliens (x-axis)
	 */
	public int distanceX (Alien alien) {
		int a = 0;
		a = Math.abs(this.getX() - alien.getX());
		return a;
	}

	/**
	 * @return the distance between two Aliens (y-axis)
	 */
	public int distanceY (Alien alien) {
		int a = 0;
		a = Math.abs(this.getY() - alien.getY());
		return a;
	}

	/**
	 *
	 * @return x
	 */

	public int getX() {
		return x;
	}
	/**
	 *
	 * @param x set x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 *
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 *
	 * @param y set y
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * @return the life of alien
	 */


	/**
	 * being attacked by another alien  
	 */
	public void attacked () {
		this.shield -= 20; 
		//taking out aliens' life 
	}
	
	/**
	 * being attacked by another alien  
	 */
	public void attack (Alien a, double effect) {
		//Override normal Attack Method Special to Mingog Race of Aliens
		a.attacked(this.getStrength()* this.getAccuracy() * (1.0- a.getShieldIntegrity()) * effect);

	}
	
	public void attacked (double damage) {
		this.shield -= damage;
		// Specific damage method.
	}


	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return the strength
	 */
	public double getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(double strength) {
		this.strength = strength;
	}


	/**
	 * @param shield the shield to set
	 */
	public void setShieldIntegrity(double shield) {
		this.shieldIntegrity = shield;
	}


	/**
	 * @return the shieldIntegrity
	 */
	public double getShieldIntegrity() {
		return this.shieldIntegrity;
	}

	/**
	 * @return the accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	
	/**
	 * @param accuracy the accuracy to set
	 */
	public void addAccuracy(double accuracy) {
		this.accuracy += accuracy;
	}
	
	/**
	 * @param strength the accuracy to set
	 */
	public void addStrength(double strength) {
		this.strength += strength;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	//<Section> Actions
	/**
	 * 
	 * @param res, how many more is collected
	 */
	public void collect (Resource res) {
			res.setPlayer(this.getPlayer());
			switch (res.getType()) {
				case "gold":
					this.player.addResources(10);
					break;
				case "silver":
					this.player.addResources(4);
					break;
				case "bronze":
					this.player.addResources(3);
					break;
				case "currency":
					this.player.addResources(1);
					break;
				case "health":
					this.shield += 20;
					break;
				case "shield":
					this.shieldIntegrity += 0.1;
					break;
				default:
					; //Do Nth
					break;
			}

			print("health: " + this.shield + " resources: " + this.player.getResources());

			
	}

	/**
	 *
	 * @param res, how many more is collected
	 */
	public void collectItem (Resource res) {
		res.setPlayer(this.getPlayer());
		this.player.addResources(1);

	}

	/**
	 *
	 * @param x for movement in x direction
	 * @param y for movement in y direction
	 */

	public void move (int x, int y) {
		//This method here will use our speed to determine how far a character should be able to go;
		this.x += Math.abs(x) > (this.speed) ? x - this.speed: x;
		this.y += Math.abs(y) > (this.speed) ? y - this.speed: y;

        print("Unit is at x: "+ this.x + " y: "+ this.y + "\n");

		this.x = this.x > 500 ?  500: this.x;
		this.y = this.y > 500 ?  500: this.y;


		this.x = this.x < 0 ? 0: this.x;
		this.y = this.y < 0 ? 0: this.y;

	}

	/**
	 * Move without vectors will use default speed/5
	 */
	public void move () {
		//This method here will use our speed to determine how far a character should be able to go;

			this.x += this.speed ;
			this.y += this.speed ;
			this.x = this.x > 500 ? this.x - 500 : this.x;
			this.y = this.y > 500 ? this.y - 500 : this.y;

	}

	/**
	 *
	 * @param arr is a list of enemies
	 * @return a list of indexes from the enemies arraylist that are in range for our unit
	 */

	public ArrayList<Integer> findFoes (ArrayList<Alien> arr) {

		ArrayList <Integer> arrayList = new ArrayList<>();
        for (int i = 0; i< arr.size(); i++) {
        	Alien a = arr.get(i);
           double x = Math.abs(this.x- a.getX());
           double y = Math.abs(this.y- a.getY());

           print("Enemy Unit " + i + " at " + a.toString());

           if (x <= this.range && y <= this.range ) {


           	 arrayList.add(i);
		   }


		}
		if (arrayList.size() == 0) {
			print("Sorry no Enemy units within your range");
		}
		else {

			for (int index : arrayList) {

				Alien alien = arr.get(index);
				print(this.player.getRace() + " " + index + " is in your range " + alien.toString());

			}
		}
		return arrayList ;
	}

	public ArrayList<Integer> findResources (ArrayList<Resource> arr) {

		ArrayList <Integer> arrayList = new ArrayList<>();
		for (int i = 0; i< arr.size(); i++) {
			Resource resource = arr.get(i);
			double x = Math.abs(this.x- resource.getX());
			double y = Math.abs(this.y- resource.getY());

			print(resource.getType() + " at x: " + resource.getX() + " y: " + resource.getY());

			if (x <= this.range && y <= this.range) {
				arrayList.add(i);
			}

		}
		if (arrayList.size() == 0) {
			print("Sorry no Resources within your range");
		}

		else{
			for (int index : arrayList) {

				Resource resource = arr.get(index);
				print(resource.getType() +" " + index + " is in your range " + resource.toString());

			}
		}
		return arrayList ;
	}

	@Override
	public String toString() {
		return "x: " + this.x + " y: " + this.y + " and life at: "+ this.shield;
	}

	//Actions
	
	
}
