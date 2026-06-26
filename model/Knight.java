package model;

import game.Inicialization.Player;

public class Knight extends Piece{
    private final int[][] offsets = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

    public Knight(Player color, String symbol){
        super(color, symbol);
    }

    @Override
    public MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position){

        MoveType[][] moveType = new MoveType[8][8];
        int row, col;

        for (int[] offset : offsets) {
            row = position[0] + offset[0];
            col = position[1] + offset[1];

            if(row > 7 || col > 7 || row < 0 || col < 0) continue;

            if(board[row][col] == null){
                moveType[row][col] = MoveType.MOVE;
            }
            else if(board[row][col].getColor() != player){
                moveType[row][col] = MoveType.CAPTURE;
            }

        }
        return moveType;
    }
}
