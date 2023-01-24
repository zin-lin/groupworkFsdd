package groupworkFsdd.planets;

import java.util.ArrayList;

import groupworkFsdd.aliens.Alien;
import groupworkFsdd.planets.groups.PlanetTypes;
import groupworkFsdd.players.Player;


/**
 * 
 * @author Group 7 FSDD
 *
 */
public class Planet {

	private double temperatureEffect;
    protected PlanetTypes type;
    protected boolean effected;
    private int numGold;
    private int numSilver;
    private int numBronze;
	private int numCurrency;
	private int numHealth;
	private int numShield;

	public int getNumGold() {
		return numGold;
	}

	public void setNumGold(int numGold) {
		this.numGold = numGold;
	}

	public int getNumSilver() {
		return numSilver;
	}

	public void setNumSilver(int numSilver) {
		this.numSilver = numSilver;
	}

	public int getNumBronze() {
		return numBronze;
	}

	public void setNumBronze(int numBronze) {
		this.numBronze = numBronze;
	}

	public int getNumCurrency() {
		return numCurrency;
	}

	public void setNumCurrency(int numCurrency) {
		this.numCurrency = numCurrency;
	}

	public int getNumHealth() {
		return numHealth;
	}

	public void setNumHealth(int numHealth) {
		this.numHealth = numHealth;
	}

	public int getNumShield() {
		return numShield;
	}

	public void setNumShield(int numShield) {
		this.numShield = numShield;
	}

	/**
	 *
	 * @return temperature Effects
	 */
	public double getTemperatureEffect() {
		return temperatureEffect;
	}

	/**
	 *
	 * @param temperatureEffect, to set the effect of temperature
	 */
	public void setTemperatureEffect(double temperatureEffect) {
		this.temperatureEffect = temperatureEffect;
	}

	public void planetTerrainEffects(ArrayList<Alien>arr1 , ArrayList<Alien>arr2) {

		if (this.type == PlanetTypes.HALIV) {
			for (Alien alien : arr1) {
				alien.setLife(alien.getLife()-1);
			}
			for (Alien alien : arr2) {
				alien.setLife(alien.getLife()-1);
			}
		}
		else if (this.type == PlanetTypes.PODORTH) {
		  if (!this.effected)	{
				for (Alien alien : arr1) {
					alien.setLife(alien.getLife() - 1);
				}
				for (Alien alien : arr2) {
					alien.setLife(alien.getLife() - 1);
				}
			  this.effected = !this.effected;
			}
		}
		else if (this.type == PlanetTypes.MAXGOG) {
			for (Alien alien : arr1) {
				alien.setLife(alien.getLife()+1);
			}
			for (Alien alien : arr2) {
				alien.setLife(alien.getLife()+1);
			}
		}

	}

}
