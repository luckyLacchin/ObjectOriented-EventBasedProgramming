package it.unitn.prog2.lacchin.giugno2021;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



public class Main extends Application {
    static final int n = 4;
    GridPane griglia = null;
    Palette palette = null;
    static EventHandler<MouseEvent> mouseEvent = null;
    @Override
    public void start(Stage primaryStage) {

        mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Node temp = (Node) mouseEvent.getSource();
                Line ops = null;
                Class<?> classe = temp.getClass();
                String name = classe.getName();
                //System.out.println(name);
                //System.out.println(temp);
                switch (name) {
                    case "it.unitn.prog2.lacchin.giugno2021.Diritto":
                        ((Diritto)temp).change();
                        break;
                    case "it.unitn.prog2.lacchin.giugno2021.CurvaC":
                        ((CurvaC)temp).change();
                        break;
                    case "it.unitn.prog2.lacchin.giugno2021.ScambioC":
                        break;
                    case "it.unitn.prog2.lacchin.giugno2021.Vuoto":
                        ((Vuoto)temp).change();
                        break;
                    default:
                        //System.out.println("E' stata inserita una classe non valida!");
                        break;

                }

            }


        };
        VBox root = new VBox();
        griglia = new GridPane();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                griglia.add(new Vuoto(mouseEvent),j,i);
            }
        }
        HBox bottoni = new HBox();
        bottoni.setAlignment(Pos.BASELINE_LEFT);
        Button test = new Button("TEST");
        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //GridPane newgriglia = new GridPane();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        Casella [] caselle = {new Diritto(mouseEvent),new CurvaC(mouseEvent), new ScambioC(mouseEvent),new Vuoto(mouseEvent)};
                        griglia.add(caselle[(int) (Math.random()*n)],j,i);
                    }
                }
                /*root.getChildren().removeAll(griglia,bottoni);
                griglia = newgriglia;
                root.getChildren().addAll(griglia,bottoni);
                 */



            }
        });
        Button reset = new Button("Reset");
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GridPane newgriglia = new GridPane();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {

                        newgriglia.add(new Vuoto(mouseEvent),j,i);
                    }
                }
                root.getChildren().removeAll(griglia,bottoni);
                griglia = newgriglia;
                root.getChildren().addAll(griglia,bottoni);
            }
        });
        bottoni.getChildren().addAll(test,reset);
        root.getChildren().addAll(griglia,bottoni);
        Scene scene = new Scene(root, 400, 150);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCharacter().equals("R"))  {
                    reset.fire();
                }
            }
        });
        primaryStage.setTitle("ACEI");
        primaryStage.setScene(scene);
        primaryStage.show();

        palette = new Palette();
        palette.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}