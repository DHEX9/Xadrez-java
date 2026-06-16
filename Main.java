import game.Game;
import game.Inicialization;
import game.Inicialization.Player;

public class Main {

    public static void main(String[] args) {
        Game.Start(Inicialization.inicialization(), Player.BLACK);
    }
}