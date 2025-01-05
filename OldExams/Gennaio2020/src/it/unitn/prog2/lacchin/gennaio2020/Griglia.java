package it.unitn.prog2.lacchin.gennaio2020;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Griglia extends GridPane {

    int index = 0;
    ArrayList<Cella> grigie = null;
    EventHandler<MouseEvent> mouseHandler = null;
    ArrayList <Quadrato> quadrati = null;
    Sudoku root;
    //Griglia griglia = null;
    public Griglia (Sudoku root) {

        super();
        grigie = new ArrayList<>();
        quadrati = new ArrayList<>();
        this.root = root;
        //griglia = this;

        this.mouseHandler = mouseEvent -> {

            if(grigie.size()<Sudoku.N*Sudoku.N) {
                Cella c = (Cella) mouseEvent.getSource();
                if (c instanceof NonInizializzata) {

                    if(regola(c)) {
                        Fissa fissa = new Fissa(mouseHandler, this.root);
                        int i = GridPane.getRowIndex(c);
                        int j = GridPane.getColumnIndex(c);
                        this.getChildren().remove(c);
                        this.add(fissa, j, i);
                        fissa.removeEventHandler(MouseEvent.MOUSE_CLICKED, mouseHandler);
                        grigie.add(fissa);
                        root.number.setText(String.valueOf((Sudoku.N*Sudoku.N*Sudoku.N*Sudoku.N) - grigie.size()));
                    }
                    else
                        System.out.println("La regola non vale, scegliere un'altra casella o numero");

                }
                if(grigie.size() == Sudoku.N*Sudoku.N) {
                    riempiLibere();
                    root.definite.addAll(grigie);
                }
            }
            else {
              Cella c = (Cella) mouseEvent.getSource();
              if(c instanceof Libera) {
                  if(regola(c) && c.text.getText().equals("")) {
                      c.text.setText(String.valueOf(root.cb.getValue()));
                      root.definite.add(c);
                      root.number.setText(String.valueOf((Sudoku.N*Sudoku.N*Sudoku.N*Sudoku.N) - root.definite.size()));
                  }
                  else if (!c.text.getText().equals("")) {
                      c.text.setText("");
                      root.definite.remove(c);
                      root.number.setText(String.valueOf((Sudoku.N*Sudoku.N*Sudoku.N*Sudoku.N) - root.definite.size()));
                  }
              }
            }
            if(root.definite.size() == 81) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ESITO");
                alert.setHeaderText("MESSAGGIO");
                alert.setContentText("Hai vinto!");

            }
        };
        populate();


    }

    public void populate () {
        for (int i = 0; i  < Sudoku.N*Sudoku.N; i++) {
            for (int j = 0; j  < Sudoku.N*Sudoku.N; j++) {
                this.add(new NonInizializzata(this.mouseHandler,this.root),j,i);

            }
        }
    }

    public boolean regola (Cella c) {
        //dobbiamo controllare se vale la regola;
        boolean res = true;
        int limit;
        int i = GridPane.getRowIndex(c);
        int j = GridPane.getColumnIndex(c);
        String s = String.valueOf(root.cb.getValue());
        int k = 0;
        while (k < Sudoku.N * Sudoku.N && res) {

            Cella temp = (Cella) getElementAt(this, k, i);
            if (temp.text != null) {
                String t = temp.text.getText();
                if (t.equals(s) && temp != c) {

                    res = false;
                }
            }
            k++;
        }
        k = 0;
        while (k < Sudoku.N * Sudoku.N && res) {

            Cella temp = (Cella) getElementAt(this, j, k);
            if (temp.text != null) {
                String t = temp.text.getText();
                if (t.equals(s) && temp != c) {

                    res = false;
                }
            }
            k++;
        }

        //guardiamo tutti i vari quadrati prendendo sempre il centro

        if (Sudoku.N == 3) {
            if (res) {

                if (i < Sudoku.N && j < Sudoku.N) {

                    res = regolaQuadrato(1, 1, s, c);
                } else if (i < Sudoku.N && j <= ((Sudoku.N * 2) - 1))
                    res = regolaQuadrato(1, 4, s, c);
                else if (i < Sudoku.N && j <= ((Sudoku.N * Sudoku.N) - 1))
                    res = regolaQuadrato(1, 7, s, c);
                else if (i <= ((Sudoku.N * 2) - 1) && j < Sudoku.N)
                    res = regolaQuadrato(4, 1, s, c);
                else if (i <= ((Sudoku.N * 2) - 1) && j <= (Sudoku.N * 2) - 1) {
                    res = regolaQuadrato(4, 4, s, c);
                } else if (i <= ((Sudoku.N * 2) - 1) && j <= ((Sudoku.N * Sudoku.N) - 1))
                    res = regolaQuadrato(4, 7, s, c);
                else if (i <= ((Sudoku.N * Sudoku.N) - 1) && j < Sudoku.N)
                    res = regolaQuadrato(7, 1, s, c);
                else if (i < ((Sudoku.N * Sudoku.N) - 1) && j <= ((Sudoku.N * 2) - 1))
                    res = regolaQuadrato(7, 4, s, c);
                else if (i <= ((Sudoku.N * Sudoku.N) - 1) && j <= ((Sudoku.N * Sudoku.N) - 1))
                    res = regolaQuadrato(7, 7, s, c);
            }

            return res;
        }
        else {

        }


        return res;
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

    public boolean regolaQuadrato (int row, int column, String s, Cella c) {
        boolean res = true;
        for (int i = row-1; i <= row+1; i++) {
            for(int j = column - 1; j <= column+1;j++) {
                Cella temp = (Cella) getElementAt(this,j,i);
                if (temp == null)
                    System.out.println("what");
                if (!(temp.text == null)) {

                    String t = temp.text.getText();
                    if (t.equals(s) && temp != c) {

                        res = false;
                    }
                }
            }
        }
        return res;
    }
    public void riempiLibere () {
        int index2 = 1;
        int index1 = 1;
        for (int index = 1; index <= (Sudoku.N*Sudoku.N); index++) {

            if(index == 4 || index == 7)
                index1 = 1;

            if(index == 4 || index == 7)
                index2 +=1;
            for (int i = (Sudoku.N * (index1-1)); i < (Sudoku.N*(index1)); i++) {
                for (int j = (Sudoku.N * (index2-1)); j < (Sudoku.N * (index2)); j++) {
                    Cella temp = (Cella) getElementAt(this, j, i);
                    if (temp instanceof NonInizializzata) {
                        Libera libera = new Libera(this.mouseHandler, this.root);
                        libera.rectangle.setFill(Libera.COLORI[index-1]);
                        this.getChildren().remove(temp);
                        this.add(libera,j,i);
                    }
                }
            }
            ++index1;
        }
    }
    /*
    public boolean regolaQuadrati (String s, Cella c) {
        boolean res = true;
        int index2 = 1;
        int index1 = 1;
        for (int index = 1; index <= (Sudoku.N*Sudoku.N); index++) {

            if(index == 4 || index == 7)
                index1 = 1;

            if(index == 4 || index == 7)
                index2 +=1;
            for (int i = (Sudoku.N * (index1-1)); i < (Sudoku.N*(index1)); i++) {
                for (int j = (Sudoku.N * (index2-1)); j < (Sudoku.N * (index2)); j++) {
                    Cella temp = (Cella) getElementAt(this,j,i);
                    if (!(temp.text == null)) {

                        String t = temp.text.getText();
                        if (t.equals(s) && temp != c) {

                            res = false;
                        }
                    }
                }
            }
            ++index1;
        }
        return res;
    }

     */

}
