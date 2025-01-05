package cambiaColoreIntegrato;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

public class IntegrateMain extends Application implements EventHandler <ActionEvent> {

    private int index = -1;
    private boolean verse = true; //se è vero vuol dire che va a dx; altrimenti sx.
    private HBox figure = new HBox();
    Button direzione = new Button("=>");


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        //HBox figure = new HBox();
        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.VIOLET);
        rect.setStroke(Color.BLACK);
        Circle cir = new Circle(50);
        cir.setStroke(Color.BLACK);
        cir.setFill(Color.BLACK);
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                0.0, 0.0,
                110.0, 0.0,
                55.0, 79.321});
        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.CYAN);
        figure.getChildren().addAll(rect, cir, polygon);
        HBox bottoni = new HBox();
        Button cambia = new Button("Cambia colore");
        cambia.setId("cambia");
        direzione.setId("direzione");
        bottoni.getChildren().addAll(cambia, direzione);
        bottoni.setAlignment(Pos.CENTER);
        root.setBottom(bottoni);
        figure.setAlignment(Pos.CENTER);
        root.setCenter(figure);
        cambia.addEventHandler(ActionEvent.ACTION, this);
        direzione.addEventHandler(ActionEvent.ACTION, this);
        Scene scene = new Scene(root, 350, 250);
        primaryStage.setTitle("Self");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node target= (Node) actionEvent.getTarget();
        if (target.getId().equals("cambia")) {
            if (verse){
                index++;
            }else if (index == 0) {
                index = figure.getChildren().size()-1;
            }else {
                index--;
            }
            index %= figure.getChildren().size();
            Shape s = (Shape) figure.getChildren().get(index);
            s.setFill (new Color (Math.random(),Math.random(),Math.random(),Math.random()));

// implement action for btn1
        } else if (target.getId().equals("direzione")) {
            if (verse)
                direzione.setText("<=");
            else
                direzione.setText("=>");
            verse = !verse;
// implement action for btn2
        }

    }
}
