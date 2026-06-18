package game;

import game.Inicialization.Player;
import model.piece.Piece;
import ui.Input;
import ui.Output;

public class Turn {
    
    public static Player playerTurn(Player player){

        if(player == Player.WHITE) return Player.BLACK;
        return Player.WHITE;

    }
    
    public static int[] choosePiece(Piece[][] board, Player player){

        while(true){

            int[] position = Input.readPosition();

            if(board[position[0]][position[1]].getColor() != player){
                System.out.println("You don't have the part in this location.");
                continue;
            }

            Output.showValidMoves(board, board[position[0]][position[1]].calculateValidMoves(board, player, position));
            
            if(Input.cancelPiece()) continue;
            
            return position;
        }
    }

    public static Piece[][] move(Piece[][] board, int[] position, Player player){

        while(true){

            int[] move = Input.readPosition();

            if(board[position[0]][position[1]].isValidMove(board, player, position, move)){
                board[move[0]][move[1]] = board[position[0]][position[1]];
                board[position[0]][position[1]] = null;
                return board;
            }

            System.out.println("Invalid");
            
        }
    }
}
