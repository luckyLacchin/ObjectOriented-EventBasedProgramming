package it.unitn.prog2.lacchin.febbraio2022;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Shift extends TextField {

    Shift app = null;
    Main ap = null;
    public Shift (Main ap) {
        this.ap = ap;
        this.setText("10");
        this.app = this;
        this.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String text = app.getText();
                for (char c: text.toCharArray()) {
                    if(!Character.isDigit(c)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("INFORMAZIONE");
                        alert.setHeaderText("Errore");
                        alert.setContentText("INSERIRE SOLO NUMERI NELLA TEXTFIELD");
                        alert.showAndWait();
                        app.clear();
                        app.setText("10");
                        ap.dx.requestFocus();
                    }
                }
            }
        });
    }

}
