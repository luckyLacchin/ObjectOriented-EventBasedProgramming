package it.unitn.prog2.lacchin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComunicazioneStage extends Stage {

    Text messaggio;
    ComunicazioneStage questo;
    public ComunicazioneStage (boolean vinto, Stage primaryStage) {

        VBox root = new VBox();
        questo = this;
        if (vinto)
            messaggio = new Text("Complimenti, hai vinto!");
        else
            messaggio = new Text("Peccato hai perso");

        messaggio.setFont(new Font(25));
        messaggio.setFill(Color.RED);

        Button ok = new Button("OK");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                questo.close();
                if (!vinto)
                    primaryStage.close();
            }
        });

        root.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(messaggio,ok);

        this.setTitle("COMUNICAZIONE");
        Scene scene = new Scene(root,300,100);
        this.setScene(scene);





    }

}
