package it.unitn.prog2.lacchin.gennaio2022;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Verde extends Casella{

    Griglia app = null;
    Verde verde = null;

    public Verde () {
        super();
        this.rec.setFill(Color.GREEN);
    }
    public Verde (int somma, Griglia app) {
        this();
        verde = this;
        this.app = app;
        this.val = somma;
        this.valore.setText(String.valueOf(somma));
        this.getChildren().addAll(this.rec,this.valore);
        mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    int row = GridPane.getRowIndex(verde);
                    verde.modificaRiga(row);
                    app.controllo();
            }
        };

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseHandler);
    }
    public void modificaRiga (int row) {
        int n;

        for (Node temp: app.root.getChildren()) {
            if (GridPane.getRowIndex(temp) == row && temp != verde) {
                String classeName = temp.getClass().getName();

                switch (classeName) {
                    case "it.unitn.prog2.lacchin.gennaio2022.Viola":
                        Viola t = (Viola)temp;
                        n = ((Casella)temp).val + app.bianca.val;
                        if (n > 3) {
                            t.val = 0;
                            t.valore.setText("0");

                        }
                        else if (n < 0) {
                            t.val = 3;
                            t.valore.setText("3");

                        }
                        else {
                            t.val = n;
                            t.valore.setText(String.valueOf(t.val));

                        }
                        break;
                    case "it.unitn.prog2.lacchin.gennaio2022.Gialla":
                        Gialla s = (Gialla)temp;
                        n = ((Casella)temp).val - app.bianca.val;
                        if (n > 3) {
                            s.val = 0;
                            s.valore.setText("0");

                        }
                        else if (n < 0) {
                            s.val = 3;
                            s.valore.setText("3");

                        }
                        else {
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
        verde.val = 0;
        verde.val = app.somma (row,true);
        verde.valore.setText(String.valueOf(verde.val));
        for (Node k : app.root.getChildren()) {
            if (GridPane.getRowIndex(k)==4 && !(k instanceof Bianca)) {
                Rossa temp = (Rossa)k;
                temp.val = 0;
                temp.val = app.somma(GridPane.getColumnIndex(temp),false);
                temp.valore.setText(String.valueOf(temp.val));

            }

        }
    }

}
//Facciamo pausetta pensiamo a come calcolare il valore dei verdi
//in caso possiamo anche settare x e y per ciascuna casella
//ma per deciderlo guardare il restante della consegna