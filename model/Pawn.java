package model;

import game.GameState;
import game.Inicialization.Player;
import model.Piece.MoveType;

public class Pawn extends Piece{
    private final int[] offsetsWhiteMove = {-1, 0};
    private final int[] offsetsBlackMove = {1, 0}; 
    private final int[][] offsetsWhiteCapture = {{-1, -1}, {-1, 1}};
    private final int[][] offsetsBlackCapture = {{1, -1}, {1, 1}};

    private boolean doubleAdvance = true;

    public Pawn(Player color, String symbol){
        super(color, symbol);
    }

    @Override
    public boolean isValidMove(int[] move){
        if(getMoveType()[move[0]][move[1]] == MoveType.MOVE || getMoveType()[move[0]][move[1]] == MoveType.CAPTURE || getMoveType()[move[0]][move[1]] == MoveType.DOUBLEADVANCE || getMoveType()[move[0]][move[1]] == MoveType.ENPASSANT){
            return true;
        }
        
        return false;
    }

    @Override
    public Piece[][] movePiece(Piece[][] board, int[] position, int[] move){

        GameState.enPassantPawn = null;
        
        if(getMoveType()[move[0]][move[1]] == MoveType.DOUBLEADVANCE){

            board[move[0]][move[1]] = board[position[0]][position[1]];
            board[position[0]][position[1]] = null;
            GameState.enPassantPawn = (Pawn) board[move[0]][move[1]];
            doubleAdvance = false;
            return board;
            
        }
        else if(getMoveType()[move[0]][move[1]] == MoveType.ENPASSANT){

            board[move[0]][move[1]] = board[position[0]][position[1]];
            board[position[0]][position[1]] = null;

            board[position[0]][move[1]] = null;

            return board;
        }
        
        doubleAdvance = false;
        board[move[0]][move[1]] = board[position[0]][position[1]];
        board[position[0]][position[1]] = null;
        return board;
    }


    @Override
    public MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position){
        
        MoveType[][] moveType = new MoveType[8][8];
        int row = position[0];
        int col = position[1];
        int intDoubleAdvance;
        int[] offsetMove;
        int[][] offsetCapture;

        if(player == Player.WHITE){

            intDoubleAdvance = -1;
            offsetMove = offsetsWhiteMove;
            offsetCapture = offsetsWhiteCapture;

        }
        else{

            intDoubleAdvance = 1;
            offsetMove = offsetsBlackMove;
            offsetCapture = offsetsBlackCapture;

        }

        if(doubleAdvance && board[row + intDoubleAdvance][col] == null && board[row + (intDoubleAdvance * 2)][col] == null){
            
            moveType[row + intDoubleAdvance][col] = MoveType.MOVE;
            moveType[row + (intDoubleAdvance * 2)][col] = MoveType.DOUBLEADVANCE;

        } 

        row = position[0] + offsetMove[0];
        col = position[1] + offsetMove[1];

        if((row <= 7 && col <= 7 && row >= 0 && col >= 0) && board[row][col] == null){
            moveType[row][col] = MoveType.MOVE;
        }

        for (int[] offset : offsetCapture) {
            row = position[0] + offset[0];
            col = position[1] + offset[1];

            if((row <= 7 && col <= 7 && row >= 0 && col >= 0) && board[row][col] != null && board[row][col].getColor() != player){
                moveType[row][col] = MoveType.CAPTURE;
            }

            if((row <= 7 && col <= 7 && row >= 0 && col >= 0) && board[position[0]][col] == GameState.enPassantPawn && board[position[0]][col] != null){
                moveType[row][col] = MoveType.ENPASSANT;
            }

        }
        
        return moveType;
    }
}
