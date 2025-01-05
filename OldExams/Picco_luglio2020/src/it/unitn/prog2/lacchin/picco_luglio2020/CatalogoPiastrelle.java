package it.unitn.prog2.lacchin.picco_luglio2020;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CatalogoPiastrelle extends Application {
    Layout root;
    Catalogo catalogo;
    Button prev,next;
    Scene scene;
    @Override
    public void start(Stage primaryStage) {

        prev = new Button("<prev");
        prev.setId("prev");
        next = new Button("next>");
        next.setId("next");
        catalogo = new Catalogo();
        root = new Layout(prev,next,catalogo.get(0));
        controlliBottoni();


        scene = new Scene(root, 300, 180);
        primaryStage.setTitle("Catalogo Piastrelle: ");
        primaryStage.setScene(scene);
        primaryStage.show();

        EventHandler <ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button target = (Button) actionEvent.getTarget();
                switch (target.getId()) {
                    case "prev":
                        root = new Layout(prev,next,catalogo.get(--catalogo.indice));
                        break;
                    case "next":
                        root = new Layout(prev,next,catalogo.get(++catalogo.indice));
                        break;
                    default:
                        System.out.println("C'e' stato un errore!");
                }
                scene = new Scene(root,300,180);
                primaryStage.setScene(scene);
                controlliBottoni();
            }
        };
        prev.addEventHandler(ActionEvent.ACTION,eventHandler);
        next.addEventHandler(ActionEvent.ACTION,eventHandler);

    }
    public static void main(String[] args) {
        launch(args);
    }

    public void controlliBottoni () {
        prev.setDisable(false);
        next.setDisable(false); //intanto li setto così in caso verrano modificati
        if (catalogo.indice==0) {
            prev.setDisable(true);
        }
        else if (catalogo.indice == catalogo.size()-1) {
            next.setDisable(true);
        }
    }
}