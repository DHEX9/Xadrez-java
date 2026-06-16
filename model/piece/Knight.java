package model.piece;

import game.Inicialization.Player;

public class Knight extends Piece{
    private final int[][] offset = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

    public Knight(Player color, String symbol, int[] position){
        super(color, symbol, position);
    }

    @Override
    public boolean isValidMove(int[] position){
        return true;
    }

    @Override
    public void calculateValidMoves(Piece[][] board){
        MoveType[][] moveType = new MoveType[8][8];

        for (int i = 0; i < offset.length; i++) {
            if(board[offset[i][0]][offset[i][1]] == null){
                moveType[offset[i][0]][offset[i][1]] = MoveType.MOVE;
            }
        }
    }
}
