package model.piece;

import game.Inicialization.Player;

public class King extends Piece{
    private boolean roque = true;

    public King(Player color, String symbol, int[] position){
        super(color, symbol, position);
    }

    @Override
    public boolean isValidMove(Piece[][] board, Player player, int[] position, int[] move){
        return true;
    }

    @Override
    public MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position){
        return null;
    }

    public boolean roque(){
        return true;
    }

    public boolean doesNotLeaveKingInCheck(){
        return true;
    }

    @Override
    public Piece[][] pieceMove(Piece[][] board, Piece piece){
        
        return board;
    }
}
