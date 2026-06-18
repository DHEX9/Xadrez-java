package model.piece;

import game.Inicialization.Player;

public class Knight extends Piece{
    private final int[][] offset = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

    public Knight(Player color, String symbol, int[] position){
        super(color, symbol, position);
    }

    @Override
    public boolean isValidMove(Piece[][] board, Player player, int[] position, int[] move){
        
        if(board[position[0] + move[0]][position[1] + move[1]] == null || board[position[0] + move[0]][position[1] + move[1]].getColor() != player){
            return true;
        }
        
        return false;
    }

    @Override
    public MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position){
        MoveType[][] moveType = new MoveType[8][8];

        for (int i = 0; i < offset.length; i++) {

            if(board[position[0] + offset[i][0]][position[1] + offset[i][1]] == null){
                moveType[offset[i][0]][offset[i][1]] = MoveType.MOVE;
            }

            if(board[position[0] + offset[i][0]][position[1] + offset[i][1]].getColor() != player){
                moveType[offset[i][0]][offset[i][1]] = MoveType.CAPTURE;
            }

        }
        return moveType;
    }

    @Override
    public Piece[][] pieceMove(Piece[][] board, Piece piece){
        
        return board;
    }
}
