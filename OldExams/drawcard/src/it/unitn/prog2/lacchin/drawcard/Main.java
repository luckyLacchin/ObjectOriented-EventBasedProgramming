package it.unitn.prog2.lacchin.drawcard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main extends Application {
    int index = 0;
    Text criterioText = null;
    Text hand = null;
    Text points = null;
    Text currentCard = null;
    Text drawCard = null;
    Card refer = null;
    int point = -1;

    @Override
    public void start(Stage primaryStage) {
        Deck myDeck = new Deck();

        /*myDeck.printDeck();
        myDeck.shuffleDeck();
        System.out.println();
        myDeck.printDeck();
        Collections.sort(myDeck);
        System.out.println("ciao");
        myDeck.printDeck();
        Collections.sort(myDeck,new OrderByValue());
        System.out.println("ciao2");
        myDeck.printDeck();
        System.out.println("ciao3");
        Collections.sort(myDeck,new OrderBySeed());
        myDeck.printDeck();
         */
        point = 3;
        myDeck.shuffleDeck();
        refer = myDeck.get(index);
        System.out.println(refer);
        BorderPane root = new BorderPane();

        HBox top = new HBox();
        VBox left = new VBox();
        VBox right = new VBox();
        ////////////////////////
        /*caratteriziamo vbox left*/
        left.setAlignment(Pos.CENTER);
        Text titleCurrentCard = new Text ("Carta Corrente");
        currentCard = new Text(""+refer+"");
        left.getChildren().addAll(titleCurrentCard,currentCard);
        ////////////////////////
        right.setAlignment(Pos.CENTER);
        Text titleDrawCard = new Text ("Carta Pescata");
        drawCard = new Text("");
        right.getChildren().addAll(titleDrawCard,drawCard);
        ////////////////////////
        top.setSpacing(20);
        top.getChildren().addAll(left,right);
        top.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(top,Pos.CENTER);

        Button gioca = new Button ("gioca");
        BorderPane.setAlignment(gioca,Pos.BOTTOM_CENTER);

        gioca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentCard.setText(""+refer+"");
                Comparator <Card> criterio = null;
                Random random = new Random();
                int choice = random.nextInt(2);
                if (choice==0) {
                    criterio = new OrderBySeed();
                    criterioText.setText("Criterio : ordinamento per seme");
                }
                else {
                    criterio = new OrderByValue();
                    criterioText.setText("Criterio : ordinamento per valore");
                }
                Card draw = myDeck.get(++index);
                drawCard.setText(""+draw+"");
                if (criterio.compare(refer,draw)>0) {
                    hand.setText("Mano persa");
                    point = point -1;

                }
                else if (criterio.compare(refer,draw)<0) {
                    hand.setText("Mano vinta");
                    point = point +1;
                }
                else {
                    hand.setText("Pareggio");
                }
                points.setText("Punti: "+point);
                refer = draw;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("GIOCO");
                alert.setContentText("Esito:");
                if (point == 0) {
                    alert.setContentText("HAI PERSO");
                    alert.showAndWait();
                    primaryStage.close();
                }
                if (point >= 6) {
                    alert.setContentText("HAI VINTO");
                    alert.showAndWait();
                    primaryStage.close();
                }
            }
        });




        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        hand = new Text("");
        points = new Text("Punti: "+point);
        criterioText = new Text("Criterio: ");
        center.getChildren().addAll(hand,points,criterioText);
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */
        ////////////////////////////////////
        root.setTop(top);
        root.setBottom(gioca);
        root.setCenter(center);
        ////////////////////////////////////
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Pesca la carta!");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}