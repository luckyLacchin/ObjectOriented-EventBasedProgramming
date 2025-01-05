package it.unitn.prog2.lacchin.gennaio2020;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Sudoku extends Application {

    static int N;
    static final int WIDTH = 500;
    static final int HEIGHT = 500;
    ChoiceBox <Number> cb = null;
    Text valore = null;
    ArrayList<Cella> definite = null;
    Text number = null;

    @Override
    public void start(Stage primaryStage) {

        boolean inserire = true;
        boolean trovato = true;
        definite = new ArrayList<>();
        while (inserire) {
            TextInputDialog dialog = new TextInputDialog("Inserire valore n");
            dialog.setTitle("INFORMAZIONE");
            dialog.setHeaderText("SUDOKU");
            dialog.setContentText("Answer label:");
            String s = dialog.showAndWait().get();
            try {
                N = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Inserire un valore valido.");
                trovato = false;
            }
            if (trovato) {
                if (N != 3 && N != 2) {
                    System.out.println("Inserire o 2 o 3.");
                    trovato = false;
                }
            }
            if (trovato)
                inserire = false;
            else
                trovato = true;


        }

        if (trovato && inserire==false) {
            BorderPane root = new BorderPane();

            Griglia griglia = new Griglia(this);

            HBox bottom = new HBox();
            cb = new ChoiceBox<>();
            valore = new Text("valore");
            Text celleLibere = new Text("Celle libere");
            number = new Text(String.valueOf(N * N * N * N));
            bottom.getChildren().addAll(valore, cb, celleLibere, number);
            bottom.setAlignment(Pos.CENTER);
            bottom.setSpacing(20.0);


            cb.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9); // lista ordinata dei valori possibili
            cb.setValue(1); // valore mostrato


            root.setCenter(griglia);
            root.setBottom(bottom);

            Scene scene = new Scene(root, 500, 525);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}