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

public class MainEsterne extends Application {
    int index = 0;
    boolean right = true;
    Button turn = null;
    ArrayList <Figura> arrayFigures = null;
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
        arrayFigures = new ArrayList();
        arrayFigures.add(rectangle);
        arrayFigures.add(circle);
        arrayFigures.add(triangle);
        figures.getChildren().addAll(rectangle.getFigure(),circle.getFigure(),triangle.getFigure());
        figures.setAlignment(Pos.CENTER);
        HBox buttons = new HBox();
        BorderPane.setAlignment(buttons,Pos.BOTTOM_CENTER);
        Button change = new Button("Cambia colore");
        turn = new Button("=>");
        buttons.getChildren().addAll(change,turn);
        buttons.setAlignment(Pos.CENTER);
        change.addEventHandler(ActionEvent.ACTION,new changeListener(this));
        turn.addEventHandler(ActionEvent.ACTION,new turnListener(this));
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