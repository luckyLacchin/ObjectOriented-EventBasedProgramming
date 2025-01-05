package it.unitn.prog2.lacchin;

public class CellaS extends Cella{

    int valore;
    public CellaS(Griglia griglia) {
        super(griglia);
        do {
            valore = (int) (Math.random() * 10);
        }while (valore == 0);
        testo.setText(String.valueOf(valore));
    }

    @Override
    void scopri() {
        griglia.play.punti += valore;
        griglia.play.gestisciPunti();
    }

    @Override
    void nascondi() {
        griglia.play.punti -= valore;
        griglia.play.gestisciPunti();
    }
}
