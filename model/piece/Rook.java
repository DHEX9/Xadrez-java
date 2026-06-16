package model.piece;

import game.Inicialization.Player;

public class Rook extends Piece{
    private boolean roque = true;
    
    public Rook(Player color, String symbol, int[] position){
        super(color, symbol, position);
    }

    @Override
    public boolean isValidMove(int[] position){
        return true;
    }

    @Override
    public void calculateValidMoves(Piece[][] board){

    }
}
