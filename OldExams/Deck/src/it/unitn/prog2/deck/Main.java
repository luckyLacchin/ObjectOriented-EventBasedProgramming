package it.unitn.prog2.deck;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Card cardDoppia = null;
        Deck myDeck = new Deck ();
        myDeck.setDeck();
        //myDeck.printDeck();
        //System.out.println();
        myDeck.shuffleDeck();
       /* myDeck.printDeck();
        System.out.println();
        System.out.println("ciao");*/
        myDeck.printDeckN(10);
        boolean eDoppia = myDeck.eDoppia(10);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMAZIONI");
        alert.setHeaderText("Sono presenti doppie nelle prime n carte?");
        if (eDoppia == true) {
            cardDoppia = myDeck.eDoppiaCard(10);
            int index = (int) (Math.random() * myDeck.size());
            Card temp = myDeck.get(index);
            if (cardDoppia.equals(temp)) {
                alert.setContentText("HAI VINTO DOPPIO");
            }
            else
                alert.setContentText("HAI VINTO");
        }
        else
            alert.setContentText("HAI PERSO");
        alert.showAndWait();

    }
    public static void main(String[] args) {
        launch(args);
    }
}