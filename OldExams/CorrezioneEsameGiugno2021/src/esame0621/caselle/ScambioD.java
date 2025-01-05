package esame0621.caselle;
public class ScambioD extends Scambio {

    public ScambioD() {
        deviata.setStartX(TOLERANCE);
        deviata.setEndX(TILE_HALF_WIDTH-TOLERANCE);
        deviata.setStartY(TILE_HALF_HEIGHT);
        deviata.setEndY(TOLERANCE);
    }
}
