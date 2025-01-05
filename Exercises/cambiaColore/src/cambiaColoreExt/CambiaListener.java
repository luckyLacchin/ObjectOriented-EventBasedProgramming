package cambiaColoreExt;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class CambiaListener implements EventHandler <ActionEvent> {

    private Self s;
    public CambiaListener (Self se) {
        s = se;
    }
    @Override
    public void handle(ActionEvent event) {

        s.changeColor();
    }
}
