package it.unitn.prog2.lacchin.picco_luglio2019;

import javafx.scene.shape.Circle;

abstract public class Palla extends Circle {

    static final double RADIUS = 20.0;
    static final double SPOSTAMENTO = 10.0;
    static int iterazione = 0; //attributo di tutte le palle che va ad aumentare all'aumentare degli spostamenti di User!
    double x, y;
    double radius;
    public Palla () {
        super();
        this.setRadius(RADIUS);
        //dobbiamo translate il suo X e Y.
        x  = (Math.random() * Escape.WIDTH);
        y = (Math.random() * Escape.WIDTH);
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.radius = RADIUS;

    }
    public void move (double dx, double dy) {
        dx = dx * Palla.SPOSTAMENTO;
        dy = dy * Palla.SPOSTAMENTO;
        this.x = this.x + dx;
        this.y = this.y + dy;
        this.setTranslateX(this.x);
        this.setTranslateY(this.y);
    }

    public boolean fuoriBordo () {


        if (this.x > Layout.LATO || this.x < 0.0 || this.y < 0.0 || this.y > Layout.LATO) {
            System.out.println("Fuori dai bordi!");
            return true;
        }
        return false; //questo non serve per la costruzione del layout perché all'inizio sicuramente saranno all'interno!
    }

    public void pacMan () {
        if (this.x < 0) {
            this.x = Layout.LATO;
        }
        else if (this.x > Layout.LATO) {
            this.x = 0.0;
        }
        else if ()


        this.setTranslateX(this.x);
    }


}
