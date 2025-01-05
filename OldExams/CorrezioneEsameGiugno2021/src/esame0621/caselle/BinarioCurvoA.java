package esame0621.caselle;
public class BinarioCurvoA extends Binario {
    public BinarioCurvoA() {
        linea.setStartX(TILE_HALF_WIDTH+TOLERANCE);
        linea.setEndX(TILE_WIDTH-TOLERANCE);
        linea.setStartY(TOLERANCE);
        linea.setEndY(TILE_HALF_HEIGHT);
        this.getChildren().add(linea);
    }
}
