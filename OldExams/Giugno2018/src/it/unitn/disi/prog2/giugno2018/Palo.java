package it.unitn.disi.prog2.giugno2018;

import it.unitn.disi.prog2.giugno2018.dischi.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.ArrayList;

public class Palo extends StackPane {

    static final double WIDTH = 10.0;
    static final double HEIGHT = 100.0;
    static final Color BLACK = Color.BLACK;
    Rectangle palo;
    VBox dischi;
    Hanoi app;
    Palo questo;
    ArrayList<Disco> arrayDischi;


    public Palo (Hanoi app) {
        super();
        this.app = app;
        questo = this;
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setPrefSize(100.0, HEIGHT);
        palo = new Rectangle(WIDTH,HEIGHT);
        palo.setFill(BLACK);
        this.getChildren().addAll(palo);
        arrayDischi = new ArrayList<>();

        setMargin(palo, new Insets(20,20,20,20));

        EventHandler <MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (dischi == null &&  app.destinazione == null && app.partenza == null) {
                    System.out.println("Il palo di partenza non puo' essere vuoto!");
                    app.stage = new StagePopUp("Il palo di partenza non puo' essere vuoto!");
                    app.stage.show();
                    app.close.setDisable(false);

                }
                else if (dischi != null && app.destinazione == null && app.partenza == null){
                    app.partenza = questo;
                    app.from.setText("from " + app.partenza.getId());
                    System.out.println("Il palo di partenza e'" + app.partenza.getId());
                    app.stage = new StagePopUp("Il palo di partenza e'" + app.partenza.getId());
                    app.stage.show();
                    app.close.setDisable(false);
                }
                else if (app.partenza != null && app.destinazione == null) {
                    if (questo == app.partenza) {
                        System.out.println("Il palo di destinazione e di partenza non possono coincidere!");
                        app.stage = new StagePopUp("Il palo di destinazione e di partenza non possono coincidere!");
                        app.stage.show();
                        app.close.setDisable(false);
                    }
                    else {
                        app.destinazione = questo;
                        app.to.setText("from " + app.destinazione.getId());
                        System.out.println("Il palo di destinazione e'" + app.destinazione.getId());
                        app.stage = new StagePopUp("Il palo di destinazione e'" + app.destinazione.getId());
                        app.stage.show();
                        app.close.setDisable(false);

                    }
                }
                else if (app.partenza != null && app.destinazione != null) {
                    System.out.println("Il palo di partenza e quello di destinazione sono gia' definiti");
                    app.stage = new StagePopUp("Il palo di partenza e quello di destinazione sono gia' definiti");
                    app.stage.show();
                    app.close.setDisable(false);
                }
            }

        };

        this.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);
    }


    public void setVbox () {
        dischi = new VBox();
        dischi.setAlignment(Pos.BOTTOM_CENTER);
        setMargin(dischi, new Insets(20,20,20,20));
        this.getChildren().add(dischi);
    }

}
