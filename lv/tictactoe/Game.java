package lv.tictactoe;

import java.util.Scanner;

public class Game {
    private Field field;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private ExampleField exampleField;

    public Game(Player firstPlayer, Player secondPlayer) {
        player1 = firstPlayer;
        player1.setMark(Mark.X);
        player2 = secondPlayer;
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
            System.out.println(field.countFreeCell() + " cell's left");
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
        if (field.verticalVictory(mark)
                || field.horizontalVictory(mark)
                || field.leftDiagonalVictory(mark)
                || field.rightDiagonalVictory(mark)) {

            System.out.println("_____________________________________________________________");
            System.out.println("WE GOT NEW WINNER! Winner is Player " + currentPlayer.getMark());
            System.out.println("PRESS 1 to START NEW GAME");
            reMatch();

            return false;
        }
        if (draw()) {
            reMatch();
        }
        return true;
    }

    private boolean draw() {
        if (field.countFreeCell() == 0) {
            System.out.println("IT'S A DRAW. WE GOT NO WINNER");
            System.out.println("PRESS 1 to START NEW GAME");
            return true;
        }
        return false;

    }

    private void reMatch() {
        Scanner scanner = new Scanner(System.in);
        int userAnswer = scanner.nextInt();
        if (userAnswer == 1) {
            Game game = new Game(new HumanPlayer(), new HumanPlayer());
        } else {
            System.exit(0);
            scanner.close();
        }


    }


}



