package it.unitn.prog2.lacchin.settembre2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Tre extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Griglia griglia = new Griglia();

        HBox bottom = new HBox();
        Button clear = new Button ("clear All");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (Node temp : griglia.getChildren()) {
                    Casella c = (Casella) temp;
                    c.cancella.fire();
                }
            }
        });
        Button check = new Button("Check");
        check.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean perRiga = false;
                boolean perColonna = false;
                boolean corretto = true;
                int lato = -1;
                String direzione = "";
                for (int i = 0; i < 3 && !perRiga; i++) {
                    corretto = true;
                    Casella temp = (Casella) griglia.getElementAt(i,0);
                    if (!(temp.figura.getClass().getName().equals("it.unitn.prog2.lacchin.settembre2019.Vuoto"))) {
                        System.out.println(temp.figura.getClass().getName());
                        for (int j = 0; j < 3 && corretto; j++) {
                            if (!temp.figura.equals(((Casella) griglia.getElementAt(i, j)).figura)) {
                                corretto = false;
                            }
                            if (corretto && j == 2) {
                                System.out.println("ciao");
                                perRiga = true;
                                lato = i + 1;
                                System.out.println("lato: " + lato);
                            }
                        }
                    }
                    else
                        corretto = false;
                }
                System.out.println(corretto);
                if (!corretto) {//adesso controlliamo per colonna
                    corretto = true;
                    System.out.println ("Ciaone");
                    for (int j = 0; j < 3 && !perColonna; j++) {
                        corretto = true;
                        Casella temp = (Casella) griglia.getElementAt(0,j);
                        if (!(temp.figura.getClass().getName().equals("it.unitn.prog2.lacchin.settembre2019.Vuoto"))) {
                            for (int i = 0; i < 3 && corretto; i++) {
                                if (!temp.figura.equals(((Casella) griglia.getElementAt(i, j)).figura)) {
                                    corretto = false;
                                }
                                if (corretto && i == 2) {
                                    perColonna = true;
                                    lato = j + 1;
                                    System.out.println("lato: " + lato);
                                }
                            }
                        }
                        else
                            corretto = false;
                    }
                }
                if (perRiga && corretto) {
                    System.out.println("ciao2");
                    direzione = "riga";
                }
                else if (perColonna && corretto) {
                    System.out.println("ciao3");
                    direzione = "colonna";
                }

                if (corretto) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("MESSAGGIO");
                    alert.setHeaderText("CHECK:");
                    alert.setContentText("Tre uguali in "+ direzione +" " + lato);
                    alert.showAndWait();
                }
            }
        });
        bottom.setSpacing(20.0);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(clear,check);

        BorderPane.setAlignment(griglia,Pos.TOP_CENTER);
        root.setCenter(griglia);
        BorderPane.setAlignment(bottom, Pos.BOTTOM_CENTER);
        root.setBottom(bottom);

        EventHandler <KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(keyEvent.getCharacter()) {
                    case "A":
                        clear.fire();
                        break;
                    case "C":
                        check.fire();
                        break;
                    default:
                        System.out.println("Inserire un carattere valido!");
                }
            }
        };


        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}