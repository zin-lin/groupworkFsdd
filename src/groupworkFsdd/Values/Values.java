package groupworkFsdd.Values;

import groupworkFsdd.aliens.*;

public interface Values {

    public static final int MINGOG = 10;
    public static final int EVU = 12;
    public static final int TRUL = 20;
    public static final int SIRITH = 20;
    public static final int LUNZAR = 12;

    public static String nameReturner (String race){

     switch (race)
            {
                case "1":
                    race = "mingog";
                    break;
                case "2":
                    race = "evu";
                    break;
                case "3":
                    race = "trul";
                    break;
                case "4":
                    race = "sirith";
                    break;
                case "5":
                    race = "lunzar";
                    break;
                default :
                	race = "mingog";
                
            }

            return race;
    }

    public static int valueReturner(String type) {


        if (type == "mingog") {
            return MINGOG;
        } else if (type == "evu") {
            return EVU;
        } else if (type == "trul") {
            return TRUL;
        } else if (type == "sirith") {
            return SIRITH;
        } else if (type == "lunzar") {
            return LUNZAR;
        }
        else {
            return 0;
        }


    }


}
