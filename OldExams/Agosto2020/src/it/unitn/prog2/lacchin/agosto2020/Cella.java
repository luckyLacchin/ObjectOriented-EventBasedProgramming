package it.unitn.prog2.lacchin.agosto2020;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Objects;

public class Cella extends StackPane implements Cloneable {

    final static Color COLOR =  Color.BLUE;
    final static Color [] BORDO = {Color.YELLOW,Color.ORANGE};
    final static int WIDTH = 100;
    final static int HEIGHT = 90;
    final static int RADIUS = 20;
    final static int RADIUS_EX = 30;
    EventHandler <MouseEvent> mouseHandler = null;


    final static String [] LETTERE = {"A","B","C","D","E","F"};
    static int indexLettere = 0;

    final static String [] NUMERI = {"0","1","2","3","4","5"};
    static int indexNumeri;

    static boolean secondo1 = false;
    static boolean secondo2 = false;
    Text text = null;
    Shape figura = null;
    Shape background = null;
    Shape foreground = null;
    Shape celletta = null;
    int index = 0;
    Cella app = null;
    Griglia griglia = null;
    public Cella (int index, Griglia griglia) {


        app = this;
        this.griglia = griglia;
        this.index = index;
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        this.setBorder(Border.stroke(Color.BLACK));
        celletta = new Rectangle(WIDTH,HEIGHT);
        celletta.setFill(Color.WHITE);
        /*System.out.println("indexNumeri = " + indexNumeri);
        System.out.println(indexLettere);

         */
        if (index == 24) {
            text = new Text("K.O.");
            text.setFill(Color.RED);
            background = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
            background.setFill(COLOR);
            //System.out.println("ultima cella");
            foreground = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
            foreground.setFill(COLOR);
            this.getChildren().addAll(celletta,background,text,foreground);
        }
        else if((index%4)==0) {
            figura = new Rectangle(RADIUS*2,RADIUS*2);
            text = new Text(NUMERI[indexNumeri]);
            text.setFill(Color.WHITE);
            background = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
            background.setFill(BORDO[0]);
            foreground = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
            foreground.setFill(COLOR);
            this.getChildren().addAll(celletta,background,figura,text,foreground);
            figura.setFill(COLOR);
            if (!secondo1) {
                secondo1 = true;
            }
            else {
                secondo1 = false;
                ++indexNumeri;
            }
        }
        else if ((index%4)==2) {
            figura = new Circle(RADIUS);
            text = new Text(LETTERE[indexLettere]);
            text.setFill(Color.WHITE);
            background = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
            background.setFill(BORDO[0]);
            foreground = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
            foreground.setFill(COLOR);
            figura.setFill(COLOR);
            this.getChildren().addAll(celletta,background,figura,text,foreground);
            if (!secondo2) {
                secondo2 = true;
            }
            else {
                secondo2 = false;
                ++indexLettere;
            }
        }
        else
            System.out.println("Indice non valido");

        mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                /*System.out.println(griglia.lista);
                System.out.println(griglia.scoperte);

                 */
                if (!app.text.getText().equals("K.O.")) {
                    app.getChildren().remove(app.foreground);
                    griglia.coperte.remove(app);
                    griglia.scoperte.add(app);
                    Cella source = ((Cella) mouseEvent.getSource());
                    //qua non credo serva usare un iterator perché non vado a modificare la lista, ma vabbè lo uso
                    //per imparare ad usarlo!
                    ArrayList <Cella> cloneScoperte = ((ArrayList<Cella>) griglia.scoperte.clone());
                    for (Cella c : cloneScoperte) {
                        if (source.equals(c) && (c != source)) {
                            source.background.setFill(BORDO[1]);
                            c.background.setFill(BORDO[1]);
                            source.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
                            c.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
                            griglia.congelate.add(c);
                            griglia.congelate.add(source);
                            griglia.scoperte.remove(c);
                            griglia.scoperte.remove(source);
                        }
                    }
                    if(griglia.scoperte.size()==3) {
                        Cella t = griglia.scoperte.get(0);
                        Cella s = griglia.scoperte.get(1);
                        griglia.scoperte.remove(t);
                        griglia.scoperte.remove(s);
                        t.foreground.setFill(COLOR);
                        s.foreground.setFill(COLOR);
                        t.getChildren().add(t.foreground);
                        s.getChildren().add(s.foreground);
                        griglia.coperte.add(t);
                        griglia.coperte.add(s);
                    }


                    if(griglia.congelate.size() == 24) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("MESSAGE");
                        alert.setHeaderText("MESSAGE");
                        alert.setContentText("HAI VINTO!");
                        alert.showAndWait();
                        griglia.app.close();
                    }

                }
                else {
                    app.getChildren().remove(app.foreground);
                    griglia.coperte.remove(app);
                    griglia.scoperte.add(app);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("MESSAGE");
                    alert.setHeaderText("MESSAGE");
                    alert.setContentText("HAI PERSO!");
                    alert.showAndWait();
                    griglia.app.close();
                }
                app.griglia.main.punti = griglia.lista.size() - app.griglia.congelate.size() -1;
                app.griglia.main.punteggio.setText(String.valueOf(app.griglia.main.punti));
            }
        };

        this.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cella cella = (Cella) o;
        if (this.text.getText().equals(cella.text.getText()) && this.figura.getClass().getName().equals(cella.figura.getClass().getName()))
            return true;
        else
            return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(text, figura);
    }
    /*
    @Override
    public Cella clone() {
        try {

            Cella clone = (Cella) super.clone();
            clone.getChildren().clear();
            clone.figura = null;
            clone.background = null;
            clone.foreground = null;
            clone.text = null;

            if((this.index%4)==0) {
                clone.figura = new Rectangle(RADIUS*2,RADIUS*2);
                clone.text = new Text(NUMERI[indexNumeri++]);
                clone.text.setFill(Color.WHITE);
                clone.background = new Rectangle();
                clone.foreground = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
                clone.foreground.setFill(COLOR);

                clone.getChildren().addAll(clone.background,clone.figura,clone.text,clone.foreground);
            }
            else if ((this.index%4)==2) {
                clone.figura = new Circle(RADIUS);
                clone.text = new Text(NUMERI[indexLettere++]);
                clone.text.setFill(Color.WHITE);
                clone.background = new Rectangle();
                clone.foreground = new Rectangle(RADIUS_EX*2,RADIUS_EX*2);
                clone.foreground.setFill(COLOR);

                clone.getChildren().addAll(clone.background,clone.figura,clone.text,clone.foreground);
            }

            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

     */
}
