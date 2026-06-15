package ui;

public class Output {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String MARGIN = "                                                                 ";

    public static void main(String[] args) {

        System.out.print("\n\n");
        for (int i = 0; i < 8; i++) { // Linhas
            for (int h = 0; h < 3; h++) { // 3 linhas de altura

                System.out.print(MARGIN);

                for (int j = 0; j < 8; j++) { // Colunas

                    if((i+j) % 2 == 0){
                        if(h == 1){
                            System.out.print(BLACK_BG + "   ♚️    " + RESET);
                        }
                        else{
                            System.out.print(BLACK_BG + "        " + RESET);
                        }
                    }
                    else{
                        if(h == 1){
                            System.out.print("   ♚️    ");
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