package it.unitn.disi.prog2.giugno2018;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StagePopUp extends Stage {

    Text popUp;
    public StagePopUp (String testo) {

        popUp = new Text(testo);
        VBox root = new VBox();
        root.getChildren().add(popUp);
        Scene scene = new Scene(root,popUp.getText().length()+50,popUp.getText().length()+50);
        this.setScene(scene);
        this.setTitle("MESSAGGIO");


    }
}
