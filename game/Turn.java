package game;

import game.Inicialization.Player;

public class Turn {
    public static Player playerTurn(Player player){

        if(player == Player.WHITE) return Player.BLACK;
        return Player.WHITE;

    }
}
