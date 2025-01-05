package it.unitn.prog2.minicalc;

import javafx.application.Application;
import javafx.event.*;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;

public class Main extends Application {
    TextField t1;
    TextField t2;
    TextField t3;
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        TilePane center = new TilePane();

        TilePane pane3 = new TilePane();
        HBox top = new HBox();
        Button sum = new Button("PIU'");
        Button minus = new Button("MENO");
        Button mul = new Button("PER");
        Button div = new Button("DIVISO");
        Text topText = new Text ("MiniCalculator");
        Button clear = new Button("Clear");
        VBox left = new VBox();
        VBox right = new VBox();
        t1 = new TextField("");
        t2 = new TextField("");
        t3 = new TextField("");
        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);
        left.getChildren().add(new Text ("Left"));
        right.getChildren().add(clear);
        clear.setAlignment(Pos.CENTER);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                t1.clear();
                t2.clear();
                t3.clear();
            }
        });
        top.setAlignment(Pos.CENTER);
        topText.setTextAlignment(TextAlignment.CENTER);
        top.getChildren().add(topText);
        pane3.setPrefColumns(4);
        pane3.setAlignment(Pos.CENTER);
        pane3.getChildren().addAll(sum,minus,mul,div);
        center.setPrefColumns(0);
        center.setAlignment(Pos.CENTER);
        /*center.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        h1.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        h2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        pane3.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        h4.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                */
        center.getChildren().addAll(t1,t2,pane3,t3);
        root.setLeft(left);
        root.setRight(right);
        root.setTop(top);
        root.setCenter(center);
        Scene scene = new Scene(root, 350, 150);
        primaryStage.setTitle("MiniCalculator");
        primaryStage.setScene(scene);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                if ((!keyEvent.getCharacter().equals("0")) &&  (!keyEvent.getCharacter().equals("1")) && (!keyEvent.getCharacter().equals("2"))  &&
                        (!keyEvent.getCharacter().equals("3"))  && (!keyEvent.getCharacter().equals("4"))  && (!keyEvent.getCharacter().equals("5"))  &&
                        (!keyEvent.getCharacter().equals("6"))  && (!keyEvent.getCharacter().equals("7"))  && (!keyEvent.getCharacter().equals("8"))  &&
                        (!keyEvent.getCharacter().equals("9")) && (!keyEvent.getCharacter().equals("+")) && (!keyEvent.getCharacter().equals("-"))
                        && (!keyEvent.getCharacter().equals("*")) && (!keyEvent.getCharacter().equals("=")) && (!keyEvent.getCharacter().equals("/")))
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMAZIONE");
                    alert.setContentText("E' stato inserito un carattere non valido.");
                    alert.setHeaderText("ERRORE!");
                    alert.showAndWait();
                    EventTarget evento = keyEvent.getTarget();
                    if (evento instanceof TextField) {
                        TextField temp = (TextField) evento;
                        System.out.println("CIAOO1O");
                        temp.clear();
                    }
                    else {
                        System.out.println("C'è stato un errore!");
                    }

                }
                else if (keyEvent.getCharacter().equals("+") || keyEvent.getCharacter().equals("-") ||
                        keyEvent.getCharacter().equals("*") || keyEvent.getCharacter().equals("/")) {
                    //a questo punto devo fare l'operazione fire di quell'evento
                    primaryStage.fireEvent(new OperationHandler());
                    System.out.println("CIAOOO");
                }

            }
        });
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
    class OperationHandler extends ActionEvent {

        public OperationHandler () {
            super();
        }
        public void handle(ActionEvent actionEvent) {

        }
    }

}