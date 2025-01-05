package esame0621.caselle;
public class ScambioC extends Scambio {

    public ScambioC() {
        deviata.setStartX(TOLERANCE);
        deviata.setEndX(TILE_HALF_WIDTH-TOLERANCE);
        deviata.setStartY(TILE_HALF_HEIGHT);
        deviata.setEndY(TILE_HEIGHT-TOLERANCE);
    }
}
