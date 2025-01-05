package it.unitn.prog2.lacchin.picco_settembre2018;

import javafx.application.Application;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BlackJack extends Application {

    ArrayList <Card> plutoMano;
    ArrayList <Card> pippoMano;
    Mazzo deck;
    ArrayList <Button>  plutoButtons;
    ArrayList <Button> pippoButtons;
    BlackJack questo;
    ManoLayout layoutPluto;
    ManoLayout layoutPippo;
    boolean scartoPluto = false;
    boolean scartoPippo = false;
    @Override
    public void start(Stage primaryStage) {



        questo = this;

        deck = new Mazzo();
        System.out.println(deck);
        deck.mescola();
        System.out.println(deck);
        plutoMano = new Mano("Pluto", deck);

        pippoMano = new Mano("Pippo", deck);

        System.out.println(plutoMano);
        System.out.println(pippoMano);
        System.out.println(deck);


        BorderPane root = new BorderPane();

        Text pluto = new Text("PLUTO");
        Text pippo = new Text("PIPPO");
        pluto.setTextAlignment(TextAlignment.CENTER);
        pippo.setTextAlignment(TextAlignment.CENTER);



        Button pescaAvversarioPluto = new Button("Pesca dall'avversario");
        pescaAvversarioPluto.setId("pescaAvversarioPluto");
        Button pescaAvversarioPippo = new Button ("Pesca dell'avversario");
        pescaAvversarioPippo.setId("pescaAvversarioPippo");
        Button cercaCoppiePluto = new Button("Carca le coppie");
        Button cercaCoppiePippo = new Button("Carca le coppie");
        cercaCoppiePluto.setId("cercaCoppiePluto");
        cercaCoppiePippo.setId("cercaCoppiePippo");
        Button pescaMazzoPluto = new Button("Pesca dal mazzo");
        Button pescaMazzoPippo = new Button("Pesca dal mazzo");
        pescaMazzoPluto.setId("pescaMazzoPluto");
        pescaMazzoPippo.setId("pescaMazzoPippo");

        plutoButtons = new ArrayList<>();
        pippoButtons = new ArrayList<>();

        plutoButtons.add(pescaAvversarioPluto);
        plutoButtons.add(cercaCoppiePluto);
        plutoButtons.add(pescaMazzoPluto);

        pippoButtons.add(pescaAvversarioPippo);
        pippoButtons.add(cercaCoppiePippo);
        pippoButtons.add(pescaMazzoPippo);

        for (Button button : plutoButtons) {
            button.setDisable(true);
        }
        for (Button button : pippoButtons) {
            button.setDisable(true);
        }

        plutoButtons.get(0).setDisable(false);
        pippoButtons.get(0).setDisable(false);

        HBox topPluto = new HBox();
        HBox bottomPippo = new HBox();
        topPluto.setSpacing(20);
        bottomPippo.setSpacing(20);
        topPluto.getChildren().addAll(pluto,pescaAvversarioPluto,cercaCoppiePluto,pescaMazzoPluto);
        bottomPippo.getChildren().addAll(pippo,pescaAvversarioPippo,cercaCoppiePippo,pescaMazzoPippo);
        VBox top = new VBox();
        VBox bottom = new VBox();

        layoutPluto = new ManoLayout(plutoMano);

        layoutPippo = new ManoLayout(pippoMano);

        top.getChildren().addAll(topPluto,layoutPluto);
        bottom.getChildren().addAll(layoutPippo,bottomPippo);

        root.setTop(top);
        root.setBottom(bottom);


        EventHandler <ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button source = (Button) actionEvent.getSource();
                int index;
                Card card;
                Iterator<Node> x;
                ArrayList <Card> cloneList;
                Alert alert;

                switch (source.getId()) {

                    case "pescaAvversarioPluto":
                        index = (int) (Math.random() * pippoMano.size());
                        card = pippoMano.get(index);
                        x = layoutPippo.getChildren().iterator();
                        while (x.hasNext()) {
                            Cella cella = (Cella) x.next();
                            if (cella.card.seme.equals(card.seme) && cella.card.valore.equals(card.valore)) {
                                x.remove();
                                plutoMano.add(card);
                                pippoMano.remove(card);
                                Collections.sort(plutoMano);
                                layoutPluto = new ManoLayout(plutoMano);
                                top.getChildren().clear();
                                top.getChildren().addAll(topPluto,layoutPluto);

                            }
                        }
                        System.out.println(plutoMano);
                        break;
                    case "pescaAvversarioPippo":
                        index = (int) (Math.random() * plutoMano.size());
                        card = plutoMano.get(index);
                        x = layoutPluto.getChildren().iterator();
                        while (x.hasNext()) {
                            Cella cella = (Cella) x.next();
                            if (cella.card.seme.equals(card.seme) && cella.card.valore.equals(card.valore)) {
                                x.remove();
                                pippoMano.add(card);
                                plutoMano.remove(card);
                                Collections.sort(pippoMano);
                                layoutPippo = new ManoLayout(pippoMano);
                                bottom.getChildren().clear();
                                bottom.getChildren().addAll(layoutPippo,bottomPippo);


                            }
                        }
                        System.out.println(pippoMano);
                        break;

                    case "cercaCoppiePluto":
                        cloneList = (ArrayList<Card>) plutoMano.clone();
                        for (Card t : cloneList) {
                            for (Card s : cloneList) {
                                if (t.equals(s) && t!=s) {
                                    plutoMano.remove(t);
                                    plutoMano.remove(s);
                                    scartoPluto = true;
                                }
                            }
                        }
                        layoutPluto = new ManoLayout(plutoMano);
                        top.getChildren().clear();
                        top.getChildren().addAll(topPluto,layoutPluto);
                        System.out.println(plutoMano);
                        break;
                    case "cercaCoppiePippo":
                        cloneList = (ArrayList<Card>) pippoMano.clone();
                        for (Card t : cloneList) {
                            for (Card s : cloneList) {
                                if (t.equals(s) && t!=s) {
                                    pippoMano.remove(t);
                                    pippoMano.remove(s);
                                    scartoPippo = true;
                                }
                            }
                        }
                        layoutPippo = new ManoLayout(pippoMano);
                        bottom.getChildren().clear();
                        bottom.getChildren().addAll(layoutPippo,bottomPippo);
                        System.out.println(pippoMano);
                        break;

                    case "pescaMazzoPluto":
                        if (scartoPluto) {
                            System.out.println("Ho scartato, non pesco!");
                        }
                        else {
                            ArrayList <Card> cloneDeck = (ArrayList<Card>) deck.clone();
                            card = cloneDeck.get(0);
                            plutoMano.add(card);
                            deck.remove(card);
                            layoutPluto = new ManoLayout(plutoMano);
                            top.getChildren().clear();
                            top.getChildren().addAll(topPluto,layoutPluto);

                        }
                        System.out.println(plutoMano);
                        scartoPluto = false;
                        break;

                    case "pescaMazzoPippo":
                        if (scartoPippo) {
                            System.out.println("Ho scartato, non pesco!");
                        }
                        else {
                            ArrayList <Card> cloneDeck = (ArrayList<Card>) deck.clone();
                            card = cloneDeck.get(0);
                            pippoMano.add(card);
                            deck.remove(card);
                            layoutPippo = new ManoLayout(pippoMano);
                            bottom.getChildren().clear();
                            bottom.getChildren().addAll(layoutPippo,bottomPippo);

                        }
                        System.out.println(pippoMano);
                        scartoPippo = false;
                        break;



                }
                if (questo.plutoButtons.contains(source)) {
                    index = plutoButtons.indexOf(source);
                    index = (index+1)%3;
                    Button temp = plutoButtons.get(index);
                    temp.setDisable(false);
                }
                else if (questo.pippoButtons.contains(source)) {
                    index = pippoButtons.indexOf(source);
                    index = (index+1)%3;
                    Button temp = pippoButtons.get(index);
                    temp.setDisable(false);
                }
                source.setDisable(true);

                if (plutoMano.size()== 0) {
                    System.out.println("Il giocatore pluto ha vinto!");
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("MESSAGGIO");
                    alert.setHeaderText("ESITO");
                    alert.setContentText("Il giocatore pluto ha vinto!");
                }

                if (pippoMano.size()== 0) {
                    System.out.println("Il giocatore pippo ha vinto!");
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("MESSAGGIO");
                    alert.setHeaderText("ESITO");
                    alert.setContentText("Il giocatore pippo ha vinto!");
                    alert.showAndWait();
                }
            }

        };


        pescaAvversarioPluto.addEventHandler(ActionEvent.ACTION,eventHandler);
        pescaAvversarioPippo.addEventHandler(ActionEvent.ACTION,eventHandler);
        cercaCoppiePluto.addEventHandler(ActionEvent.ACTION,eventHandler);
        cercaCoppiePippo.addEventHandler(ActionEvent.ACTION,eventHandler);
        pescaMazzoPluto.addEventHandler(ActionEvent.ACTION,eventHandler);
        pescaMazzoPippo.addEventHandler(ActionEvent.ACTION,eventHandler);




        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}