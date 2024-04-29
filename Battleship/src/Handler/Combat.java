package Handler;

import Main.Player;

public class Combat {
    public void attack(Player p, Double x, Double y){
        int hitX = (int) Math.round(x);
        int hitY = (int) Math.round(y);
        // Check if they hit ship one
        if(p.getShipArray()[hitX][hitY] == 1 || p.getShipArray()[hitX+1][hitY] == 1){
            p.getBoard().setHit(x, y);
        } else {
            x *= 50;
            y *= 50;
            p.getBoard().setMiss(x, y);
        }
        // Check if they hit ship two
        if(p.getShipArray()[hitX][hitY] == 2 || p.getShipArray()[hitX+1][hitY] == 2 || p.getShipArray()[hitX+2][hitY] == 2){
            p.getBoard().setHit(x, y);
        } else {
            x *= 50;
            y *= 50;
            p.getBoard().setMiss(x, y);
        }
    }
}
