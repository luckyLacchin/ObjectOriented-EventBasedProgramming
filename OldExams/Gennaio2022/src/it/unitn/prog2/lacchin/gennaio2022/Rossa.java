package it.unitn.prog2.lacchin.gennaio2022;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Rossa extends Casella{

    Griglia app = null;
    Rossa rossa = null;
    public Rossa () {
        super();
        this.rec.setFill(Color.RED);
    }
    public Rossa (int somma, Griglia app) {
        this();
        this.val = somma;
        rossa = this;
        this.app = app;
        this.valore.setText(String.valueOf(somma));
        this.getChildren().addAll(this.rec,this.valore);
        mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int column = GridPane.getColumnIndex(rossa);
                rossa.modificaColonna(column);
                app.controllo();
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseHandler);
    }
    public void modificaColonna (int column) {
        int n;

        for (Node temp : app.root.getChildren()) {
            if (GridPane.getColumnIndex(temp) == column && temp != rossa) {
                String classeName = temp.getClass().getName();

                switch (classeName) {
                    case "it.unitn.prog2.lacchin.gennaio2022.Viola":
                        Viola t = (Viola) temp;
                        n = ((Casella) temp).val + app.bianca.val;
                        if (n > 3) {
                            t.val = 0;
                            t.valore.setText("0");

                        } else if (n < 0) {
                            t.val = 3;
                            t.valore.setText("3");

                        } else {
                            t.val = n;
                            t.valore.setText(String.valueOf(t.val));

                        }
                        break;
                    case "it.unitn.prog2.lacchin.gennaio2022.Gialla":
                        Gialla s = (Gialla) temp;
                        n = ((Casella) temp).val - app.bianca.val;
                        if (n > 3) {
                            s.val = 0;
                            s.valore.setText("0");

                        } else if (n < 0) {
                            s.val = 3;
                            s.valore.setText("3");

                        } else {
                            s.val = n;
                            s.valore.setText(String.valueOf(s.val));

                        }
                        break;
                    default:
                        System.out.println("E' stato inserito un valore non valido.");
                        break;
                }
            }
        }
        rossa.val = 0;
        rossa.val = app.somma (column,false);
        rossa.valore.setText(String.valueOf(rossa.val));
        for (Node k : app.root.getChildren()) {
            if (GridPane.getColumnIndex(k)==4 && !(k instanceof Bianca)) {
                Verde temp = (Verde)k;
                temp.val = 0;
                temp.val = app.somma(GridPane.getRowIndex(temp),true);
                temp.valore.setText(String.valueOf(temp.val));

            }

        }
        //app.controllo();
    }
}
