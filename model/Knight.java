package model;

public class Knight extends Piece{
    private int[][] offset = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

    public Knight(String color, int[]  position, char symbol){
       super(color, position, symbol);
    }

    @Override
    public boolean is_valid_movement(){
        return true;
    }

    @Override
    public void all_valid_movements(){

    }

    @Override
    public void display_movements(){

    }

    @Override
    public int[] movement(){
        
    }
}
