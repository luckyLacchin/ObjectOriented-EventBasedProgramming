package it.unitn.prog2.lacchin.picco_luglio2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Iterator;

public class Escape extends Application {

    static final int WIDTH = 500;
    @Override
    public void start(Stage primaryStage) {

        Layout root = new Layout();
        Scene scene = new Scene(root, WIDTH, WIDTH);


        EventHandler <KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                User target = null;
                for (Palla palle : root.palle) {
                    if (palle.getClass().getName().equals("it.unitn.prog2.lacchin.picco_luglio2019.User")) {
                        target = (User) palle;
                    }
                }
                switch (keyEvent.getCode()) {
                    case LEFT -> target.move(-1, 0);
                    case RIGHT -> target.move(+1, 0);
                    case UP -> target.move(0, -1);
                    case DOWN -> target.move(0, +1);
                    default -> System.out.println("Qualcosa è andato storto!");
                }
                User.iterazione++;
                Iterator <Palla> x = root.palle.iterator();
                while (x.hasNext()) {
                    Palla enemy = x.next();
                    if (enemy != target) {
                        ((Enemy) enemy).sposta();
                    }
                }
                if (User.iterazione%10 == 0) {
                    root.aggiungi();
                }
                while (x.hasNext()) {
                    Palla palla = x.next();
                    if (palla.fuoriBordo()) {
                        //a questo punto devo riposizionarla.
                        palla.pacMan();
                    }
                }
            }
        };
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, keyHandler);
        primaryStage.setTitle("Escape!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}