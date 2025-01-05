package esame0621;

import esame0621.caselle.Casella;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane root = new BorderPane();
    private Matrice matrice = new Matrice();
    private HBox bottoni = new HBox();

    @Override
    public void start(Stage primaryStage) throws Exception {
        prepareAndShowMainWindow(primaryStage);
        prepareAndShowPalette();
    }
    /**
     * Bottoni e relativa shortcut da tastiera
     */
    private void setupBottoni() {
        Button test = new Button("TEST");
        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                matrice.populate();
            }
        });
        Button reset = new Button("Reset");
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                matrice.reset();
            }
        });
        root.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String c = event.getCharacter();
                if (c.equals("r") || c.equals("R")) {
                    reset.fire();
                }
            }
        });
        bottoni.getChildren().addAll(test, reset);
    }

    private void prepareAndShowMainWindow(Stage primaryStage) {
        System.out.println(matrice);
        setupBottoni();
        matrice.reset();
        root.setCenter(matrice);
        root.setBottom(bottoni);
        primaryStage.setTitle("ACEI");
        primaryStage.setScene(new Scene(root, Casella.TILE_WIDTH * 4, Casella.TILE_HEIGHT * 4 + 30));
        primaryStage.setX(300);
        primaryStage.setY(300);
        primaryStage.show();
    }

    private void prepareAndShowPalette() {
        System.out.println(matrice);
        Palette palette = new Palette(matrice);
        palette.popola();
        Stage paletteStage = new Stage();
        paletteStage.setTitle("Palette");
        paletteStage.setScene(new Scene(palette, Casella.TILE_WIDTH * 2, Casella.TILE_HEIGHT * 5));
        paletteStage.setX(750);
        paletteStage.setY(300);
        paletteStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
