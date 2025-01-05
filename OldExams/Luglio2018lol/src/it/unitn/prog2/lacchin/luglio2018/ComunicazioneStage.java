package it.unitn.prog2.lacchin.luglio2018;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ComunicazioneStage extends Stage {

    String testo;
    ComunicazioneStage questo;
    public ComunicazioneStage (String comunicazione) {
        super();
        this.testo = comunicazione;
        questo = this;
        VBox root = new VBox();
        Text text = new Text(comunicazione);
        Text top = new Text("INFORMAZIONE");
        text.setTextAlignment(TextAlignment.LEFT);
        top.setTextAlignment(TextAlignment.LEFT);
        top.setFill(Color.RED);
        text.setFill(Color.BLACK);
        top.setFont(new Font(25));
        text.setFont(new Font(20));
        Button ok = new Button ("OK");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                questo.close();
            }
        });

        root.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY,Insets.EMPTY)));

        root.getChildren().addAll(top,text,ok);


        Scene scene = new Scene(root, 300, 100);
        this.setTitle("MESSAGGIO");
        this.setScene(scene);
        this.show();
    }
}
