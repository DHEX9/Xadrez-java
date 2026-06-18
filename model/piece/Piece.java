package model.piece;

import game.Inicialization.Player;

public abstract class Piece {
    private final Player color;
    private final String symbol;
    private  int[] position = new int[2];
    
    public Piece(Player color, String symbol, int[] position){
        this.color = color;
        this.symbol = symbol;
        this.position = position;
    }

    public enum MoveType {
        MOVE,
        CAPTURE,
        ENPASSANT
    }
    
    //Getters
    public int[] getPosition(){
        return position;
    }

    public Player getColor(){
        return color;
    }

    public String getSymbol(){
        return symbol;
    }

    //Setters
    public void setPosition(int[] position){
        this.position = position;
    }

    public abstract boolean isValidMove(Piece[][] board, Player player, int[] position, int[] move);

    public abstract MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position);

    public abstract Piece[][] pieceMove(Piece[][] board, Piece piece);

    public static final String GREEN_BG = "\u001B[42m";

    
}