package it.unitn.prog2.lacchin.febbraio2022;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class Componente extends StackPane {


    double traslazioneX;
    double traslazioneY;
    Text text = null;
    Shape figura = null;
    double posizione;
    Figura fig = null;

    public Componente () {
        super();

    }
    public void doComponenteRed () {
        this.traslazioneX = (Math.random() * 500);
        this.traslazioneY = (Math.random() * 500);
        this.setTranslateX(this.traslazioneX);
        this.setTranslateY(this.traslazioneY);
        posizione = traslazioneX + traslazioneX;
        fig = new Rossa();
        figura = fig.getFigura();
        text = new Text(fig.getLettera());
        this.getChildren().addAll(figura,text);
    }

    public void doComponenteBlu () {
        this.traslazioneX = (Math.random() * 500);
        this.traslazioneY = (Math.random() * 500);
        this.setTranslateX(this.traslazioneX);
        this.setTranslateY(this.traslazioneY);
        posizione = traslazioneX + traslazioneX;
        fig = new Blu();
        figura = fig.getFigura();
        this.getChildren().addAll(figura);

    }





    public double getTraslazioneX() {
        return traslazioneX;
    }

    public double getTraslazioneY() {
        return traslazioneY;
    }

    public boolean fuoriDaiBordi () {
        boolean fuori = false;

        if ((((Pannello.WIDTH)-this.traslazioneX)<0.0) || (((Pannello.HEIGHT)-this.traslazioneY)<0.0) ||
                (this.traslazioneX < 0.0) || (this.traslazioneY < 0.0)){
            fuori = true;
                        /*System.out.println(t.traslazioneX);
                        System.out.println(t.traslazioneY);

                         */

        }
        return fuori;
    }

    public Figura getFig() {
        return fig;
    }
}
