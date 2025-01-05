package it.unitn.disi.prog2.lacchin;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class Main extends Application {
    int n1,n2,result;
    @Override
    public void start(Stage primaryStage) {
        boolean corretto = false;
        TextInputDialog f1 = new TextInputDialog("");
        f1.setTitle("Calcolatrice");
        f1.setHeaderText("Inserimento numeri");
        f1.setContentText("Numero:");
        while (!corretto) {
            String stringa1 = f1.showAndWait().get();
            try {
                n1 = Integer.parseInt(stringa1);
                corretto = true;
            } catch (Exception e) {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Schermata errore");
                alert.setHeaderText("Inserire un numero!");
                alert.showAndWait();
                //System.out.println("Inserire un numero!");
                f1.getEditor().clear();

            }
        }
        corretto = false;
        TextInputDialog f2 = new TextInputDialog("");
        f2.setTitle("Calcolatrice");
        f2.setHeaderText("Inserimento numeri");
        f2.setContentText("Numero:");
        while (!corretto) {
            String stringa2 = f2.showAndWait().get();
            try {
                n2 = Integer.parseInt(stringa2);
                corretto = true;
            } catch (Exception e) {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Schermata errore");
                alert.setHeaderText("Inserire un numero!");
                alert.showAndWait();
                f2.getEditor().clear();
            }
        }
        HBox layout = new HBox();
        Button b1 = new Button ("+");
        Button b2 = new Button ("*");
        ListenerSum a = new ListenerSum ();
        ListenerProd b = new ListenerProd ();
        b1.addEventHandler(ActionEvent.ACTION,a);
        b2.addEventHandler(ActionEvent.ACTION,b);
        layout.getChildren().add(b1);
        layout.getChildren().add(b2);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(100);
        Scene scene = new Scene (layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show ();

    }
    class ListenerSum implements EventHandler {


        @Override
        public void handle(Event event) {
            result = n1+n2;
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Schermata finale");
            alert.setHeaderText("Risultato: ");
            alert.setContentText(""+result);
            alert.showAndWait();
        }
    }
    class ListenerProd implements EventHandler {
        @Override
        public void handle(Event event) {
            result = n1*n2;
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Schermata finale");
            alert.setHeaderText("Risultato: ");
            alert.setContentText(""+result);
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*dai facciamo anche i catch, così nel caso in cui avessimo problemi, nell'inserimento del numero ce lo pija"


 */