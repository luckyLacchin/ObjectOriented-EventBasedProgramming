package it.unitn.prog2.lacchin;

import javafx.scene.paint.Color;

public class CellaV extends Cella{

    public CellaV (Griglia griglia) {
        super(griglia);
        testo.setText("V");
    }

    @Override
    void scopri() {
        System.out.println("Complimenti, hai vinto!");
        griglia.play.comunicazioneStage = new ComunicazioneStage(true,griglia.play.primaryStage);
        griglia.play.comunicazioneStage.show();
        griglia.play.numeroVinte++;
        griglia.play.vinte.setText(String.valueOf(griglia.play.numeroVinte));

        for (Cella cella : griglia.celle) {
            if (cella.scoperta) {
                cella.getChildren().add(cella.foreground);
                cella.scoperta = false;
            }
        }
        griglia.play.punti = 0;
        griglia.play.punteggio.setText(String.valueOf(griglia.play.punti));
        griglia.play.punteggio.setFill(Color.BLUE);
    }

    @Override
    void nascondi() {

    }
}
