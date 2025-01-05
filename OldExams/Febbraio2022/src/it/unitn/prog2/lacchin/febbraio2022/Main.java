package it.unitn.prog2.lacchin.febbraio2022;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Iterator;

public class Main extends Application {
    Shift shift = null;
    Text punteggio = null;
    int val = 500;
    Button dx = null;
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Pannello pannello = new Pannello();
        shift = new Shift(this);

        EventHandler <ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String id = ((Button)actionEvent.getSource()).getId();
                String s = shift.getText();
                int shift = Integer.parseInt(s);
                switch (id) {
                    case "dx":
                        for (Node temp: pannello.getChildren()) {
                            Componente c = (Componente) temp;
                            if (c.getFig() instanceof Blu) {
                                temp.setTranslateX(temp.getTranslateX() + shift);
                                Componente t = (Componente) temp;
                                t.traslazioneX = temp.getTranslateX();
                            }
                        }
                        break;
                    case "sx":
                        for (Node temp: pannello.getChildren()) {
                            Componente c = (Componente) temp;
                            if (c.getFig() instanceof Blu) {
                                temp.setTranslateX(temp.getTranslateX() - shift);
                                Componente t = (Componente) temp;
                                t.traslazioneX = temp.getTranslateX();
                            }
                        }
                        break;
                    case "su":
                        for (Node temp: pannello.getChildren()) {
                            Componente c = (Componente) temp;
                            if (c.getFig() instanceof Blu) {
                                temp.setTranslateY(temp.getTranslateY() - shift);
                                Componente t = (Componente) temp;
                                t.traslazioneY = temp.getTranslateY();
                            }
                        }
                        break;
                    case "giu":

                        for (Node temp: pannello.getChildren()) {
                            Componente c = (Componente) temp;
                            if (c.getFig() instanceof Blu) {
                                temp.setTranslateY(temp.getTranslateY() + shift);
                                Componente t = (Componente) temp;
                                t.traslazioneY = temp.getTranslateY();
                            }
                        }
                        break;
                    default:
                        System.out.println("E' stato inserito un valore non valido");
                }
                val = val - 5;
                punteggio.setText("Punteggio: "+val);
                if(pannello.controlloBordi()) {
                    System.out.println("Fuori dai bordi");
                    val = val - 50;
                    punteggio.setText("Punteggio: "+val);
                }
                /*if(pannello.collisione()) {
                    System.out.println("collisione");
                    boolean collidono = false;
                    val = val +100;
                    punteggio.setText("Punteggio: "+val);
                    for (Node temp1 : pannello.getChildren()) {
                        Iterator<Node> x = pannello.getChildren().iterator();
                        while(x.hasNext() && (!collidono)) {
                            Node temp2 = x.next();

                            Componente t = (Componente) temp1;
                            Componente k = (Componente) temp2;
                            if ((t!=k) && ((Math.abs((t.traslazioneX-Figura.BORDO)-(k.traslazioneX-Figura.BORDO))<30.0)
                                    ||(Math.abs((t.traslazioneY-Figura.BORDO)-(k.traslazioneY-Figura.BORDO))<30.0))) {
                                        collidono = true;
                                        pannello.lista.remove(t);
                                        pannello.lista.remove(k);
                                        pannello.getChildren().remove(t);
                                        pannello.getChildren().remove(k);

                            }
                        }
                    }
                }

                 */
                if(pannello.collisione()) {
                    System.out.println("collisione");
                    val = val +100;
                    punteggio.setText("Punteggio: "+val);
                    pannello.sistemaPannello();
                }



            }
        };
        HBox bottoni = new HBox();
        dx = new Button("Destra");
        Button su = new Button("Su");
        Button giu = new Button("Giù");
        Button sx = new Button("Sinistra");
        dx.setId("dx");
        sx.setId("sx");
        su.setId("su");
        giu.setId("giu");
        punteggio = new Text("Punteggio: 500");
        dx.addEventHandler(ActionEvent.ACTION,buttonHandler);
        sx.addEventHandler(ActionEvent.ACTION,buttonHandler);
        giu.addEventHandler(ActionEvent.ACTION,buttonHandler);
        su.addEventHandler(ActionEvent.ACTION,buttonHandler);
        bottoni.getChildren().addAll(shift,punteggio,dx,sx,su,giu);
        root.setCenter(pannello);
        root.setBottom(bottoni);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch (e.getCharacter()) {
                    case "A":
                        for (Node temp : pannello.listaBlu) {
                            Figura figura = ((Componente)temp).getFig();
                            if (figura.lettera.equals("A")) {
                                temp.setTranslateX(temp.getTranslateX()+20);
                                ((Componente)temp).traslazioneX += 20;
                            }
                        }
                        break;
                    case "B":
                        for (Node temp : pannello.listaBlu) {
                            Figura figura = ((Componente)temp).getFig();
                            if (figura.lettera.equals("B")) {
                                temp.setTranslateX(temp.getTranslateX()+20);
                                ((Componente)temp).traslazioneX += 20;
                            }
                        }
                        break;
                    case "C":
                        for (Node temp : pannello.listaBlu) {
                            Figura figura = ((Componente)temp).getFig();
                            if (figura.lettera.equals("C")) {
                                temp.setTranslateX(temp.getTranslateX()+20);
                                ((Componente)temp).traslazioneX += 20;
                            }
                        }
                        break;
                    default:
                        System.out.println("E' stato inserito un valore non valido");
                }
                val = val - 5;
                punteggio.setText("Punteggio: "+val);
                if(pannello.controlloBordi()) {
                    System.out.println("Fuori dai bordi");
                    val = val - 50;
                    punteggio.setText("Punteggio: "+val);
                }
                if(pannello.collisione()) {
                    System.out.println("collisione");
                    val = val +100;
                    punteggio.setText("Punteggio: "+val);
                    pannello.sistemaPannello();
                }

            }
        });
        dx.requestFocus();
        primaryStage.setTitle("Gioca");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}