package it.unitn.prog2.lacchin.changecolor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class turnListener implements EventHandler<ActionEvent> {
    MainEsterne app = null;
    turnListener (MainEsterne app) {
        this.app = app;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        app.right = !app.right;
        if (app.right) {
            app.turn.setText("=>");
            switch (app.index) {
                case 0:
                    app.index = 2;
                    break;
                case 1:
                    app.index = 0;
                    break;
                case 2:
                    app.index = 1;
                    break;
                default:
                    System.out.println("C'è stato un errore!");
            }
        }
        else {
            app.turn.setText("<=");
            switch (app.index) {
                case 0:
                    app.index=1;
                    break;
                case 1:
                    app.index = 2;
                    break;
                case 2:
                    app.index = 0;
                    break;
                default:
                    System.out.println("C'è stato un errore!");
            }
        }
    }
}
