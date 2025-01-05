package esame0621.caselle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public abstract class Scambio extends BinarioDiritto {
    Line deviata =new Line();
    int colorDeviata=0;
    public Scambio() {
        deviata.setStrokeWidth(STROKEWIDTH);
        deviata.setStroke(color[colorDeviata]);
        this.getChildren().add(deviata);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double y=event.getY();
                //System.out.println(y);
                if (y<TILE_HALF_HEIGHT) {
                    colorDeviata=(colorDeviata + 1) % 2;
                    deviata.setStroke(color[colorDeviata]);
                } else {
                    colorLinea = (colorLinea + 1) % 2;
                    linea.setStroke(color[colorLinea]);
                }
            }
        });
    }
}
