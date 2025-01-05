package esame0621.caselle;
public class BinarioCurvoB extends Binario {
    public BinarioCurvoB() {
        linea.setStartX(TILE_HALF_WIDTH+TOLERANCE);
        linea.setEndX(TILE_WIDTH-TOLERANCE);
        linea.setEndY(TILE_HALF_HEIGHT);
        linea.setStartY(TILE_HEIGHT-TOLERANCE);
        this.getChildren().add(linea);
    }
}
