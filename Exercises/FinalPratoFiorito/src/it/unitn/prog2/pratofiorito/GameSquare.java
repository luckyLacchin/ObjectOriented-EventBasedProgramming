package it.unitn.prog2.pratofiorito;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GameSquare extends Button implements EventHandler<MouseEvent> {
    boolean bomb;
    boolean disabled;
    int bombNeighbors;
    int x, y;
    Main master;

    GameSquare(Main master, int x, int y){
        bomb = Math.random() < 1/7.3;
        this.master = master;
        this.x = x;
        this.y = y;
        disabled = false;
    }

    void setBombNeighbors(int n){
        if(!bomb)
            bombNeighbors = n;
        else
            bombNeighbors = -1;
    }

    void disable(){
        this.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
        disabled = true;
    }

    void showCounter(){
        this.setText(Integer.toString(bombNeighbors));
    }

    @Override
    public String toString(){
        return Integer.toString(bombNeighbors) + " " + Boolean.toString(bomb);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(bomb)
            master.gameOver();
        master.showBombCounters(x, y);
        master.checkWin();
    }
}
