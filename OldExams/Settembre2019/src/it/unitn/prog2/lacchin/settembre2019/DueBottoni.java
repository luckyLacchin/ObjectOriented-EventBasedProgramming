package it.unitn.prog2.lacchin.settembre2019;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class DueBottoni extends Casella{


    public DueBottoni () {
        super();
        random = new Button("R");
        random.setId("random");
        random.setPrefSize(Casella.LATO,Casella.LATO);
        bottoni.getChildren().addAll(cancella, random);
        figura = new Vuoto(this);
        this.getChildren().addAll(figura.getFigura(),bottoni);
        random.addEventHandler(ActionEvent.ACTION,buttonHandler);
        cancella.addEventHandler(ActionEvent.ACTION,buttonHandler);

    }
}
