package esame0621.caselle;
public class ScambioB extends Scambio {

    public ScambioB() {
        deviata.setStartX(TILE_HALF_WIDTH+TOLERANCE);
        deviata.setEndX(TILE_WIDTH-TOLERANCE);
        deviata.setEndY(TILE_HALF_HEIGHT);
        deviata.setStartY(TILE_HEIGHT-TOLERANCE);
    }
}
