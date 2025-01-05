package it.unitn.prog2.lacchin.giugno2021;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import jdk.jfr.Event;

public class Palette extends Stage {

    GridPane root = null;
    EventHandler <MouseEvent> mouseEventt = null;
    public Palette () {
        super ();
        this.populate();
    }
    public void populate () {
        root = new GridPane();
        mouseEventt = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Node temp = (Node) mouseEvent.getSource();
                Line ops = null;
                Class<?> classe = temp.getClass();
                String name = classe.getName();
                switch (name) {
                    case "it.unitn.prog2.lacchin.giugno2021.Diritto":
                        System.out.println(name);
                        break;
                    case "it.unitn.prog2.lacchin.giugno2021.CurvaC":
                        System.out.println(name);
                        break;
                    case "it.unitn.prog2.lacchin.giugno2021.ScambioC":
                        System.out.println(name);
                        break;
                    case "it.unitn.prog2.lacchin.giugno2021.Vuoto":
                        System.out.println(name);
                        break;
                    default:
                        //System.out.println("E' stata inserita una classe non valida!");
                        break;

                }
                if (!(temp instanceof Vuoto)) {
                    GridPane newgriglia = new GridPane();
                    int i = 0;
                    int j = 0;
                    for (Node t : root.getChildren()) {
                        if (t instanceof Vuoto) {
                            if (temp instanceof Diritto)
                                t = new Diritto(mouseEventt);
                            else if (temp instanceof CurvaA)
                                t = new CurvaA(mouseEventt);
                            else if (temp instanceof CurvaB)
                                t = new CurvaB(mouseEventt);
                            else if (temp instanceof CurvaC)
                                t = new CurvaC(mouseEventt);
                            else if (temp instanceof CurvaD)
                                t = new CurvaD(mouseEventt);
                            else if (temp instanceof ScambioA)
                                t = new ScambioA(mouseEventt);
                            else if (temp instanceof ScambioB)
                                t = new ScambioB(mouseEventt);
                            else if (temp instanceof ScambioC)
                                t = new ScambioC(mouseEventt);
                            else if (temp instanceof ScambioD)
                                t = new ScambioD(mouseEventt);

                        }
                        newgriglia.add(t, j++, i);
                        if (j == 2) {
                            ++i;
                            j = 0;
                        }
                    }
                    root = newgriglia;

                }
            }
        };


        Casella[] caselle = {new Vuoto(mouseEventt), new Diritto(mouseEventt), new CurvaA(mouseEventt),
                new CurvaB(mouseEventt), new CurvaC(mouseEventt), new CurvaD(mouseEventt), new ScambioA(mouseEventt),
                new ScambioB(mouseEventt), new ScambioC(mouseEventt), new ScambioD(mouseEventt)};
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                root.add(caselle[index++], i, j);
            }
        }
        Scene scene = new Scene (root,200,150);
        this.setTitle("Palette");
        this.setScene(scene);
    }

}
//sto impazzendo vediamo come ha fatto il prof la soluzione