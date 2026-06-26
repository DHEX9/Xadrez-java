package model;

import game.GameState;
import game.Inicialization.Player;

public abstract class Piece {
    private final Player color;
    private final String symbol;
    
    MoveType[][] moveType;

    public Piece(Player color, String symbol){
        this.color = color;
        this.symbol = symbol;
    }

    public enum MoveType {
        MOVE,
        CAPTURE,
        ENPASSANT,
        DOUBLEADVANCE
    }
    
    //Getters

    public Player getColor(){
        return color;
    }

    public String getSymbol(){
        return symbol;
    }

    public MoveType[][] getMoveType(){
        return moveType;
    }

    //Setters

    public void setMoveType(MoveType[][] moveType){
        this.moveType = moveType;
    }

    public boolean isLocked(){

        for (MoveType[] row : moveType) {
            for (MoveType col : row) {
                if(col != null){
                    return false;
                }
            }
        }

        return true;
    }
    
    public boolean isValidMove(int[] move){
        if(getMoveType()[move[0]][move[1]] == MoveType.MOVE || getMoveType()[move[0]][move[1]] == MoveType.CAPTURE){
            return true;
        }
        
        return false;
    }

    public abstract MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position);

    public Piece[][] movePiece(Piece[][] board, int[] position, int[] move){

        board[move[0]][move[1]] = board[position[0]][position[1]];
        board[position[0]][position[1]] = null;
        GameState.enPassantPawn = null;
        
        return board;
    }

}