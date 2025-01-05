package it.unitn.prog2.lacchin.changecolor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainInterneAnonime extends Application {
    int index = 0;
    boolean right = true;
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        HBox figures = new HBox();
        BorderPane.setAlignment(figures, Pos.CENTER);
        Figura rectangle = new Figura(new Rectangle(70,70));
        Figura circle = new Figura(new Circle (35));
        Figura triangle = new Figura (new Polygon ());
        ((Polygon)triangle.getFigure()).getPoints().setAll(
                0.0, 0.0,
                70.0, 0.0,
                35.0, 70.0
        );
        ArrayList <Figura> arrayFigures = new ArrayList();
        arrayFigures.add(rectangle);
        arrayFigures.add(circle);
        arrayFigures.add(triangle);
        figures.getChildren().addAll(rectangle.getFigure(),circle.getFigure(),triangle.getFigure());
        figures.setAlignment(Pos.CENTER);
        HBox buttons = new HBox();
        BorderPane.setAlignment(buttons,Pos.BOTTOM_CENTER);
        Button change = new Button("Cambia colore");
        Button turn = new Button("=>");
        buttons.getChildren().addAll(change,turn);
        buttons.setAlignment(Pos.CENTER);
        change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Figura temp = arrayFigures.get(index);
                temp.change();
                if (right)
                    index +=1;
                else
                    index -= 1;
                if (index == 3)
                    index = 0;
                if (index < 0)
                    index = 2;

            }
        });
        turn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                right = !right;
                if (right) {
                    turn.setText("=>");
                    switch (index) {
                        case 0:
                            index = 2;
                            break;
                        case 1:
                            index = 0;
                            break;
                        case 2:
                            index = 1;
                            break;
                        default:
                            System.out.println("C'è stato un errore!");
                    }
                }
                else {
                    turn.setText("<=");
                    switch (index) {
                        case 0:
                            index=1;
                            break;
                        case 1:
                            index = 2;
                            break;
                        case 2:
                            index = 0;
                            break;
                        default:
                            System.out.println("C'è stato un errore!");
                    }
                }
            }
        });
        ////////////////////////////////////////
        root.setCenter(figures);
        root.setBottom(buttons);
        //////////////////////////////////////
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Self");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}