package it.unitn.prog2.lacchin.gennaio2022;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Griglia {

    public static Bianca bianca = new Bianca();
    public GridPane root = null;
    public Griglia () {

        Griglia thisgriglia = this;
        root = new GridPane();
        int sum_row = 0;
        int sum_column = 0;
        int n;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                n = ((int)(Math.random() * 2));
                if (n == 0)
                     root.add(new Gialla(),j,i);
                else
                    root.add(new Viola(),j,i);
            }
        }
        for (int i = 0; i < 4; i++) {
            root.add(new Verde(somma(i,true),thisgriglia),4,i);
        }
        for (int j = 0; j < 4; j++) {
            root.add(new Rossa(somma(j,false),thisgriglia),j,4);
        }
        root.add(bianca,4,4);


    }
    public int somma (int index,boolean PerRiga) {

        int res = 0;
        if (PerRiga) {
            for (Node temp : root.getChildren()) {
                if (GridPane.getRowIndex(temp) == index) {
                    res += ((Casella)temp).val;
                }
            }
        }
        else {
            for (Node temp : root.getChildren()) {
                if (GridPane.getColumnIndex(temp) == index) {
                    res += ((Casella)temp).val;
                }
            }
        }
        return res;
    }
    void controllo () {
        boolean vinto = false;
        boolean perso = false;
        for (Node temp : root.getChildren()) {
            if (((Casella)temp).val >= 10) {
                if (temp instanceof Rossa)
                    perso = true;
                if (temp instanceof Verde)
                    vinto = true;
            }
        }
        if (vinto && perso) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RISULTATO");
            alert.setHeaderText("ESITO: ");
            alert.setContentText("HAI PAREGGIATO");
            alert.showAndWait();
        }
        else if (vinto) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RISULTATO");
            alert.setHeaderText("ESITO: ");
            alert.setContentText("HAI VINTO");
            alert.showAndWait();
        }
        else if (perso) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RISULTATO");
            alert.setHeaderText("ESITO: ");
            alert.setContentText("HAI PERSO");
            alert.showAndWait();
        }
        if (vinto || perso) {
            for (Node temp: root.getChildren()) {
                if ((temp instanceof Bianca) || (temp instanceof Verde) || (temp instanceof Rossa))
                temp.removeEventHandler(MouseEvent.MOUSE_CLICKED,((Casella)temp).mouseHandler);
            }
        }
    }
}

/* Controllare perché mi escono fuori 2 alert
Non ne capisco il motivo, magari il controllo viene lanciato due volte!?
 */