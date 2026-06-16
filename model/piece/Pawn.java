package model.piece;

import game.Inicialization.Player;

public class Pawn extends Piece{
    private boolean doubleAdvance = true;

    public Pawn(Player color, String symbol, int[] position){
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
