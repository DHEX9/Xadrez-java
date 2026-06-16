package game;

import model.piece.Bishop;
import model.piece.King;
import model.piece.Knight;
import model.piece.Pawn;
import model.piece.Piece;
import model.piece.Queen;
import model.piece.Rook;
import ui.Output;

public class Inicialization {
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public enum Player{
        WHITE("White's turn: "),
        BLACK("Black's turn: ");

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
        board[0][0] = new Rook(Player.BLACK, BLUE + "♜", new int[]{0,0});

        //Black Knight
        board[0][1] = new Knight(Player.BLACK, BLUE + "♞", new int[]{0,1});

        //Black Bishop
        board[0][2] = new Bishop(Player.BLACK, BLUE + "♝", new int[]{0,2});
        
        //Black Queen
        board[0][3] = new Queen(Player.BLACK, BLUE + "♛", new int[]{0,3});
        
        //Black King
        board[0][4] = new King(Player.BLACK, BLUE + "♚", new int[]{0,4});

        //Black Bishop
        board[0][5] = new Bishop(Player.BLACK, BLUE + "♝", new int[]{0,5});
        
        //Black Knight
        board[0][6] = new Knight(Player.BLACK, BLUE + "♞", new int[]{0,6});
        
        //Black Rook
        board[0][7] = new Rook(Player.BLACK, BLUE + "♜", new int[]{0,7});
        
        //Black Pawn
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Player.BLACK, BLUE + "♟", new int[]{1,i});
        }

        // White Pieces -----

        //Black Rook
        board[7][0] = new Rook(Player.WHITE, "♖", new int[]{7,0});

        //Black Knight
        board[7][1] = new Knight(Player.WHITE, "♘", new int[]{7,1});

        //Black Bishop
        board[7][2] = new Bishop(Player.WHITE, "♗", new int[]{7,2});
        
        //Black Queen
        board[7][3] = new Queen(Player.WHITE, "♕", new int[]{7,3});
        
        //Black King
        board[7][4] = new King(Player.WHITE, "♔", new int[]{7,4});

        board[7][5] = new Bishop(Player.WHITE, "♗", new int[]{7,5});
        
        //Black Knight
        board[7][6] = new Knight(Player.WHITE, "♘", new int[]{7,6});
        
        //Black Rook
        board[7][7] = new Rook(Player.WHITE, "♖", new int[]{7,7});
        
        //Black Pawn
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Player.WHITE, "♙", new int[]{6,i});
        }

        return board;
    }

    //Brancas: ♔ ♕ ♖ ♗ ♘ ♙
    //Pretas : ♚ ♛ ♜ ♝ ♞ ♟
    
}
