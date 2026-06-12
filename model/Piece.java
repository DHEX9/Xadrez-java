package model;

public abstract class Piece {
    private String color;
    private  int[] position;
    private char symbol;
    
    public Piece(String color, int[]  position, char symbol){
        this.color = color;
        this.position = position;
        this.symbol = symbol;
    }

    //Getters
    public int[] getPosition(){
        return position;
    }

    public String getColor(){
        return color;
    }

    public char getSymbol(){
        return symbol;
    }

    //Setters
    public void setPosition(int[] position){
        this.position = position;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public abstract boolean is_valid_movement();

    public abstract void all_valid_movements();

    public abstract void display_movements();

    public abstract int[] movement();

}