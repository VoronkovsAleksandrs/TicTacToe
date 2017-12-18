package lv.tictactoe;

import java.util.Scanner;

public class Game {
    private static final int MAX_TURNS = 9;
    private Field field;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private ExampleField exampleField;

    public Game(Player inPlayer1, Player inPlayer2) {
        player1 = inPlayer1;
        player1.setMark(Mark.X);
        player2 = inPlayer2;
        player2.setMark(Mark.O);
        exampleField = new ExampleField();
        field = new Field();
        field.fillFieldByEmptyValues();
        exampleField.printExample();
        field.printField();
        startGame();
    }


    public void startGame() {
        switchPlayers();
        while (winnerDetected(currentPlayer.getMark())) {
            switchPlayers();

            field.setField(currentPlayer.selectCell(), currentPlayer.getMark());
            exampleField.printExample();
            field.printField();
        }
    }

    private void switchPlayers() {
        if (currentPlayer == player2) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }

    private boolean winnerDetected(Mark mark) {
        Scanner scanner = new Scanner(System.in);
        if (field.verticalVictory(mark)
                || field.horizontalVictory(mark)
                || field.leftDiagonalVictory(mark)
                || field.rightDiagonalVictory(mark)) {
            System.out.println("_____________________________________________________________");
            System.out.println("WE GOT NEW WINNER! Winner is Player " + currentPlayer.getMark());
            System.out.println("PRESS 1 to START NEW GAME");
            int userAnswer = scanner.nextInt();
            if (userAnswer == 1) {
                Game game = new Game(new HumanPlayer(),new HumanPlayer());
            } else {
                System.exit(0);
            }
            return false;
        }
        return true;
    }


}



