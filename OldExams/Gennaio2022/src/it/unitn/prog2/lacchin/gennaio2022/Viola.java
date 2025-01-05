package it.unitn.prog2.lacchin.gennaio2022;

import javafx.scene.paint.Color;

public class Viola extends Casella{

    final static int n = 3;
    public Viola () {
        super();
        this.rec.setFill(Color.VIOLET);
        switch ((int)(Math.random() * n)) {
            case 0:
                this.valore.setText("0");
                this.val = 0;
                break;
            case 1:
                this.valore.setText("1");
                this.val = 1;
                break;
            case 2:
                this.valore.setText("2");
                this.val = 2;
                break;
            case 3:
                this.valore.setText("3");
                this.val = 3;
                break;
            default:
                System.out.println("E' stato inserito un valore non valido");
                break;

        }
        this.getChildren().addAll(this.rec,this.valore);
    }
}
