package it.unitn.prog2.lacchin;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;
public class InputDialog {
    static String getResponse () {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Dimensione della griglia?");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) return result.get();
        return null;
    }
}
