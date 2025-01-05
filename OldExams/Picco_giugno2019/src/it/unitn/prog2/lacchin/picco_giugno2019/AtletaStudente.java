package it.unitn.prog2.lacchin.picco_giugno2019;

public class AtletaStudente extends StudenteSolo{

    String disciplina, rilevanza;
    public AtletaStudente(String cognome, String nome, int codice, int anno, String uni, String corso, String disciplina, String rilevanza) {
        super(cognome, nome, codice, anno, uni, corso);
        this.disciplina = disciplina;
        this.rilevanza = rilevanza;
    }

    @Override
    public void calcoloTariffa() {

        if (rilevanza.equals("internazionale")) {
            tariffa = TOTALE -TOTALE * 0.5;
        }
        else if (corso.equals("LT")) {
            super.calcoloTariffa();
        }
        else if (rilevanza.equals("nazionale")) {
            tariffa = TOTALE -TOTALE * 0.3;
        }
        else if (corso.equals("LM")) {
            super.calcoloTariffa();
        }



    }
}
