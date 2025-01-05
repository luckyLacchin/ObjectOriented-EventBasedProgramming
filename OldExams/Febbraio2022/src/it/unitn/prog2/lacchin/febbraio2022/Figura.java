package it.unitn.prog2.lacchin.febbraio2022;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Figura {

    final static double WIDTH = 20;
    final static double HEIGHT = 20;
    final static String [] LETTERE = {"A","B","C"};
    static final Color[] COLORI = {Color.BLUE,Color.RED};
    final static double BORDO = 20;
    String lettera = null;
    Shape figura = null;
    //per il colore deve pensarci il panello perché deve vedere che siano 3 rosse e 3 blu
    Figura () {
        doFigure();
    }


    public void doFigure () {
        switch ((int)(Math.random()*3)) {
            case 0:
                figura = new Circle(WIDTH);
                break;
            case 1:
                figura = new Rectangle(WIDTH*2,HEIGHT*2);
                break;
            case 2:
                figura = new Polygon();
                ((Polygon)figura).getPoints().addAll (
                        /*20.0,10.0,
                        0.0,10.0,
                        5.0,0.0,
                        15.0,0.0,
                        5.0,20.0,
                        15.0,20.0
                         */
                        10.0,0.0,
                        0.0,20.0,
                        10.0,40.0,
                        30.0,40.0,
                        40.0,20.0,
                        30.0,0.0

                );
                break;
            default:
                System.out.println("E' stato inserito un valore non valido.");

        }
    }

    public Shape getFigura() {
        return figura;
    }

    public String getLettera() {
        return lettera;
    }
}
