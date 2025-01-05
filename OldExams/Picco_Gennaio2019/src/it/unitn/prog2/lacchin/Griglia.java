package it.unitn.prog2.lacchin;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

public class Griglia extends GridPane {


    Play play;
    final int LATO = 500;
    ArrayList<Cella> celle;
    Cella [] [] matrix;
    /*
    potrei anche fare una matrice di celle dove vado a mettere le varie celle
    ma non credo mi serva!
     */
    public Griglia (Play play) {
        this.play = play;
        celle = new ArrayList<>();
        matrix = new Cella[play.N][play.N];
        //vai avanti facendo la matrice e dopo il mouseHandler!
        this.setAlignment(Pos.CENTER);
        this.riempiCelle();
        this.riempi();



    }

    public void riempiCelle () {
        celle.add(new CellaP(this));
        celle.add(new CellaV(this));
        for (int i = 0; i < play.N * play.N - 2; i++) {
            celle.add(new CellaS(this));
        }
        Collections.shuffle(celle);
    }
    public void riempi () {
        int index = 0;
        for (int i = 0; i < play.N; i++) {
            for (int j = 0; j < play.N; j++) {
                matrix[i][j] = celle.get(index++);
                this.add(matrix[i][j],j,i);
            }
        }
    }

    public void mostra () {
        mostraStage mostraStage = new mostraStage(this);
        mostraStage.show();
    }
}
