package it.unitn.prog2.lacchin.picco_giugno2019;

public class StudenteSolo extends Persona{

    String uni, corso;
    public StudenteSolo(String cognome, String nome, int codice, int anno, String uni, String corso) {
        super(cognome, nome,codice, anno);
        this.uni = uni;
        this.corso = corso;

    }

    @Override
    public void calcoloTariffa() {
        switch (corso) {
            case "LT":
                tariffa = TOTALE - TOTALE * 0.40;
                break;
            case "LM":
                if (this.anno < 1968)
                    super.calcoloTariffa();
                else
                    tariffa = TOTALE - TOTALE * 0.20;
                break;
            default:
                System.out.println("Qualcosa è andato storto!");
        }
    }
}
