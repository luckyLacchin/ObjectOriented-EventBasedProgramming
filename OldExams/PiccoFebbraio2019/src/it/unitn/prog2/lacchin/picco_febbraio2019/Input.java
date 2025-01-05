package it.unitn.prog2.lacchin.picco_febbraio2019;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public abstract class Input extends Stage {

    BorderPane root;
    Text tx1;
    Text tx2;
    Text tx3;
    Button controlla;
    HBox top;
    VBox vb1, vb2;
    TextField field1,field2,field3;
    Catalogo main;
    Input stage;
    public Input(Catalogo main) {
        super();
        this.main = main;
        stage = this;
        BorderPane root = new BorderPane();
        tx1 = new Text ("");
        tx2 = new Text("");
        tx3 = new Text("");
        vb1 = new VBox();
        vb2 = new VBox();
        top = new HBox();


        field1 = new TextField();
        field2 = new TextField();
        field3 = new TextField();


        tx1.setTextAlignment(TextAlignment.CENTER);
        tx2.setTextAlignment(TextAlignment.CENTER);
        tx3.setTextAlignment(TextAlignment.CENTER);

        vb1.getChildren().addAll(tx1,tx2,tx3);
        vb2.getChildren().addAll(field1,field2,field3);
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);
        top.setSpacing(30);
        top.setAlignment(Pos.CENTER);
        top.getChildren().addAll (vb1, vb2);

        controlla = new Button ("controlla e inserisci");


        BorderPane.setAlignment (controlla, Pos.BOTTOM_LEFT);
        BorderPane.setAlignment (top,Pos.TOP_CENTER);

        root.setTop(top);
        root.setBottom(controlla);


        Scene scene = new Scene(root, 350, 400);
        this.setTitle("");
        this.setScene(scene);
        this.show();

    }

    public abstract boolean equivalenti (Record s);
}
