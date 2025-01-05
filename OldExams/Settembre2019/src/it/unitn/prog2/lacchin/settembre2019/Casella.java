package it.unitn.prog2.lacchin.settembre2019;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

import javax.xml.stream.EventFilter;
import java.util.Objects;

public abstract class Casella extends BorderPane {

    Figura figura;
    Button cancella;
    Button random;
    Button faiCerchio;
    Button faiTriangolo;
    HBox bottoni;
    Casella app;
    EventHandler <ActionEvent> buttonHandler;

    static final int LATO = 25;

    public Casella () {
        cancella = new Button("C");
        cancella.setId("cancella");
        cancella.setPrefSize(Casella.LATO,Casella.LATO);
        bottoni = new HBox();
        bottoni.setAlignment(Pos.CENTER);
        app = this;
        buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = (Button) actionEvent.getSource();
                System.out.println(actionEvent.getTarget());
                Shape nuovaFigura;
                switch (button.getId()) {
                    case "cerchio":
                        figura = new Cerchio(app);
                        nuovaFigura = figura.getFigura();
                        break;
                    case "triangolo":
                        figura = new Triangolo(app);
                        nuovaFigura = figura.getFigura();
                        break;
                    case "cancella":
                        figura = new Vuoto(app);
                        nuovaFigura = figura.getFigura();
                        break;
                    case "random":
                        figura = randomFigura(app);
                        nuovaFigura = figura.getFigura();
                        break;
                    default:
                        System.out.println("Qualcosa è andato storto!");
                        nuovaFigura = null;

                }
                app.getChildren().clear();
                app.getChildren().addAll(nuovaFigura,bottoni);
            }
        };
        /*
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                figura = new Vuoto(app);
                app.getChildren().clear();
                app.getChildren().addAll(figura.getFigura(),bottoni);

            }
        });

         */


    }

    public Figura randomFigura (Casella app) {
        Figura random;
        int n = (int) (Math.random() * 2);
        switch(n) {
            case 0:
                random = new Cerchio(app);
                break;
            case 1:
                random = new Triangolo(app);
                break;
            default:
                System.out.println("Qualcosa è andato storto!");
                random = null;
        }
        return random;

    }


    @Override
    public int hashCode() {
        return Objects.hash(figura);
    }
}
