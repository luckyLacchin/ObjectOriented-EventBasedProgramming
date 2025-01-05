package it.unitn.prog2.lacchin.picco_giugno2019;

public class AtletaSolo extends Persona{

    String disciplina, rilevanza;
    public AtletaSolo(String cognome, String nome, int codice, int anno, String disciplina, String rilevanza) {
        super(cognome, nome, codice, anno);
        this.disciplina = disciplina;
        this.rilevanza = rilevanza;
    }

    @Override
    public void calcoloTariffa() {
        switch (rilevanza) {
            case "internazionale":
                tariffa = TOTALE -TOTALE * 0.5;
                break;
            case "nazionale":
                if (anno < 1968)
                    super.calcoloTariffa();
                else
                    tariffa = TOTALE -TOTALE * 0.3;
                break;
            default:
                System.out.println("Qualcosa è andato storto!");
        }
    }
}
