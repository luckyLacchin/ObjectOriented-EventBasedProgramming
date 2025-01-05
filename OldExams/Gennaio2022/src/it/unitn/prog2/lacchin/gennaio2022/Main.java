package it.unitn.prog2.lacchin.gennaio2022;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static it.unitn.prog2.lacchin.gennaio2022.Griglia.bianca;


public class Main extends Application {

    Griglia griglia = null;
    @Override
    public void start(Stage primaryStage) {


        griglia = new Griglia();
        GridPane root = griglia.root;
        Scene scene = new Scene(root, 250, 250);
        scene.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCharacter().equals("C")) {
                    Event.fireEvent(((EventTarget) bianca), new MouseEvent(MouseEvent.MOUSE_CLICKED,36.0,28.0,1388.0,633.0 ,null,1,true,true,true,
                            true,true,true,true,true,true,true,null));


                }
            }
        });



        primaryStage.setTitle("Play!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}