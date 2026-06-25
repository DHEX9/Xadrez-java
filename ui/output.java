package ui;

import model.Piece;
import model.Piece.MoveType;

public class Output {
    public static final String RESET = "\u001B[0m";
    public static final String GRAY_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String FOREST_GREEN_BG = "\u001B[48;5;28m";
    public static final String MARGIN = "                                                                 ";
    public static final String MARGIN_FOR_CHARACTER = "                                                             "; //-4

    static void clearScreen() {
        System.out.print("\033[2J\033[H\n\n");
        System.out.flush();
    }

    public static void messagePlayerTurn(String message){
        System.out.println(MARGIN + message);
    }

    public static void messageChoosePiece(){
        System.out.print(MARGIN + "Choose a piece: ");
    }

    public static void messagePieceConfirmation(){
        System.out.print("\r" + MARGIN + "Confirm piece? Any key / N: ");
    }

    public static void messagePieceLocked(){
        System.out.println(MARGIN + "This piece is stuck. ");
    }

    public static void messageErrorChoosePiece(){
        System.out.println(MARGIN + "You don't have the part in this location.");
    }
    public static void showSquareValidMoves(Piece piece, boolean graySquare, int line, MoveType moveType){
        String background;
        String content = "        ";

        if(moveType == MoveType.CAPTURE){
            background = RED_BG;
        }
        else if(moveType == MoveType.MOVE && graySquare){
            background = GREEN_BG;
        }
        else if(moveType == MoveType.MOVE){
            background = FOREST_GREEN_BG;
        }
        else background = graySquare ? GRAY_BG : "";

        if(piece != null && line == 1){
            content = "   " + piece.getSymbol() + "    ";
        }

        System.out.print(background + content + RESET);
    }

    public static void showValidMoves(Piece[][] board, MoveType[][] moveType){

        clearScreen();

        System.out.print("\n\n");

        for (int row = 0; row < 8; row++) { // Lines
            for (int line = 0; line < 3; line++) { // 3 lines of height

                if(line == 1) System.out.print(MARGIN_FOR_CHARACTER + (char) ('A' + row) + "   ");
                else System.out.print(MARGIN); // Margin

                for (int col = 0; col < 8; col++) { // columns
                    showSquareValidMoves(board[row][col], (row + col) % 2 == 0, line, moveType[row][col]);
                }

                System.out.println();

            }
        }

        System.out.println();
        System.out.print(MARGIN_FOR_CHARACTER);

        for(int i = 0; i < 8; i++){
            System.out.print("       " + i);
        }
        
        System.out.print("\n\n");
    }

    public static void printSquare(Piece piece, boolean blackSquare, int line) {

        String background = blackSquare ? GRAY_BG : "";
        String content = "        ";
        if(piece != null && line == 1){
            content = "   " + piece.getSymbol() + "    ";
        }

        System.out.print(background + content + RESET);
    }

    public static void output(Piece[][] board) {

        clearScreen();

        System.out.print("\n\n");

        for (int row = 0; row < 8; row++) { // Lines
            for (int line = 0; line < 3; line++) { // 3 lines of height

                if(line == 1) System.out.print(MARGIN_FOR_CHARACTER + (char) ('A' + row) + "   ");
                else System.out.print(MARGIN); // Margin

                for (int col = 0; col < 8; col++) { // columns
                    printSquare(board[row][col], (row + col) % 2 == 0, line);
                }

                System.out.println();

            }
        }

        System.out.println();
        System.out.print(MARGIN_FOR_CHARACTER);

        for(int i = 0; i < 8; i++){
            System.out.print("       " + i);
        }

        System.out.print("\n\n");
    }
}