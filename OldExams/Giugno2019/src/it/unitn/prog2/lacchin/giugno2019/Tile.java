package it.unitn.prog2.lacchin.giugno2019;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Tile extends StackPane implements Comparable {

    static final double RADIUS = 25.0;
    Shape figura;
    int numero;
    Text testo;
    Color color;
    Color stroke;
    Stack stack;
    EventHandler <MouseEvent> eventHandler;

    public Tile (Stack stack) {
        super();
        this.stack = stack;
        color = new Color (Math.random(), Math.random(), Math.random(),1);
        stroke = Color.BLACK; //potrei anche qua mettere un calore completamente casuale, ma metto nero così sono sicuro che il numero sia ben visibile!
        testo = new Text();
        numero = (int) (Math.random() * 10);
        testo.setText(String.valueOf(numero));
        testo.setFill(stroke);

        EventHandler <MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Tile source = (Tile) mouseEvent.getSource();

                switch (source.getClass().getName()) {
                    case "it.unitn.prog2.lacchin.giugno2019.CircleTile" -> {
                        ++source.numero;
                        if (source.numero == 10)
                            source.numero = 0;
                        source.testo.setText(String.valueOf(source.numero));
                    }
                    case "it.unitn.prog2.lacchin.giugno2019.SquareTile" -> {
                        --source.numero;
                        if (source.numero < 0)
                            source.numero = 9; //numero = 10+source.numero;
                        source.testo.setText(String.valueOf(source.numero));
                    }
                    default -> System.out.println("Qualcosa è andato storto!");
                }
                if (!stack.controllo(source)) {
                    Tile equivalente = stack.cercaEquivalente(source);
                    stack.lista.remove(equivalente);
                    stack.lista.remove(source);
                    stack.equivalenti.add(equivalente);
                    stack.equivalenti.add(source);
                    stack.main.bottom.getChildren().clear();
                    stack.main.bottom.getChildren().addAll(stack.equivalenti);
                    equivalente.removeEventHandler(MouseEvent.MOUSE_CLICKED,equivalente.eventHandler);
                    source.removeEventHandler(MouseEvent.MOUSE_CLICKED,source.eventHandler);
                    stack.getChildren().clear();
                    stack.getChildren().addAll(stack.lista);

                }
                else {
                    int index = stack.lista.indexOf(source);
                    System.out.println(stack.lista);
                    ArrayList<Tile> clone = (ArrayList <Tile>) stack.lista.clone();
                    if (source instanceof SquareTile) {
                        clone.set(0,source);
                        for (int i = 1; i < stack.lista.size(); i++) {
                            if (i  <= index)
                                clone.set(i,stack.lista.get(i-1));
                            else
                                clone.set(i,stack.lista.get(i));
                        }
                    }
                    else {
                        clone.set(stack.lista.size()-1,source);
                        for (int i = 0; i < stack.lista.size()-1; i++) {
                            if (i  < index)
                                clone.set(i,stack.lista.get(i));
                            else
                                clone.set(i,stack.lista.get(i+1));
                        }
                    }

                    stack.lista = clone;
                    System.out.println(stack.lista);
                    stack.getChildren().clear();
                    stack.getChildren().addAll(stack.lista);
                }
            }
        };
        this.eventHandler = mouseHandler;
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);
    }


    public boolean equivalenti(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return numero == tile.numero; //il fatto che siano della stessa classe è già controllato nella condizione precendete!
    }

    @Override
    public int compareTo(Object o){
        if (!(o instanceof Tile)) System.exit(1);
        if (this.equals(o)) return 0;
        if (numero < ((Tile) o).numero) return -1;
        return 1;
    }



}
