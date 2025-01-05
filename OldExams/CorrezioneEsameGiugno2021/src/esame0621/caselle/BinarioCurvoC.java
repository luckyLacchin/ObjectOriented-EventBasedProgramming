package esame0621.caselle;
public class BinarioCurvoC extends Binario {
    public BinarioCurvoC() {
        linea.setStartX(TOLERANCE);
        linea.setEndX(TILE_HALF_WIDTH-TOLERANCE);
        linea.setStartY(TILE_HALF_HEIGHT);
        linea.setEndY(TILE_HEIGHT-TOLERANCE);
        this.getChildren().add(linea);
    }
}
