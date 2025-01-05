package it.unitn.prog2.lacchin.luglio2022;

import it.unitn.prog2.lacchin.luglio2022.Appartamenti.*;
import it.unitn.prog2.lacchin.luglio2022.Hotel.*;
import it.unitn.prog2.lacchin.luglio2022.Pensioni.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main extends Application {

    ArrayList<Alloggio> lista = null;
    VBox primo = null;
    VBox secondo = null;
    VBox terzo = null;
    VBox quarto = null;
    Text nomiText = null;
    Text prezziText = null;
    Text valutazioneText = null;
    Text extraText = null;
    ImageView below = null;
    BorderPane root = null;
    HBox figure = null;
    EventHandler <MouseEvent> mouseHandler = null;
    @Override
    public void start(Stage primaryStage) {

        mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int index = 0;
                Testo source = ((Testo)mouseEvent.getSource());
                String text = source.text;
                Iterator <Alloggio> x = lista.iterator();
                boolean trovato = false;
                while(!trovato && x.hasNext()) {
                    if(x.next().nome.equals(text))  {
                        trovato = true;
                        below = null;
                        below = lista.get(index).iw;
                        root.setBottom(below);
                    }
                    ++index;
                }
                if(!trovato) {
                    System.out.println("Nome non trovato!");
                }
            }
        };
        EventHandler <ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button temp = (Button)actionEvent.getSource();
                switch (temp.getId()) {
                    case "nome" -> Collections.sort(lista, new OrdPerNome());
                    case "prezzo" -> Collections.sort(lista, new OrdPerPrezzo());
                    case "valutazione" -> Collections.sort(lista, new OrdPerValutazione());
                    default -> System.out.println("Qualcosa è andato storto");
                }
                primo.getChildren().clear();
                secondo.getChildren().clear();
                terzo.getChildren().clear();
                quarto.getChildren().clear();
                below = null;
                RiempiPrimo();
                RiempiSecondo();
                RiempiTerzo();
                RiempiQuarto();
                below = lista.get(0).iw;
                root.setBottom(below);

            }
        };
        root = new BorderPane();
        lista = new ArrayList<>();
        Riempilista();
        ///////////////////////////
        HBox top = new HBox();
        top.setSpacing(95.0);
        HBox primaParte = new HBox();
        HBox secondaParte = new HBox();
        secondaParte.setSpacing(10);
        Button nomeButton = new Button("Nome");
        nomeButton.setId("nome");
        Button prezzoButton = new Button("Prezzo");
        prezzoButton.setId("prezzo");
        Button valutazioneButton = new Button("Valutazione");
        valutazioneButton.setId("valutazione");
        nomeButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        prezzoButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        valutazioneButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        primaParte.getChildren().add(nomeButton);
        secondaParte.getChildren().addAll(prezzoButton,valutazioneButton);
        top.getChildren().addAll(primaParte,secondaParte);
        //////////////////////////////
        HBox center = new HBox();
        center.setSpacing(90.0);
        primo = new VBox();
        secondo = new VBox();
        terzo = new VBox();
        quarto = new VBox();
        RiempiPrimo();
        RiempiSecondo();
        RiempiTerzo();
        center.getChildren().addAll(primo,secondo,terzo,quarto);
        RiempiQuarto();

        below = lista.get(0).iw;


        /////////////////////////////////
        root.setTop(top);
        root.setCenter(center);
        root.setBottom(below);

        ///////////////////////
        Scene scene = new Scene(root, 500, 520);
        primaryStage.setTitle("Gabriele Lacchin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void Riempilista () {
        lista.add(new Alpenhof());
        lista.add(new Artemide());
        lista.add(new Belste());
        lista.add(new Gruber());
        lista.add(new Majestic());
        lista.add(new Palace());
        lista.add(new PietraBianca());
        lista.add(new SaporeDiSale());
        lista.add(new TenutaDiArtimino());
        lista.add(new Zenith());
    }
    public void RiempiPrimo () {

        int index = 0;
        Iterator<Alloggio> temp = lista.iterator();
        while(index < 5) {
            primo.getChildren().add(new Testo(mouseHandler,temp.next().nome));
            ++index;
        }
    }
    public void RiempiSecondo () {

        int index = 0;
        Iterator<Alloggio> temp = lista.iterator();
        while(index < 5) {
            secondo.getChildren().add(new Text(String.valueOf(temp.next().prezzo)));
            ++index;
        }
    }
    public void RiempiTerzo () {

        int index = 0;
        Iterator<Alloggio> temp = lista.iterator();
        while(index < 5) {
            terzo.getChildren().add(new Text(String.valueOf(temp.next().valutazione)));
            ++index;
        }
    }
    public void RiempiQuarto () {
        int index = 0;
        Iterator<Alloggio> temp = lista.iterator();
        while(index < 5) {
            Alloggio t = temp.next();
            if (t instanceof Pensione) {
                quarto.getChildren().add(new Text(((Pensione)t).extra));
            }
            else if (t instanceof Albergo) {
                figure = new HBox();
                figure.setAlignment(Pos.CENTER);
                for (Stella stella : ((Albergo) t).stelline) {
                    figure.getChildren().add(stella);
                }
                quarto.getChildren().add(figure);
            }
            else if (t instanceof Appartamento) {
                quarto.getChildren().add(new Text("max. Persone:" + String.valueOf(((Appartamento)t).persone)));
            }
            ++index;
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}