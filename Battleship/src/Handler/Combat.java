package Handler;

import Main.Player;

public class Combat {
    public void attack(Player p, Double x, Double y){
        int hitX = (int) Math.round(x);
        int hitY = (int) Math.round(y);
        x *= 50;
        y *= 50;
        // Check if they hit ship one
        if(p.getShipArray()[hitX][hitY] == 1){
            if(p.getHitArray()[hitX][hitY] != 1){
                p.getBoard().setHit(x, y);
                p.addHit();
                p.documentHit(x,y,1);
            } else {
                System.out.println("THIS PLAYER ALREADY HIT HERE!");
            }
        }
        // Check if they hit ship two
        else if(p.getShipArray()[hitX][hitY] == 2){
            if(p.getHitArray()[hitX][hitY] != 2){
                p.getBoard().setHit(x, y);
                p.addHit();
                p.documentHit(x,y,2);
            } else {
                System.out.println("THIS PLAYER ALREADY HIT HERE!");
            }
        } else {
            p.getBoard().setMiss(x, y);
        }
    }
    public void checkLoseStatus(Player p){
        if(p.getHits() == 5){
            p.setLoser();
        }
    }
}
