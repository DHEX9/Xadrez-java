package model;

public class Pawn extends Piece{
    public Pawn(String color, int[] position, char symbol){
        super(color, position, symbol);
        
    }

    @Override
    public boolean is_valid_movement(){
        return true;
    }

    @Override
    public int[] movement(){
        
    }
    
}
