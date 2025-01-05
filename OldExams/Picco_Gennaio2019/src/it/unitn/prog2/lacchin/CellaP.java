package it.unitn.prog2.lacchin;

public class CellaP extends Cella{

    public CellaP (Griglia griglia) {
        super(griglia);
        testo.setText("P");
    }

    @Override
    void scopri() {
        System.out.println("Peccato, hai perso!");
        griglia.play.comunicazioneStage = new ComunicazioneStage(false,griglia.play.primaryStage);
        griglia.play.comunicazioneStage.show();

    }

    @Override
    void nascondi() {

    }
}
