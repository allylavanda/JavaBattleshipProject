package Handler;

import Main.Player;

import java.util.Objects;

public class Combat {
    public void attack(Player p, Double x, Double y){
        // Check if they hit ship one
        if(Objects.equals(x, p.getShipOneLoc()[0]) && x <= p.getShipOneLoc()[2] || Objects.equals(y, p.getShipOneLoc()[1]) && y <= p.getShipOneLoc()[3]){
            p.getBoard().setHit(x, y);
        } else {
            p.getBoard().setMiss(x, y);
        }
        // Check if they hit ship two
        if(Objects.equals(x, p.getShipTwoLoc()[0]) && x <= p.getShipTwoLoc()[2] || Objects.equals(y, p.getShipTwoLoc()[1]) && y <= p.getShipTwoLoc()[3]){
            p.getBoard().setHit(x, y);
        } else {
            p.getBoard().setMiss(x, y);
        }
    }
}
