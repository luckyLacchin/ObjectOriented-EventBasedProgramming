package esame0621.caselle;
public class BinarioCurvoD extends Binario {
    public BinarioCurvoD() {
        linea.setStartX(TOLERANCE);
        linea.setEndX(TILE_HALF_WIDTH-TOLERANCE);
        linea.setStartY(TILE_HALF_HEIGHT);
        linea.setEndY(TOLERANCE);
        this.getChildren().add(linea);
    }
}
