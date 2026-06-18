package ui;

import model.piece.Piece;
import model.piece.Piece.MoveType;

public class Output {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String MARGIN = "                                                                 ";

    static void clearScreen() {
        System.out.print("\033[2J\033[H\n\n");
        System.out.flush();
    }

    public static void messagePlayerTurn(String message){
        System.out.print(MARGIN + message);
    }

    public static void messagePieceConfirmation(){
        System.out.println("Confirm part? Any key / N");
    }

    public static void showValidMoves(Piece[][] board, MoveType[][] moveType){
        
    }

    public static void output(Piece[][] board) {

        System.out.print("\n\n");

        for (int i = 0; i < 8; i++) { // Lines
            for (int h = 0; h < 3; h++) { // 3 lines of height

                System.out.print(MARGIN); // Margin

                for (int j = 0; j < 8; j++) { // columns

                    if((i+j) % 2 == 0){ // Cores alternadas

                        if(board[i][j] != null){ //É obejto

                            if(h == 1){ //Meio do quadrado
                                System.out.print(BLACK_BG + "   " + board[i][j].getSymbol() + "    " + RESET);
                            }
                            else{
                                System.out.print(BLACK_BG + "        " + RESET);
                            }
                        }
                        else{
                            System.out.print(BLACK_BG + "        " + RESET);
                        }
                    }
                    else{
                        if(board[i][j] != null){
                            if(h == 1){
                            System.out.print("   " + board[i][j].getSymbol() + "    ");
                            }
                            else{
                                System.out.print("        ");
                            }
                        }
                        else{
                            System.out.print("        ");
                        }
                        
                    }
                }
                System.out.println();
            }
        }
        System.out.print("\n\n");
    }
}