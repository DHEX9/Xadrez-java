package game;

import game.Inicialization.Player;
import model.piece.Piece;

public class Turn {
    public static Player playerTurn(Player player){

        if(player == Player.WHITE) return Player.BLACK;
        return Player.WHITE;

    }

    public static Piece[][] Move(Piece[][] board, Player player){

        while(true){
            
        }
        
        return board;
    }
}
