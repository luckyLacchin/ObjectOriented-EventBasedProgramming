package it.unitn.prog2.lacchin.giugno2022;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;


public class TuttoStage extends Stage {

        Main app = null;
        public TuttoStage (Main app) {
            super();

            this.app = app;

            BorderPane root = new BorderPane();

            Griglia griglia = new Griglia(app);
            Button ordPerStato = new Button("Ordina per stato");
            Button ordPerCapitale = new Button("Ordina per capitale");
            ordPerStato.setId("OrdinaPerStato");
            ordPerCapitale.setId("OrdinaPerCapitale");

            EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    Button source = (Button) actionEvent.getSource();
                    switch (source.getId()) {
                        case "OrdinaPerStato":
                            griglia.getChildren().clear();
                            Collections.sort(app.stati,new OrdPerStato());
                            griglia.riempiPrimaColonna();
                            griglia.riempiSecondaColonna();
                            griglia.riempiTerzaColonna();
                            //root.setCenter(griglia);
                            break;
                        case "OrdinaPerCapitale":
                            griglia.getChildren().clear();
                            Collections.sort(app.stati,new OrdPerCapitale());
                            griglia.riempiPrimaColonna();
                            griglia.riempiSecondaColonna();
                            griglia.riempiTerzaColonna();
                            //root.setCenter(griglia);
                            break;
                        default:
                            System.out.println("C'è stato un errore!");
                    }
                }
            };

            ordPerCapitale.addEventHandler(ActionEvent.ACTION,eventHandler);
            ordPerStato.addEventHandler(ActionEvent.ACTION,eventHandler);

            HBox bottom = new HBox();
            bottom.getChildren().addAll(ordPerStato,ordPerCapitale);

            root.setCenter(griglia);
            root.setBottom(bottom);


            Scene scene = new Scene(root,250,450);
            this.setTitle("Mostra tutto");
            this.setScene(scene);


        }
}
