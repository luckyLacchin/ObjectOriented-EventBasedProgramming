package cambiaColoreExt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Self extends Application {

    private int index = -1;
    private boolean verse = true; //se è vero vuol dire che va a dx; altrimenti sx.
    private HBox figure = new HBox();
    private Button direzione = new Button("=>");

    public void changeColor () {

        if (verse){
            index++;
        }else if (index == 0) {
            index = figure.getChildren().size()-1;
        }else {
            index--;
        }
        index %= figure.getChildren().size();
        Shape s = (Shape) figure.getChildren().get(index);
        s.setFill (new Color(Math.random(),Math.random(),Math.random(),Math.random()));
    }
    public void changeVerse () {
        if (verse)
            direzione.setText("<=");
        else
            direzione.setText("=>");
        verse = !verse;

    }
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        //HBox figure = new HBox();
        Rectangle rect = new Rectangle(100,100);
        rect.setFill(Color.VIOLET);
        rect.setStroke(Color.BLACK);
        Circle cir = new Circle(50);
        cir.setStroke(Color.BLACK);
        cir.setFill(Color.BLACK);
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                0.0, 0.0,
                110.0, 0.0,
                55.0, 79.321 });
        polygon.setStroke (Color.BLACK);
        polygon.setFill(Color.CYAN);
        figure.getChildren().addAll(rect,cir,polygon);
        HBox bottoni = new HBox();
        Button cambia = new Button("Cambia colore");
        //Button direzione = new Button("=>");
        bottoni.getChildren().addAll(cambia,direzione);
        bottoni.setAlignment(Pos.CENTER);
        root.setBottom(bottoni);
        figure.setAlignment(Pos.CENTER);
        root.setCenter(figure);
        cambia.addEventHandler(ActionEvent.ACTION,new CambiaListener(this));
        direzione.addEventHandler(ActionEvent.ACTION, new DirezioneListener(this));
        Scene scene = new Scene(root, 350, 250);
        primaryStage.setTitle("Self");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}