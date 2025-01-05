package it.unitn.prog2.lacchin.figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Objects;
import java.util.Random;

public class Figura {

    Shape figura = null;

    public Figura () {
        Random num = new Random();
        int index = num.nextInt(2);
        switch (index) {
            case 0:
                this.figura = new Rectangle(50,50);
                break;
            case 1:
                this.figura = new Circle(25);
                break;
            default:
                break;
        }
        index = num.nextInt(3);
        switch (index) {
            case 0:
                this.figura.setFill(Color.RED);
                break;
            case 1:
                this.figura.setFill(Color.YELLOW);
                break;
            case 2:
                this.figura.setFill(Color.BLUE);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figura figura1 = (Figura) o;
        if (figura1.figura.getClass().equals(this.figura.getClass()) &&
                figura1.figura.getFill().equals(this.figura.getFill())) {
            return true;
        }
        else {
            //System.out.println (""+ figura1.figura.getClass() + ""+ this.figura.getClass());
            return false;
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(figura);
    }
}
