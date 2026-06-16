package model.piece;

import game.Inicialization.Player;

public class King extends Piece{
    private boolean roque = true;

    public King(Player color, String symbol, int[] position){
        super(color, symbol, position);
    }

    @Override
    public boolean isValidMove(int[] position){
        return true;
    }

    @Override
    public void calculateValidMoves(Piece[][] board){

    }

    public boolean roque(){
        return true;
    }

    public boolean doesNotLeaveKingInCheck(){
        return true;
    }
}
