package it.unitn.prog2.lacchin.giugno2022;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.Collections;

public class TextFieldNonEditable extends TextField {

    GiocaStage app;
    public TextFieldNonEditable (GiocaStage app) {
        super();
        this.app = app;
        this.setEditable(false);

        EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                Collections.sort(app.estratti,new OrdPerCapitale());
                String capitale;
                EventTarget t = e.getTarget();
                //System.out.println(t);
                if(t instanceof TextFieldNonEditable) {
                    TextFieldNonEditable target = (TextFieldNonEditable) e.getTarget();
                    switch (e.getCharacter()) {
                        case "0":
                            capitale = app.estratti.get(0).capitale;
                            target.setText(capitale);
                            break;
                        case "1":
                            capitale = app.estratti.get(1).capitale;
                            target.setText(capitale);
                            break;
                        case "2":
                            capitale = app.estratti.get(2).capitale;
                            target.setText(capitale);
                            break;
                        default:
                            System.out.println("Inserire un numero compreso tra 0 e 2, gli altri tasti non sono validi!");
                    }
                }

            }
        };

        this.addEventHandler(KeyEvent.KEY_TYPED,keyHandler);
    }
}
