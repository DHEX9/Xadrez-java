package game;

import game.Inicialization.Player;
import model.Piece;
import model.Piece.MoveType;
import ui.Input;
import ui.Output;

public class Turn {
    
    public static Player playerTurn(Player player){

        if(player == Player.WHITE) return Player.BLACK;
        return Player.WHITE;

    }
    
    public static int[] choosePiece(Piece[][] board, Player player){

        while(true){

            Output.messageChoosePiece();

            int[] position = Input.readPosition();

            if(board[position[0]][position[1]] == null ||board[position[0]][position[1]].getColor() != player){
                Output.messageErrorChoosePiece();
                continue;
            }

            MoveType[][] moveType = board[position[0]][position[1]].calculateValidMoves(board, player, position);
            Output.showValidMoves(board, moveType);
            player.displayMessage();

            board[position[0]][position[1]].setMoveType(moveType);
            
            if(board[position[0]][position[1]].isLocked()){
                Output.messagePieceLocked();
                continue;
            }
            
            Output.messagePieceConfirmation();
            if(Input.cancelPiece()) continue;
            
            return position;
        }
    }

    public static Piece[][] move(Piece[][] board, int[] position, Player player){

        while(true){

            Output.messageChoosePosition();

            int[] move = Input.readPosition();

            if(board[position[0]][position[1]].isValidMove(move)){

                board = board[position[0]][position[1]].movePiece(board, position, move);
                return board;
                
            }

            System.out.println("Invalid");
            
        }
    }
}
