package Stages;

import StageObjects.Grid;
import javafx.stage.Stage;
import Main.Player;

public class Battle extends Stage{
    private Grid gridOne, gridTwo;
    public Battle(Player p1, Player p2){
        this.setTitle("Battleship - Battle!");

        // Check player turn and generate boards
        generateBoards(p1,p2);




    }
    private void generateBoards(Player p1, Player p2){
        if(p1.getTurn()){
            Grid gridOne = p1.getBoard();
            gridOne.generate();
            Grid gridTwo = p2.getBoard();
            gridTwo.generate();
        }
        if(p2.getTurn()){
            Grid gridOne = p2.getBoard();
            gridOne.generate();
            Grid gridTwo = p2.getBoard();
            gridTwo.generate();
        }
    }
}
