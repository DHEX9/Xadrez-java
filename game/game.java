package game;

import game.Inicialization.Player;
import model.piece.Piece;
import ui.Output;

public class Game {

    public static void Start(Piece[][] board, Player player){
        
        while(true) {
            Output.output(board);
            player = Turn.playerTurn(player);
            player.displayMessage();

            
            
        }
    }
}
