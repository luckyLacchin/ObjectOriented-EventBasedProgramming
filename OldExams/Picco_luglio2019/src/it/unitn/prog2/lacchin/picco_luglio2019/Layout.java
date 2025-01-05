package it.unitn.prog2.lacchin.picco_luglio2019;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;

public class Layout extends Pane {

    static final double LATO = 500;
    public ArrayList<Palla> palle;


    public Layout () {
        super();
        this.setPrefSize(LATO,LATO);
        palle  = new ArrayList<>();
        riempiLayout();
    }

    public void riempiLayout () {
        do {
            this.getChildren().clear();
            palle.clear();
            palle.add(new User());
            palle.add(new Striker());
            palle.add(new Wanderer());
            palle.add(new Bubbler());
            this.getChildren().addAll (palle);
        }while (collisione());

    }

    public boolean collisione () {

        boolean collisione = false;
        double dx, dy;
        ArrayList <Palla> clonePalle = (ArrayList<Palla>) this.palle.clone();
        Iterator<Palla> x = clonePalle.iterator();
        while (x.hasNext() && !collisione) {
            Palla s = x.next();
            for (Palla t : clonePalle) {
                dx = Math.abs(s.x - t.x);
                dy = Math.abs(s.y - t.y);
                if (s != t && (dx*dx + dy*dy < (s.radius + t.radius) * (s.radius + t.radius))) {
                    System.out.println("C'e' collisione");
                    collisione = true;
                }
            }
        }
        return collisione;
    }

    public  void aggiungi () {
        Enemy enemy = null;
        switch ((int) (Math.random() * 3)) {
            case 0:
                enemy = new Striker();
                break;
            case 1:
                enemy = new Wanderer();
                break;
            case 2:
                enemy = new Bubbler();
                break;
            default:
                System.out.println("Qualcosa è andato storto!");

        }
        this.getChildren().add(enemy);
        this.palle.add(enemy);
    }
/*
    public boolean fuoriBordo (Palla p) {

        boolean fuori = false;
        ArrayList <Palla> clonePalle = (ArrayList<Palla>) this.palle.clone();
        Iterator<Palla> x = clonePalle.iterator(); //in realtà fare la copia non servirebbe ma lo faccio per sicurezza!
        while (x.hasNext() && !fuori) {
            Palla p = x.next();
            if (p.x > LATO || p.x < 0.0 || p.y < 0.0 || p.y > LATO) {
                System.out.println("Fuori dai bordi!");
                fuori = true;
            }
        }
        return fuori; //questo non serve per la costruzione del layout perché all'inizio sicuramente saranno all'interno!
    }

 */
}
