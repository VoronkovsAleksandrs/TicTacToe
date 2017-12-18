package lv.tictactoe;

import java.util.Random;

public class ComputerPlayer extends Player {
    Random randomizer = new Random();
    @Override
    public int selectCell() {
        return randomizer.nextInt(9);
    }
}
