package groupworkFsdd.planets;

import groupworkFsdd.planets.groups.PlanetTypes;

public class Podorth extends Planet {

    public Podorth () {
        this.effected = false;
        this.type = PlanetTypes.PODORTH;
        this.setTemperatureEffect(1.2);


        this.setNumBronze(33);
        this.setNumCurrency(30);
        this.setNumGold(20);
        this.setNumSilver(16);
        this.setNumShield(32);
        this.setNumHealth(30);

    }

}
