package lv.tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);
    @Override
    public int selectCell() {
        System.out.println("Player "+getMark()+" turn");
        System.out.println("Enter cell's number: ");
        System.out.println(">>");
        return scanner.nextInt();

    }
}
