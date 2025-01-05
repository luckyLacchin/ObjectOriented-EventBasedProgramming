package it.unitn.prog2.lacchin.changecolor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class changeListener implements EventHandler<ActionEvent> {
    MainEsterne app = null;
    changeListener (MainEsterne app) {
        this.app = app;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Figura temp = app.arrayFigures.get(app.index);
        temp.change();
        if (app.right)
            app.index +=1;
        else
            app.index -= 1;
        if (app.index == 3)
            app.index = 0;
        if (app.index < 0)
            app.index = 2;
    }
}
