package model;

import game.Inicialization.Player;

public class Queen extends Piece{

    private final int[][] offsets = {{1,0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public Queen(Player color, String symbol){
        super(color, symbol);
    }

    @Override
    public MoveType[][] calculateValidMoves(Piece[][] board, Player player, int[] position){

        MoveType[][] moveType = new MoveType[8][8];

        for (int[] offset : offsets){
            
            int row = position[0];
            int col = position[1];

            while(true){
                
                row += offset[0];
                col += offset[1];

                if(row > 7 || col > 7 || row < 0 || col < 0) break;

                if(board[row][col] == null){
                    moveType[row][col] = MoveType.MOVE;
                }
                else if(board[row][col].getColor() != player){
                    moveType[row][col] = MoveType.CAPTURE;
                    break;
                }
                else{
                    break;
                }

            }
        }
        return moveType;
    }
}
