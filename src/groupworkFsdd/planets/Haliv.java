package groupworkFsdd.planets;

import groupworkFsdd.planets.groups.PlanetTypes;

public class Haliv extends Planet {

      public Haliv () {
          this.effected = false;
          this.type = PlanetTypes.HALIV;
          this.setTemperatureEffect(0.7);

          this.setNumBronze(20);
          this.setNumCurrency(30);
          this.setNumGold(10);
          this.setNumSilver(26);
          this.setNumShield(22);
          this.setNumHealth(20);

      }

}
