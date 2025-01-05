package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Bomba extends Cella{

    static final Color BLUE = Color.BLUE;

    public Bomba(Griglia griglia) {
        super(griglia);
        background.setFill(BLUE);
        text.setText("BOOM!");
        this.getChildren().addAll(background,text,foreground);
    }

    public Bomba (int i, int j, Griglia griglia) {
        super(i,j,griglia);
        background.setFill(BLUE);
        text.setText("BOOM!");
        this.getChildren().addAll(background,text,foreground);
    }

    @Override
    public void fire () {
        //lo implementiamo dopo!
        int row = GridPane.getRowIndex(this);
        int column = GridPane.getColumnIndex(this);
        if (!griglia.bombe.contains(this))
            griglia.bombe.add(this);
        int index = griglia.bombe.indexOf(this);
        //facciamo prima fire degli eventi nella riga
        for (int k = 0; k < 10; k++) {
            if (!griglia.matrice[row][k].scoperto && !griglia.matrice[row][k].equals(this)) {
                if (!(griglia.matrice[row][k] instanceof Bomba)) {
                    griglia.matrice[row][k].getChildren().remove(griglia.matrice[row][k].foreground);
                    griglia.matrice[row][k].fire();
                    griglia.matrice[row][k].scoperto = true;
                }
                else {
                    if (!griglia.bombe.contains(griglia.matrice[row][k]))
                        griglia.bombe.add((Bomba)griglia.matrice[row][k]);
                }
            }
        }
        for (int k = 0; k < 10; k++) {
            if (!griglia.matrice[k][column].scoperto && !griglia.matrice[k][column].equals(this)) {
                if (!(griglia.matrice[k][column] instanceof Bomba)) {
                    griglia.matrice[k][column].getChildren().remove(griglia.matrice[k][column].foreground);
                    griglia.matrice[k][column].fire();
                    griglia.matrice[k][column].scoperto = true;
                }
                else {
                    if (!griglia.bombe.contains(griglia.matrice[k][column]))
                        griglia.bombe.add((Bomba)griglia.matrice[k][column]);
                }
            }
        }

        for (int i = index+1; i < griglia.bombe.size(); i++) {
            griglia.bombe.get(i).getChildren().remove(griglia.bombe.get(i).foreground);
            griglia.bombe.get(i).scoperto = true;
            griglia.bombe.get(i).fire();
        }

    }
}
