package it.unitn.prog2.lacchin.gen9012020;

import it.unitn.prog2.lacchin.gen9012020.strade.Est;
import it.unitn.prog2.lacchin.gen9012020.strade.Nord;
import it.unitn.prog2.lacchin.gen9012020.strade.Ovest;
import it.unitn.prog2.lacchin.gen9012020.strade.Sud;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class Cella extends StackPane {

    public static final int LATO = 50;

    public BorderPane bp;
    public Rectangle rectangle;
    RoadGame game;
    int i,j;
    Rectangle auto = null;
    boolean haAuto = false;

    public Cella (int i, int j, RoadGame game) {
        super();
        this.i = i;
        this.j = j;
        this.game = game;
        /*
        auto = new Rectangle(20, 20);
        auto.setStroke(Color.BLACK);
        auto.setFill(Color.WHITE);

         */

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent actionEvent) {

                Object source = actionEvent.getSource();
                Cella c = (Cella) source;
                int row = GridPane.getRowIndex(c);
                int column = GridPane.getColumnIndex(c);
                if(game.premuto != null && !game.aggiungiAuto) {

                    game.griglia.getChildren().remove(c);
                    switch (game.premuto.getId()) {
                        case "ovest":
                            game.griglia.add(new Ovest(row,column,game),column,row);
                            break;
                        case "est":
                            game.griglia.add(new Est(row,column,game),column,row);
                            break;
                        case "nord":
                            game.griglia.add(new Nord(row,column,game),column,row);
                            break;
                        case "prato":
                            game.griglia.add(new Prato(row,column,game),column,row);
                            break;
                        case "sud":
                            game.griglia.add(new Sud(row,column,game),column,row);
                            break;
                        default:
                            System.out.println("Qualcosa è andato storto!");
                    }

                }
                else if (game.premuto == null && !game.aggiungiAuto) {
                    System.out.println("Premere un bottone");
                }
                else if (game.aggiungiAuto) {
                    if(c.getClass().getName().equals("it.unitn.prog2.lacchin.gen9012020.Prato")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("MESSAGE");
                        alert.setHeaderText("MESSAGGIO: ");
                        alert.setContentText("La macchina non può essere aggiunta su un prato!");
                        alert.showAndWait();

                    }
                    else {
                        game.aggiungi.setDisable(true);
                        game.muoviAuto.setDisable(false);
                        auto = new Rectangle(20, 20);
                        auto.setStroke(Color.BLACK);
                        auto.setFill(Color.WHITE);
                        c.getChildren().add(auto);
                        haAuto = true;
                    }
                    game.aggiungiAuto = false;

                }
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);
    }




}
