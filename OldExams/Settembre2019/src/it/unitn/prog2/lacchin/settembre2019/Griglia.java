package it.unitn.prog2.lacchin.settembre2019;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Griglia extends GridPane {

    public Griglia () {
        super();
        this.setAlignment(Pos.CENTER);
        this.
        riempiGriglia();
    }

    public void riempiGriglia () {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Casella temp = randomCasella();
                setMargin(temp, new Insets(5,5,5,5));
                this.add(temp,j,i);
            }
        }
    }

    public Casella randomCasella () {
        Casella casuale;
        int n = (int) (Math.random() * 2);

        switch (n) {
            case 0:
                casuale = new DueBottoni();
                break;
            case 1:
                casuale = new TreBottoni();
                break;
            default:
                System.out.println("Qualcosa è andato storto!");
                casuale = null;

        }
        return casuale;
    }

    Node getElementAt (int i, int j) {
        for (Node temp : this.getChildren()) {
            if(GridPane.getRowIndex(temp) == i && GridPane.getColumnIndex(temp) == j)
                return temp;
        }
        return null;
    }

}
