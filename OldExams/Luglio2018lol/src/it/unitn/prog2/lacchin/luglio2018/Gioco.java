package it.unitn.prog2.lacchin.luglio2018;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Gioco extends Application {

    static final double WIDTH = 125.0;
    Button [] buttons;
    Cella [] celle;
    ComunicazioneStage comunicazione;
    @Override
    public void start(Stage primaryStage) {


        HBox root = new HBox();

        VBox left = new VBox();
        celle = new Cella[5];
        for (int i = 0; i < 5; i++) {
            celle[i] = new Cella();
            left.getChildren().add(celle[i]);
        }

        VBox center = new VBox();

        VBox bottoni = new VBox();
        HBox primaFila = new HBox();
        HBox secondaFila = new HBox();
        bottoni.getChildren().addAll(primaFila,secondaFila);

        Button add = new Button("Add");
        Button removeBottom = new Button("Remove Bottom");
        Button removeTop = new Button("Remove Top");
        Button printStack = new Button("Print Stack");
        add.setId("add");
        removeBottom.setId("removeBottom");
        removeTop.setId("removeTop");
        printStack.setId("printStack");
        primaFila.getChildren().addAll(add,removeBottom);
        secondaFila.getChildren().addAll(removeTop,printStack);
        removeBottom.setPrefWidth(WIDTH);
        add.setPrefWidth(WIDTH);
        removeTop.setPrefWidth(WIDTH);
        printStack.setPrefWidth(WIDTH);


        HBox figura = new HBox();
        figura.getChildren().add(new Nera());
        figura.setAlignment(Pos.CENTER);

        HBox below = new HBox();
        Button circle = new Button("Circle");
        Button triangle = new Button("Triangle");
        Button hexagon = new Button("Hexagon");
        circle.setId("circle");
        triangle.setId("triangle");
        hexagon.setId("hexagon");
        circle.setPrefWidth(WIDTH);
        triangle.setPrefWidth(WIDTH);
        hexagon.setPrefWidth(WIDTH);
        below.getChildren().addAll(circle,triangle,hexagon);
        buttons = new Button[3];
        buttons[0] = circle;
        buttons[1] = triangle;
        buttons[2] = hexagon;


        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(bottoni,figura,below);

        root.getChildren().addAll(left,center);


        EventHandler <ActionEvent> actionHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                boolean trovato = false;
                Button button = (Button) actionEvent.getSource();
                switch (button.getId()) {
                    case "add":
                        Shape shape = (Shape) figura.getChildren().get(0);
                        if (!shape.getClass().getName().equals("it.unitn.prog2.lacchin.luglio2018.Nera")) {
                            //System.out.println(shape);
                            for (int i = celle.length - 1; i >= 0 && !trovato; i--) {
                                if (celle[i].figura == null) {
                                    celle[i].figura = new Figura(shape);
                                    trovato = true;
                                    celle[i].getChildren().add(celle[i].figura.getFigura());
                                    figura.getChildren().add(new Nera());
                                }
                            }
                            if (!trovato) {
                                System.out.println("La colonna e' piena!");
                                comunicazione = new ComunicazioneStage("La colonna e' piena");
                            }
                        }
                        else {
                            System.out.println("Bisogna aggiungere una figura!");
                            comunicazione = new ComunicazioneStage("Bisogna aggiungere una figura");
                        }
                        break;
                    case "removeTop":
                        for (int i = 0; i < celle.length && !trovato; i++) {
                            if (celle[i].figura != null) {
                                celle[i].removeFigura();
                                trovato = true;
                            }
                        }
                        if (!trovato) {
                            System.out.println("La colonna a sinistra e' completamente vuota!");
                            comunicazione = new ComunicazioneStage("La colonna a sinistra e' completamente vuota!");
                        }
                        break;
                    case "removeBottom":
                        if (celle[celle.length-1].getFigura() != null) {
                            celle[celle.length-1].removeFigura();

                            for (int j = celle.length-1; j > 0; j--) {
                                if (celle[j - 1].figura != null) {
                                    celle[j].figura = celle[j - 1].figura;
                                    celle[j].getChildren().add(celle[j].figura.getFigura()); //in questo modo dovrebbe togliersi dall'altra cella automaticamente!
                                    celle[j-1].figura = null;
                                }
                            }
                        }
                        else {
                            System.out.println("La colonna a sinistra e' completamente vuota!");
                            comunicazione = new ComunicazioneStage("La colonna a sinistra e' completamente vuota");
                        }

                        break;
                    case "printStack":
                        String s = "";
                        for (int i = 0; i < celle.length; i++) {
                            System.out.print(celle[i].toString() + ",");
                             s += celle[i].toString() + ",";
                        }
                        comunicazione = new ComunicazioneStage(s+"\n");
                        System.out.println();
                        break;
                    case "circle":
                        figura.getChildren().clear();
                        figura.getChildren().add(new Cerchio());
                        for (int i = 0; i <  3; i++) {
                            if (!buttons[i].getId().equals(button.getId())) {
                                buttons[i].setDisable(false);
                            }
                        }
                        button.setDisable(true);
                        break;
                    case "triangle":
                        figura.getChildren().clear();
                        figura.getChildren().add(new Triangolo());
                        for (int i = 0; i <  3; i++) {
                            if (!buttons[i].getId().equals(button.getId())) {
                                buttons[i].setDisable(false);
                            }
                        }
                        button.setDisable(true);
                        break;
                    case "hexagon":
                        figura.getChildren().clear();
                        figura.getChildren().add(new Esagono());
                        for (int i = 0; i <  3; i++) {
                            if (!buttons[i].getId().equals(button.getId())) {
                                buttons[i].setDisable(false);
                            }
                        }
                        button.setDisable(true);
                        break;

                }
            }
        };

        add.addEventHandler(ActionEvent.ACTION,actionHandler);
        removeBottom.addEventHandler(ActionEvent.ACTION,actionHandler);
        removeTop.addEventHandler(ActionEvent.ACTION,actionHandler);
        printStack.addEventHandler(ActionEvent.ACTION,actionHandler);
        circle.addEventHandler(ActionEvent.ACTION,actionHandler);
        triangle.addEventHandler(ActionEvent.ACTION,actionHandler);
        hexagon.addEventHandler(ActionEvent.ACTION,actionHandler);



        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Figure geometriche");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}