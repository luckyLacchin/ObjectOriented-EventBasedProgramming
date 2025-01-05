package it.unitn.prog2.lacchin.settembre2019;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class TreBottoni extends Casella{

    public TreBottoni () {

        faiCerchio = new Button("0");
        faiCerchio.setId("cerchio");
        faiCerchio.setPrefSize(Casella.LATO,Casella.LATO);
        faiTriangolo = new Button("T");
        faiTriangolo.setId("triangolo");
        bottoni.getChildren().addAll(cancella,faiCerchio,faiTriangolo);
        figura = new Vuoto(this);
        this.getChildren().addAll(figura.getFigura(),bottoni);
        cancella.addEventHandler(ActionEvent.ACTION,buttonHandler);
        faiCerchio.addEventHandler(ActionEvent.ACTION,buttonHandler);
        faiTriangolo.addEventHandler(ActionEvent.ACTION,buttonHandler);
    }
}
