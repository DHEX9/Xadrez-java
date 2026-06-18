package ui;

import java.util.Scanner;

public class Input {
    public static boolean cancelPiece(){
        Scanner scanner = new Scanner(System.in);
        char character = scanner.next().charAt(0);
        scanner.close();

        if(character == 'N') return true;
        return false;
    }

    public static int columnToIndex(char character){

        switch (character) {
            case 'a':
                return 0;

            case 'b':
                return 1;

            case 'c':
                return 2;

            case 'd':
                return 3;

            case 'e':
                return 4;

            case 'f':
                return 5;

            case 'g':
                return 6;
            
            case 'h':
                return 7;
            
            default:
                return -1;
        }
    }

    public static int[] readPosition(){
        Scanner scanner = new Scanner(System.in);
    
        while(true){

            String input = scanner.next().toLowerCase();

            if(input.matches("[a-h][0-7]")){
        
                scanner.close();
                return new int[]{columnToIndex(input.charAt(0)), input.charAt(1) - '0'};
            }
            
            System.out.println("Invalid, Try again: ");
            
        }
    }
}
