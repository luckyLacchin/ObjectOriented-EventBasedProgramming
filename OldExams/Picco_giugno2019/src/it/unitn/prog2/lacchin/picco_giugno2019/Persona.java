package it.unitn.prog2.lacchin.picco_giugno2019;

public  class Persona {

    String nome,cognome,codiceFiscale,annoDiNascita;
    int anno,codice;
    double tariffa = -1;
    final int TOTALE = 1000;
    public Persona (String cognome, String nome,int codice,int anno) {

        this.nome = nome;
        this.cognome = cognome;
        this.anno = anno;
        this.annoDiNascita = String.valueOf(this.anno);
        this.codice = codice;
        this.codiceFiscale = String.valueOf(codice);

    }

    public void calcoloTariffa () {
        if (anno < 1968) {
            tariffa = TOTALE -TOTALE * 0.35;
        }
        else
            tariffa = 1000;
    }
}
