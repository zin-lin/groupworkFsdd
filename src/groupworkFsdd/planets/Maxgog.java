package groupworkFsdd.planets;

import groupworkFsdd.planets.groups.PlanetTypes;

public class Maxgog extends Planet{

   public Maxgog () {

       this.effected = false;
       this.type = PlanetTypes.MAXGOG;
       this.setTemperatureEffect(0.9);


       this.setNumBronze(23);
       this.setNumCurrency(20);
       this.setNumGold(10);
       this.setNumSilver(6);
       this.setNumShield(22);
       this.setNumHealth(20);

   }

}
