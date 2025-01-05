package it.unitn.prog2.lacchin;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class mostraStage extends Stage {


    public mostraStage (Griglia griglia) {

        GridPane root = new GridPane();
        Cella cella = null;
        //potrei usare clone, ma invece posso anche non usarlo!
        for (int i = 0; i < griglia.play.N; i++) {
            for (int j = 0; j < griglia.play.N; j++) {
                switch (griglia.matrix[i][j].getClass().getName()) {
                    case "it.unitn.prog2.lacchin.CellaP":
                        cella = new CellaP(griglia);
                        break;
                    case "it.unitn.prog2.lacchin.CellaS":
                        cella = new CellaS(griglia);
                        break;
                    case "it.unitn.prog2.lacchin.CellaV":
                        cella = new CellaV(griglia);
                        break;
                    default:
                        System.out.println("Qualcosa è andato storto!");


                }
                cella.testo.setText(griglia.matrix[i][j].testo.getText());
                cella.getChildren().remove(cella.foreground);
                cella.removeEventHandler(MouseEvent.MOUSE_CLICKED,cella.mouseHandler);
                root.add(cella,j,i);

            }
        }


        Scene scene = new Scene(root,500,500);
        this.setScene(scene);

    }
}
