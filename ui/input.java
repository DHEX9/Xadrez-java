package ui;

import java.util.Scanner;

public class Input {

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

    public static int[] input(){
        Scanner scanner = new Scanner(System.in);
    
        while(true){

            String input = scanner.next().toLowerCase();

            if(input.matches("[a-h][0-7]")){

                int[] position = {input.charAt(0), input.charAt(1) - '0'};
                scanner.close();
                return position;
            }
            
            System.out.println("Invalid");

        }
    }
}
