package model;

import game.Inicialization.Player;

public class King extends Piece{
    private final int[][] offsets = {{1,0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    private boolean roque = true;

    public King(Player color, String symbol){
        super(color, symbol);
    }

    @Override
    public boolean isValidMove(int[] move){
        if(getMoveType()[move[0]][move[1]] == MoveType.MOVE || getMoveType()[move[0]][move[1]] == MoveType.CAPTURE){
            return true;
        }
        
        return false;
    }

    @Override
    public MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position){

        MoveType[][] moveType = new MoveType[8][8];
        int row;
        int col;

        for (int[] offset : offsets){

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

    public boolean roque(){
        return true;
    }

    public boolean doesNotLeaveKingInCheck(){
        return true;
    }
}
