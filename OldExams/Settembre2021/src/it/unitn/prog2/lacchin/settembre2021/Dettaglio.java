package it.unitn.prog2.lacchin.settembre2021;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Dettaglio extends Stage {

    BorderPane root;
    VBox bottom;
    Text title, prezzo, descrizioneText,tx1,tx2;
    ImageView iw;
    Shop shop;
    Dettaglio (Shop shop) {

        root = new BorderPane();
        this.shop = shop;
        Scene scene = new Scene(root,600,600);
        this.setTitle("Dettaglio");
        this.setScene(scene);


        this.setX(300);
        this.setY(325);

        this.show();

        this.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                shop.primaryStage.requestFocus();
                shop.fire(e.getCharacter());
            }
        });

    }

    public void riempiDettaglio (Prodotto prodotto) {

        root.getChildren().clear();
        bottom = new VBox();

        title = new Text(prodotto.nome);
        title.setFill(Color.RED);
        prezzo = new Text("Prezzo: " + prodotto.prezzo);
        descrizioneText = new Text("Descrizione: " + prodotto.descrizione);
        iw = new ImageView(prodotto.image);
        iw.setFitHeight(400.0);
        iw.setFitWidth(400.0);

        title.setFont(new Font(15));
        prezzo.setFont(new Font(15));
        descrizioneText.setFont(new Font(15));
        title.setStyle("-fx-font-weight: bold");
        prezzo.setStyle("-fx-font-weight: bold");
        descrizioneText.setStyle("-fx-font-weight: bold");

        bottom.setAlignment(Pos.BOTTOM_LEFT);
        bottom.getChildren().addAll(prezzo,descrizioneText);

        switch (prodotto.getClass().getName()) {
            case "it.unitn.prog2.lacchin.settembre2021.Rotabile":
                tx1 = new Text("Assi motori: " + ((Rotabile)prodotto).assiMotori);
                tx1.setFont(new Font(15));
                tx1.setStyle("-fx-font-weight: bold");
                bottom.getChildren().add(tx1);
                break;
            case "it.unitn.prog2.lacchin.settembre2021.Accessorio":
                tx1 = new Text("");
                if (((Accessorio)prodotto).luce) {
                    tx1.setText("Con luce");
                }
                else
                    tx1.setText("Senza luce");
                tx1.setFont(new Font(15));
                tx1.setStyle("-fx-font-weight: bold");
                bottom.getChildren().add(tx1);
                break;
            case "it.unitn.prog2.lacchin.settembre2021.Binario":
                tx1 = new Text("Lunghezza: " + ((Binario)prodotto).lunghezza);
                tx2 = new Text("Angolo: " + ((Binario)prodotto).angolo);
                tx1.setFont(new Font(15));
                tx2.setFont(new Font(15));
                tx1.setStyle("-fx-font-weight: bold");
                tx2.setStyle("-fx-font-weight: bold");
                bottom.getChildren().add(tx1);
                bottom.getChildren().add(tx2);
                break;
            default:
                System.out.println("C'è stato un problema");
        }
        BorderPane.setAlignment(bottom,Pos.BOTTOM_LEFT);
        BorderPane.setAlignment(iw,Pos.CENTER);
        BorderPane.setAlignment(title,Pos.TOP_CENTER);

        root.setTop(title);
        root.setCenter(iw);
        root.setBottom(bottom);
    }
}
