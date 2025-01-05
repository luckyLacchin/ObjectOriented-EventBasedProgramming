package it.unitn.prog2.pratofiorito;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    final int SQUARES_SIDE = 8;
    final int SQUARES_SIZE = 10;

    ArrayList<GameSquare> squares;

    @Override
    public void start(Stage primaryStage) {
        squares = new ArrayList<>();
        GridPane root = new GridPane();

        for(int i=0; i<SQUARES_SIDE*SQUARES_SIDE; i++){
            GameSquare s = new GameSquare(this,i/SQUARES_SIDE, i%SQUARES_SIDE);
            root.add(s, i/SQUARES_SIDE, i%SQUARES_SIDE);
            squares.add(s);
            s.addEventHandler(MouseEvent.MOUSE_CLICKED, s);
        }

        setBombCounters();

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setTitle("Prato fiorito");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void gameOver(){
        System.out.println("Hai perso");
        disableAll();
    }

    void disableAll(){
        for(GameSquare s : squares)
            s.disable();
    }

    void setBombCounters(){
        // per ogni cella (i, j)
        for(int i=0; i<SQUARES_SIDE; i++){
            for(int j=0; j<SQUARES_SIDE; j++){
                int bombs = 0;
                for(int x=i-1; x<=i+1; x++){
                    for(int y=j-1; y<=j+1; y++){
                        // se non sono sulla cella di cui devo cercare i vicini
                        // e quella cella è valida (non è una coordinata tipo -1, -1)
                        // e c'è una bomba allora aumento il numero di bombe della cella (i, j)
                        if(!(x == i && y == j) && isValid(x, y) && squares.get(x*SQUARES_SIDE+y).bomb){
                            bombs++;
                        }
                    }
                }
                squares.get(i*SQUARES_SIDE+j).setBombNeighbors(bombs);
            }
        }
    }

    void showBombCounters(int i, int j){
        GameSquare clickedElement = squares.get(i*SQUARES_SIDE+j);

        clickedElement.showCounter();
        clickedElement.disable();

        if(clickedElement.bombNeighbors == 0)
            for(int x=i-1; x<=i+1; x++){
                for(int y=j-1; y<=j+1; y++){
                    if(!(x==i && y==j) && isValid(x, y)){
                        GameSquare s = squares.get(x*SQUARES_SIDE+y);
                        if(!s.disabled){
                            s.showCounter();
                            if(s.bombNeighbors == 0)
                                showBombCounters(x, y);
                        }
                    }
                }
            }
    }

    void checkWin(){
        boolean win = true;
        for(int i=0; i<SQUARES_SIDE*SQUARES_SIDE; i++){
            //TODO: prbabililbibibmentte non vengono disabilitati
            if(!squares.get(i).bomb && !squares.get(i).disabled) {
                System.out.println(i);
                win = false;
            }
        }
        System.out.println("----");
        if(win){
            System.out.println("Hai vinto :D");
            disableAll();
        }
    }

    boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x <= SQUARES_SIDE - 1 && y <= SQUARES_SIDE - 1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}