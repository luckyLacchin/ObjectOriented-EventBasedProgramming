package esame0621.caselle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public abstract class Binario extends Casella {
    static final int STROKEWIDTH=3;
    static final int TOLERANCE=1;
    static final Color color[]={Color.BLACK,Color.RED};
    Line linea =new Line();
    int colorLinea =0;

    public Binario() {
        box.setFill(Color.WHITESMOKE);
        linea.setStrokeWidth(STROKEWIDTH);
        linea.setStroke(color[colorLinea]);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double y = event.getY();
                colorLinea = (colorLinea + 1) % 2;
                linea.setStroke(color[colorLinea]);
            }
        });
    }
}