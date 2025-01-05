

package it.unitn.prog2.lacchin.gennaio2020;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Quadrato extends GridPane {
/*
    static final int LATO =  Sudoku.HEIGHT/(Sudoku.N); //grandezza di un lato di uno dei 9
    //quadrati (di colore diverso) che vanno a formare la mia griglia
    static final  Color [] COLORI = {Color. LIGHTYELLOW, Color.LIGHTPINK, Color.LIGHTSTEELBLUE,
            Color.LIGHTSTEELBLUE, Color.LIGHTGREEN, Color.LIGHTBLUE, Color.LIGHTSALMON,
            Color.LAVENDER, Color.BISQUE, Color.HONEYDEW};

    static final double STROKEWIDTH = 3.0;
    int index = 0;
    EventHandler<MouseEvent> mouseHandler = null;

    public Quadrato (int index, EventHandler<MouseEvent> mouseHandler) {
        super();
        this.mouseHandler = mouseHandler;
        this.index = index;
        populateQuadrato();




    }

    public void populateQuadrato () {
        for (int i = 0; i < Sudoku.N;i++) {
            for(int j = 0; j < Sudoku.N;j++) {
                Cella c = new NonInizializzata(this.mouseHandler,this.index);
                this.add(c,j,i);
                //Sudoku.generale.add(c,(this.index*3)+j,(this.index*3)+i);
            }
        }
    }
    Node getElementAt(GridPane p, int i, int j) {
        for (Node x : p.getChildren()) {
            if ((GridPane.getColumnIndex(x) != null && GridPane.getColumnIndex(x) == i)
                    && (GridPane.getRowIndex(x) != null && GridPane.getRowIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }

    public void removeElement () {

    }

    boolean contains (Cella c) {
        boolean res = false;
        for (int i = 0; i < Sudoku.N;i++) {
            for (int j = 0; j < Sudoku.N; j++) {

            }
        }
        return false;

    }

 */

}
