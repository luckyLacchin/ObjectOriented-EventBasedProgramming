package it.unitn.prog2.lacchin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    boolean somma = false;
    boolean prodotto = false;
    public String estrazione (String stringa) {
        String res = null;
        boolean secondaStringa = false;
        if (stringa.contains("+"))
            somma = true;
        else if (stringa.contains("*"))
            prodotto = true;
        else
            System.out.println("E' stata inserita una stringa non valida.");
        if (somma) {
            if (!secondaStringa) {
                res = stringa.substring(0, stringa.indexOf('+'));
                secondaStringa = true;
            }
            else {
                res = stringa.substring(stringa.indexOf('+')+1,stringa.length()-1);
            }
        }
        if (prodotto) {
            if (!secondaStringa) {
                res = stringa.substring(0, stringa.indexOf('*'));
                secondaStringa = true;
            }
            else {
                res = stringa.substring(stringa.indexOf('*')+1,stringa.length()-1);
            }
        }
        return res;
    }
    @Override

    public void start(Stage primaryStage) {
        int result = 0;
        TextInputDialog f1 = new TextInputDialog();
        f1.setTitle("Calcolatrice");
        f1.setHeaderText("Inserimento calcolo");
        f1.setContentText("Operazione:");
        String stringa1 = f1.showAndWait().get();
        String op1 = estrazione(stringa1);
        String op2 = estrazione (stringa1);
        int n1 = Integer.parseInt(op1);
        int n2 = Integer.parseInt(op2);
        if (somma) {
            result = n1+n2;
        }
        else if (prodotto) {
            result = n1*n2;
        }
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Schermata finale");
        alert.setHeaderText("Risultato: ");
        alert.setContentText(""+result);
        alert.showAndWait();

    }

    public static void main(String[] args) {
        launch(args);
    }
}