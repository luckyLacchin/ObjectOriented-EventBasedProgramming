package it.unitn.prog2.febbraio2020;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) {
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);

         */
        BorderPane root = new BorderPane();

        Griglia griglia = new Griglia();
        griglia.setAlignment(Pos.CENTER);
        Button check = new Button ("Check");
        BorderPane.setAlignment(check, Pos.BOTTOM_CENTER);


        root.setBottom(check);
        root.setCenter(griglia);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Gabriele Lacchin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}