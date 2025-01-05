package esame0621;

import esame0621.caselle.*;
import javafx.scene.layout.GridPane;

public class Palette extends GridPane {
    Matrice matrice=null;
    Palette(Matrice m){
        matrice=m;
    };
    void add(Casella c,int row, int col){
        c.setInPalette(matrice);
        super.add(c,row,col);
    }
    void popola(){
        this.add(new CasellaVuota(),0,0);
        this.add(new BinarioDiritto(),1,0);
        this.add(new BinarioCurvoD(),0,1);
        this.add(new BinarioCurvoA(),1,1);
        this.add(new BinarioCurvoC(),0,2);
        this.add(new BinarioCurvoB(),1,2);
        this.add(new ScambioD(),0,3);
        this.add(new ScambioA(),1,3);
        this.add(new ScambioC(),0,4);
        this.add(new ScambioB(),1,4);
    }
}
