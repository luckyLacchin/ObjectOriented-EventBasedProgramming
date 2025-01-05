package esame0621.caselle;
public class ScambioA extends Scambio {

    public ScambioA() {
        deviata.setStartX(TILE_HALF_WIDTH);
        deviata.setEndX(TILE_WIDTH-TOLERANCE);
        deviata.setStartY(TOLERANCE);
        deviata.setEndY(TILE_HALF_HEIGHT);
    }
}
