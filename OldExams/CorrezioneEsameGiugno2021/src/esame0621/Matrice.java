package esame0621;

import esame0621.caselle.*;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Matrice extends GridPane {
    /**
     * genera componenti random per la matrice
     */
    void populate() {
        for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
            for (int rowIndex = 0; rowIndex < 1; rowIndex++) {
                this.add(getRandomComponent(), columnIndex, rowIndex);
            }
        }
        //listCells(); // for debugging purposes
    }

    void reset() {
        for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
            for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
                this.add(new CasellaVuota(), columnIndex, rowIndex);
            }
        }
        //listCells(); // for debugging purposes
    }
    // ottieni una componente a caso
    Casella getRandomComponent() {
        Random r = new Random();
        Casella b = null;
        int type = r.nextInt(3);
        switch (type) {
            case 0:
                b = new BinarioDiritto();
                break;
            case 1:
                b = new ScambioA();
                break;
            case 2:
                b = new BinarioCurvoC();
                break;
        }
        return b;
    }

    void listCells() { // for debugging purposes only
        for (Node x : getChildren()) {
            int rowIndex = GridPane.getRowIndex(x);
            int columnIndex= GridPane.getColumnIndex(x);
            System.out.println("cell " + rowIndex + " " + columnIndex + " " + x);
        }
    }

    public void replaceCells(String className) {
        //cerca tutte le caselle vuote grigie e tienile in una lista di appoggio
        List<Node> nodelist=new LinkedList<>();
        for (Node x : getChildren()) {
            if ((x instanceof CasellaVuota) && ((CasellaVuota) x).isGray()) {
                    nodelist.add(x);
            }
        }
        // prendi tutte le caselle trovate e rimpiazzale con una nuova istanza del tipo desiderato
        for (Node x :nodelist) {
            int rowIndex = GridPane.getRowIndex(x);
            int columnIndex = GridPane.getColumnIndex(x);
            System.out.println("cell " + rowIndex + " " + columnIndex + " " + x);
            this.getChildren().remove(x);
            System.out.println("replacing " + rowIndex + " " + columnIndex);
            addCellByClassName(columnIndex, rowIndex, className);
        }
        // la lista di appoggio ora esce dallo scope, quindi non servirebbe svuotarla, ma lo facciamo comunque
        nodelist.clear();
    }

    /**
     * aggiungi una cella alla matrice
     * @param rowIndex  row index
     * @param columnIndex column index
     * @param className nome della classe della cella desiderata
     */
    void addCellByClassName(int rowIndex, int columnIndex, String className) {
        Casella c = null;
        try {
            // questo si potrebbe fare con uno switch/case, ma così è più elegante
            c = (Casella) (Class.forName(className).newInstance());
        } catch (Exception e) {
            System.out.println(e);
        }
        this.add(c, rowIndex, columnIndex);
    }
}
