package lv.tictactoe;

public class Main {
    public static void main(String[] args) {
       Game game = new Game(new HumanPlayer(),new HumanPlayer());
       game.startGame();

    }
}
