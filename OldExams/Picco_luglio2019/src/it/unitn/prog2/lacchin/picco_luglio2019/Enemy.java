package it.unitn.prog2.lacchin.picco_luglio2019;

abstract public class Enemy extends Palla{

    String direzione;
    double deltaX; // forse queste variabili potremmo metterle direttamente in Palla!
    double deltaY;
    public Enemy () {
        super();
        cambiaDirezione(); // in questo modo andiamo a settare la direzione iniziale!
    }

    public void cambiaDirezione () {
        /**
         * allora le direzioni che possono impiegare le enemy sono: 2 orizzontali, 2 verticali e 4 diagonali.
         */

        switch ((int) (Math.random() * 8)) {
            case 0 -> {
                direzione = "nord";
                deltaX = 0;
                deltaY = -1;
            }
            case 1 -> {
                direzione = "sud";
                deltaX = 0;
                deltaY = +1;
            }
            case 2 -> {
                direzione = "est";
                deltaX = 1;
                deltaY = 0;
            }
            case 3 -> {
                direzione = "ovest";
                deltaX = -1;
                deltaY = 0;
            }
            case 4 -> {
                direzione = "nord-est";
                deltaX = 0.70710678;
                deltaY = -0.70710678;
            }
            case 5 -> {
                direzione = "nord-ovest";
                deltaX = -0.70710678;
                deltaY = -0.70710678;
            }
            case 6 -> {
                direzione = "sud-est";
                deltaX = 0.70710678;
                deltaY = 0.70710678;
            }
            case 7 -> {
                direzione = "sud-ovest";
                deltaX = -0.70710678;
                deltaY = 0.70710678;
            }
            default -> System.out.println("Qualcosa è andato storto!");
        }
    }

    abstract public void sposta ();

}
