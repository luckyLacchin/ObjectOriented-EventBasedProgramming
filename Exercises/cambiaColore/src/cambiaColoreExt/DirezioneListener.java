package cambiaColoreExt;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DirezioneListener implements EventHandler <ActionEvent> {

    private Self s;
    public DirezioneListener (Self se) {
        s = se;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        s.changeVerse();
    }
}
