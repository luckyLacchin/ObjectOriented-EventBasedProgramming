package it.unitn.prog2.lacchin.febbraio2022;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;

public class Pannello extends Pane implements Cloneable {

    final static double WIDTH = 500;
    final static double HEIGHT = 500;
    ArrayList <Componente> lista = null;
    ArrayList <Componente> listaBlu = null;
    ArrayList <Componente> listaRed = null;
    public Pannello() {
        super();
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        populate();
    }


    public void populate () {
        //faccio prima per i rossi dopo i blu
        boolean dafare = false;
        lista = new ArrayList<>();
        listaBlu = new ArrayList<>();
        listaRed = new ArrayList<>();
        while (!dafare) {
            for (int i = 0; i < 3; i++) {
                Componente c = new Componente();
                c.doComponenteRed();
                this.getChildren().add(c);
                lista.add(c);
                listaBlu.add(c);
            }
            for (int i = 0; i < 3; i++) {
                Componente c = new Componente();
                c.doComponenteBlu();
                this.getChildren().add(c);
                lista.add(c);
                listaRed.add(c);
            }
            dafare = controlloPannello(50);

            if(dafare) {
                this.getChildren().clear();
                lista.clear();
                dafare = false;
            }
            else
                dafare = true;




        }

    }
    public boolean controlloPannello(double n) {
        n += Figura.BORDO;
        boolean dafare = false;
        for (Node temp1 : this.getChildren()) {
            Iterator<Node> x = this.getChildren().iterator();
            while(x.hasNext() && (!dafare)) {
                Node temp2 = x.next();
                //devo fare t.traslazioneX - s.traslazioneX < 50 - bordi*2 -> devo rifare tutto
                Componente t = (Componente) temp1;
                Componente s = (Componente) temp2;
                //avrei dovuto usare il teorema di pitagora!
                double dx = (t.traslazioneX)-(s.traslazioneX);
                double dy = (t.traslazioneY)-(s.traslazioneY);
                if ((t!=s) && (dx*dx+dy*dy<n*n)) {
                    dafare = true;

                }

                if ((((Pannello.WIDTH)-t.traslazioneX)<n) || (((Pannello.HEIGHT)-t.traslazioneY)<n) ||
                        (t.traslazioneX < n) || (t.traslazioneY < n)){
                    dafare = true;


                }

            }
        }
        return dafare;
    }


    @Override
    public Pannello clone() {
        try {
            Pannello clone = (Pannello) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public boolean collisione () {
        boolean collidono = false;
        double n = 30;
        n += Figura.BORDO;
        ArrayList <Componente> cloneLista = ((ArrayList<Componente>) lista.clone());
        for (Componente t : cloneLista) {
            Iterator<Componente> x = cloneLista.iterator();
            while (x.hasNext() && (!collidono)) {
                Componente s = x.next();
                //devo fare t.traslazioneX - s.traslazioneX < 50 - bordi*2 -> devo rifare tutto
                double dx = (t.traslazioneX)-(s.traslazioneX);
                double dy = (t.traslazioneY)-(s.traslazioneY);
                if ((t != s) && (dx*dx+dy*dy<n*n)) {
                    collidono = true;

                }
            }
        }
        return collidono;

    }
    public boolean controlloBordi () {
        boolean res = false;
        ArrayList <Componente> cloneLista = ((ArrayList<Componente>) lista.clone());
        for (Componente c : cloneLista) {

            if (c.fuoriDaiBordi()) {
                res = true;
                System.out.println("Una figura e' uscita dai bordi");
                this.lista.remove(c);
                this.getChildren().remove(c);

            }
        }
        return res;
    }
    public void sistemaPannello () {
        boolean collidono = false;
        double n = 30;
        n += Figura.BORDO;
        ArrayList <Componente> cloneLista = ((ArrayList<Componente>) lista.clone());
        for (Componente t : cloneLista) {
            Iterator<Componente> x = cloneLista.iterator();
            while(x.hasNext() && (!collidono)) {
                Componente k = x.next();

                double dx = (t.traslazioneX)-(k.traslazioneX);
                double dy = (t.traslazioneY)-(k.traslazioneY);
                if ((t != k) && (dx*dx+dy*dy<n*n)){
                    collidono = true;
                    this.lista.remove(t);
                    this.lista.remove(k);
                    this.getChildren().remove(t);
                    this.getChildren().remove(k);

                }
            }
        }
    }
}
