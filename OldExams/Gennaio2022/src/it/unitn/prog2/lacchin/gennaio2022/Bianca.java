package it.unitn.prog2.lacchin.gennaio2022;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javax.swing.plaf.basic.BasicTreeUI;

public class Bianca extends Casella{

    final static int n = 2;
    public Bianca () {
        super();
        this.rec.setFill(Color.WHITE);
        switch ((int) (Math.random() * n)) {
            case 0:
                this.valore.setText("-1");
                this.val = -1;
                break;
            case 1:
                this.valore.setText("+1");
                this.val = 1;
                break;
            default:
                System.out.println("E' stato inserito un valore non valido");
                break;
        }
        this.getChildren().addAll(this.rec, this.valore);
        mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (val == -1) {
                    val = 1;
                    valore.setText("+1");
                } else {
                    val = -1;
                    valore.setText("-1");
                }
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseHandler);

    }

}
