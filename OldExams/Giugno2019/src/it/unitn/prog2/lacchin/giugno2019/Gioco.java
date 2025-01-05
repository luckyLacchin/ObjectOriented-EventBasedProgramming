package it.unitn.prog2.lacchin.giugno2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.security.auth.callback.TextInputCallback;


public class Gioco extends Application {

    int N;
    HBox bottom;
    @Override
    public void start(Stage primaryStage) {
        boolean corretto = false;
        String s;
        do {
            TextInputDialog dialog = new TextInputDialog("Numero di Tiles");
            dialog.setTitle("INFORMAZIONE");
            dialog.setHeaderText("");
            dialog.setContentText("N: ");
            s = dialog.showAndWait().get();
            try {
                N = Integer.parseInt(s);
                if (N > 3 && N < 11 && N%2 == 0) {
                    corretto = true;
                }
                else {
                    System.out.println("Inserire un numero intero valido tra 3 e 11");
                }
            }catch (NumberFormatException e) {
                System.out.println("Inserire un numero intero valido tra 3 e 11");
            }

        }while (!corretto);
        if (corretto) {
            BorderPane root = new BorderPane();

            Button riordina = new Button ("Riordina");
            Stack stack = new Stack(N,this);
            bottom = new HBox();

            riordina.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stack.riordina();
                }
            });

            BorderPane.setAlignment(stack, Pos.CENTER);
            BorderPane.setAlignment(riordina,Pos.TOP_LEFT);
            BorderPane.setAlignment(bottom,Pos.BOTTOM_LEFT);
            root.setTop(riordina);
            root.setCenter(stack);
            root.setBottom(bottom);

            primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent e) {

                    if (e.getCharacter().equals("R")) {
                        riordina.fire();
                    }
                    int n = Integer.parseInt(e.getCharacter());
                    if (n >= 0 && n <= 9) {
                        for (Tile tile : stack.lista) {
                            if (tile.numero == n) {

                                MouseEvent.fireEvent((EventTarget) tile, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                                        tile.getLayoutX(), tile.getLayoutY(), tile.getLayoutX(), tile.getLayoutY(), null, 1,
                                        true, true, true, true, true, true, true, true, true, true, null) );
                            }
                        }
                    }
                }
            });

            Scene scene = new Scene(root, 300, 600);
            primaryStage.setTitle("Tiles");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}