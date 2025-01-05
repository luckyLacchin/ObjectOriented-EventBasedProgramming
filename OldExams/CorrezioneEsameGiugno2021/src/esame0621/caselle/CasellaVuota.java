package esame0621.caselle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class CasellaVuota extends Casella {
    static final Color coloreCasella[]={Color.WHITE,Color.GRAY};
    int coloreCasellaVuota=0;
    public CasellaVuota() {
        Casella questa=this;
        box.setFill(coloreCasella[coloreCasellaVuota]);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double y = event.getY();
                coloreCasellaVuota = (coloreCasellaVuota + 1) % 2;
                box.setFill(coloreCasella[coloreCasellaVuota]);
            }
        });
    }
    public boolean isGray() {return coloreCasellaVuota==1;}
}