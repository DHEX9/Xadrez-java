package game;

import model.Bishop;
import model.King;
import model.Knight;
import model.Pawn;
import model.Piece;
import model.Queen;
import model.Rook;
import ui.Output;

public class Inicialization {
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public enum Player{
        WHITE("White's turn."),
        BLACK("Black's turn.");

        private String message;

        Player(String message){
            this.message = message;
        }

        public void displayMessage(){
            Output.messagePlayerTurn(message);
        }
    }
    
    public static Piece[][] inicialization(){

        //Board
        Piece[][] board = new Piece[8][8];

        // Black Pieces -----

        //Black Rook
        board[0][0] = new Rook(Player.BLACK, BLUE + "♜");

        //Black Knight
        board[0][1] = new Knight(Player.BLACK, BLUE + "♞");

        //Black Bishop
        board[0][2] = new Bishop(Player.BLACK, BLUE + "♝");
        
        //Black Queen
        board[0][3] = new Queen(Player.BLACK, BLUE + "♛");
        
        //Black King
        board[0][4] = new King(Player.BLACK, BLUE + "♚");

        //Black Bishop
        board[0][5] = new Bishop(Player.BLACK, BLUE + "♝");
        
        //Black Knight
        board[0][6] = new Knight(Player.BLACK, BLUE + "♞");
        
        //Black Rook
        board[0][7] = new Rook(Player.BLACK, BLUE + "♜");
        
        //Black Pawn
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Player.BLACK, BLUE + "♟");
        }

        // White Pieces -----

        //Black Rook
        board[7][0] = new Rook(Player.WHITE, "♖");

        //Black Knight
        board[7][1] = new Knight(Player.WHITE, "♘");

        //Black Bishop
        board[7][2] = new Bishop(Player.WHITE, "♗");
        
        //Black Queen
        board[7][3] = new Queen(Player.WHITE, "♕");
        
        //Black King
        board[7][4] = new King(Player.WHITE, "♔");

        board[7][5] = new Bishop(Player.WHITE, "♗");
        
        //Black Knight
        board[7][6] = new Knight(Player.WHITE, "♘");
        
        //Black Rook
        board[7][7] = new Rook(Player.WHITE, "♖");
        
        //Black Pawn
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Player.WHITE, "♙");
        }

        return board;
    }

    //Brancas: ♔ ♕ ♖ ♗ ♘ ♙
    //Pretas : ♚ ♛ ♜ ♝ ♞ ♟
    
}
