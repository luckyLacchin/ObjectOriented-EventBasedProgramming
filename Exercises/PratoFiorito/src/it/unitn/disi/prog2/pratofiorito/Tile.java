package it.unitn.disi.prog2.pratofiorito;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Tile extends Button {

    private boolean bomba;

    public void setBomba(boolean val) {
        if (val)
            bomba = true;
        else
            bomba = false;
    }

    public boolean getBomba() {
        return bomba;
    }
}
