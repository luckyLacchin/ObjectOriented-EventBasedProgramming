package esame0621.caselle;
public class BinarioDiritto extends Binario {
    public BinarioDiritto() {
        linea.setStartX(TOLERANCE);
        linea.setEndX(TILE_WIDTH- TOLERANCE);
        linea.setStartY(TILE_HALF_HEIGHT);
        linea.setEndY(TILE_HALF_HEIGHT);
        this.getChildren().add(linea);
    }
}
