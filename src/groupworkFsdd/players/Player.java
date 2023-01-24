package groupworkFsdd.players;

import groupworkFsdd.aliens.*;
import groupworkFsdd.aliens.groups.SpeciesCurrency;

import java.util.ArrayList;

/**
 * 
 * @author Group 7 FSDD
 *
 */
public class Player {

	private String name;
	private String race;
	private int x;
	private int y;
	private int resources;
	private boolean set;


	private ArrayList <Alien> units;

	public Player(String name, String race, int x, int y) {
		this.name = name;
		this.resources = 50;
		this.race = race;
		this.set = false;

		this.units = new ArrayList<>();
		this.x = x;
		this.y = y;
		this.addUnitStart(x, y);

	}

	/**
	 *
	 * @param race to set race
	 */
	public void setRace(String race) {
		this.race = !this.set ? race : this.race ;
		this.units = new ArrayList<>();
		this.addUnitStart(this.x, this.y);
		this.set = true;
	}

	/**
	 *
	 * @return this.units
	 */
	public ArrayList<Alien> getUnits() {
		return units;
	}

	/**
	 *
	 * @param units, units to set
	 */
	public void setUnits(ArrayList<Alien> units) {
		this.units = units;
	}

	/**
	 *
	 * @param alien, to add to alien units
	 */
	public void addUnit(int x, int y) {
		switch (this.race) {
			case "mingog":
				this.units.add(new Mingog(this, x,y ));
				this.reduceResources(SpeciesCurrency.MINGOG_CURRENCY);
				break;
			case "evu":
				this.units.add(new Evu(this, x,y));
				this.reduceResources(SpeciesCurrency.EVU_CURRENCY);
				break;
			case "trul":
				this.units.add(new Trul(this, x,y));
				this.reduceResources(SpeciesCurrency.TRUL_CURRENCY);
				break;
			case "sirith":
				this.units.add(new Sirith(this, x,y));
				this.reduceResources(SpeciesCurrency.SIRITH_CURRENCY);
				break;
			case "lunzar":
				this.units.add(new Lunzar(this, x,y));
				this.reduceResources(SpeciesCurrency.LUNZAR_CURRENCY);
				break;
		}

	}

	/**
	 *
	 * @param alien, to add to alien units
	 */
	public void addUnitStart(int x, int y) {
		switch (this.race) {
			case "mingog":
				this.units.add(new Mingog(this, x,y ));

				break;
			case "evu":
				this.units.add(new Evu(this, x,y));

				break;
			case "trul":
				this.units.add(new Trul(this, x,y));

				break;
			case "sirith":
				this.units.add(new Sirith(this, x,y));

				break;
			case "lunzar":
				this.units.add(new Lunzar(this, x,y));
				break;
		}

	}

	/**
	 * @return the resources
	 */
	public int getResources() {
		return resources;
	}


	/**
	 * reduce resources while buying new characters
	 */
	public void reduceResources() {
		this.resources --;
	}
	/**
	 * @param i, defines how much resources should be depleted
	 */
	public void reduceResources(int i) {
		this.resources -= i;
	}

	/**
	 * @param newResources the resources to set
	 */
	public void addResources(int newResources) {
		this.resources += newResources;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void specialAttack(ArrayList<Alien> arr) {
		this.reduceResources(10);

		if (this.race.equals("sirith")) {
			System.out.println("Sirith special Air Attack");
			for (Alien alien : arr) {

				alien.attacked(10* 0.4 * 0.6);

			}
		}

		else if (this.race.equals("mingog")) {
			this.addResources(10);
			System.out.println("Mingog has no special attack, Sorry!");
		}

		else if  (this.race.equals("evu")) {
			for (Alien alien : arr) {
				System.out.println("Evu, toxin bomb enemy");
				alien.attacked(20* 0.3 * 0.7);

			}
		}

		else if (this.race.equals("trul")) {
			this.units.forEach(unit -> {

				System.out.println("Trul Special Mode, units will be better shielded");
				unit.setShieldIntegrity(unit.getShieldIntegrity() + 0.05);

			});
		}

		else if (this.race.equals("lunzar")) {
			System.out.println("Lunzar, special move activate, all units will be healed");
			this.units.forEach(unit -> {

				unit.setLife(unit.getLife() + 10);

			});
		}


	}

	public void upgrade () {
		this.resources -= 10;

		for (Alien alien : this.getUnits()) {

			alien.addAccuracy(0.05);
			alien.addStrength(5.0);

		}
		System.out.println("All units upgraded into better units");

	}

	@Override
	public String toString() {
		return "Player is " +
				"name: '" + name + '\'' +
				", race: '" + race + '\'' ;
	}

	// Actions

}
