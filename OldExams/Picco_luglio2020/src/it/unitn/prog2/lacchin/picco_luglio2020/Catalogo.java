package it.unitn.prog2.lacchin.picco_luglio2020;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Catalogo extends ArrayList <Piastrella> {

    int indice;
    public Catalogo () {
        super();
        indice = 0;
        this.add(new Normale("P1","ceramica",50,50,false));
        this.add(new Normale("P2","laminato",20,80,true));
        this.add(new Normale("P3","ceramica",50,40,true));
        this.add(new Bicolore("B1","laminato",100,40,false,new Rectangle(LayoutPiastrella.LATO/2,LayoutPiastrella.LATO/2)));
        this.add(new Bicolore("B2","ceramica",120,90,true,new Circle(LayoutPiastrella.LATO/4)));
        this.add(new Bicolore("B3","terracotta",140,50,true,new Rectangle(LayoutPiastrella.LATO/2,LayoutPiastrella.LATO/2)));
    }
}
