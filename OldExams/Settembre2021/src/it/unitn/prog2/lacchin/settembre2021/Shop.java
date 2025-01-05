package it.unitn.prog2.lacchin.settembre2021;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Shop extends Application {

    ArrayList<Prodotto> rotabiliList;
    ArrayList <Prodotto> binariList;
    ArrayList <Prodotto> accessoriList;
    Dettaglio dettaglioStage;
    Vetrina vetrinaStage;
    Stage primaryStage;
    Button rotabiliButton;
    Button binariButton;
    Button accessoriButton;

    @Override
    public void start(Stage primaryStage) {

        rotabiliList = new ArrayList<>();
        binariList = new ArrayList<>();
        accessoriList = new ArrayList<>();

        dettaglioStage = new Dettaglio(this);
        vetrinaStage = new Vetrina(this);
        this.primaryStage = primaryStage;
        riempiRotabiliList();
        riempiBinariList();
        riempiaccessoriList();

        HBox root = new HBox();

        rotabiliButton = new Button("Rotabili");
        rotabiliButton.setId("rotabili");
        binariButton = new Button("Binari");
        binariButton.setId("binari");
        accessoriButton = new Button("Accessori");
        accessoriButton.setId("accessori");

        root.getChildren().addAll(rotabiliButton,binariButton,accessoriButton);
        root.setSpacing(20.0);

        primaryStage.setX(70);
        primaryStage.setY(100);


        EventHandler <ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = (Button) actionEvent.getTarget();

                switch (button.getId()) {
                    case "rotabili":
                        vetrinaStage.riempiVetrina(rotabiliList);
                        break;
                    case "binari":
                        vetrinaStage.riempiVetrina(binariList);
                        break;
                    case "accessori":
                        vetrinaStage.riempiVetrina(accessoriList);
                        break;
                    default:
                        System.out.println("Qualcosa è andato storto!");
                }
            }
        };

        rotabiliButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        binariButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        accessoriButton.addEventHandler(ActionEvent.ACTION,buttonHandler);


        Scene scene = new Scene(root, 220, 30);
        primaryStage.setTitle("Shop di Gabriele Lacchin");
        primaryStage.setScene(scene);

        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                fire(e.getCharacter());
            }
        });

        dettaglioStage.show();
        vetrinaStage.show();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void riempiRotabiliList () {
        rotabiliList.add(new Rotabile("Locomotiva",new Image("it/unitn/prog2/lacchin/settembre2021/img/locomotiva.jpg",200,200,true,true),50,"Blah Blah",3));
        rotabiliList.add(new Rotabile("Vagone passeggeri",new Image("it/unitn/prog2/lacchin/settembre2021/img/vagonePasseggeri.jpg",200,200,true,true),20,"Blah Blah",0));
        rotabiliList.add(new Rotabile("Vagone merci",new Image("it/unitn/prog2/lacchin/settembre2021/img/vagoneMerci.jpg",200,200,true,true),10,"Blah Blah",0));

    }

    public void riempiBinariList () {
        binariList.add(new Binario("Binario Diritto",new Image("it/unitn/prog2/lacchin/settembre2021/img/binarioDiritto.jpg",200,200,true,true),2,"Blah Blah",12,0));
        binariList.add(new Binario("Binario Curvo",new Image("it/unitn/prog2/lacchin/settembre2021/img/BinarioCurvo.jpg",200,200,true,true),3,"Blah Blah",15,30));
        binariList.add(new Binario("Scambio Destro",new Image("it/unitn/prog2/lacchin/settembre2021/img/ScambioDestro.jpg",200,200,true,true),10,"Blah Blah",12,15));


    }

    public void riempiaccessoriList () {
        accessoriList.add(new Accessorio("Stazione",new Image("it/unitn/prog2/lacchin/settembre2021/img/stazione.jpg",200,200,true,true),30,"Blah Blah",true));
        accessoriList.add(new Accessorio("Ponte",new Image("it/unitn/prog2/lacchin/settembre2021/img/ponte.jpg",200,200,true,true),20,"Blah Blah",false));
        accessoriList.add(new Accessorio("Castello",new Image("it/unitn/prog2/lacchin/settembre2021/img/castello.jpg",200,200,true,true),25,"Blah Blah",false));
    }

    public void fire (String e) {
        switch (e) {
            case "A":
            case "a":
                accessoriButton.fire();
                break;
            case "b":
            case "B":
                binariButton.fire();
                break;
            case "r":
            case "R":
                rotabiliButton.fire();
                break;
            default:
                System.out.println("Qualcosa è andato storto!");
        }
    }

}