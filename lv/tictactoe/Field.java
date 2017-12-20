package lv.tictactoe;

public class Field {
    private Game game;

    private static final int ROW = 3;
    private static final int COLUMNS = 3;

    private Mark[][] field = new Mark[COLUMNS][ROW];

    public void printField() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(field[col][row] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void fillFieldByEmptyValues() {

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                field[col][row] = Mark.EMPTY;
            }
        }
    }

    public void setField(int move, Mark mark) {
        if (!checkFreeCell(move)) {
            System.out.println("!!! Please choose another cell. You cannot override selected cell !!!");
            System.out.println("TURN GOES TO ANTHER PLAYER");
            move = 10;

        }

        if (move <= 3) {
            field[0][move - 1] = mark;
        }
        if (move >= 4 && move <= 6) {
            field[1][move - 4] = mark;
        }
        if (move >= 7 && move <= 9) {
            field[2][move - 7] = mark;
        }
        if (move <= 0 || move > 9) {
            System.out.println(move + " is not valid number. Please enter number from 1-9");
            game.switchPlayers();

        }
    }

    public Mark getField(int move) {
        int row = 0;
        int column = 0;
        if (move <= 3) {
            row = 0;
            column = move - 1;
        }
        if (move >= 4 && move <= 6) {
            row = 1;
            column = move - 4;
        }
        if (move >= 7 && move <= 9) {
            row = 2;
            column = move - 7;
        }
        return field[row][column];
    }

    public boolean checkFreeCell(int move) {
        if (getField(move) == (Mark.EMPTY)) {
            return true;
        }
        return false;
    }

    public boolean horizontalVictory(Mark mark) {
        int markCount = 0;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (field[col][row] == mark) {
                    markCount++;
                } else {
                    markCount = 0;
                }
                if (markCount == 3) {
                    System.out.println("HORIZONTAL WIN");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean verticalVictory(Mark mark) {
        int markCount = 0;
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROW; row++) {
                if (field[col][row] == mark) {
                    markCount++;
                } else {
                    markCount = 0;
                }
                if (markCount == 3) {
                    System.out.println("Vertical WIN");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean leftDiagonalVictory(Mark mark) {
        if (getField(1) == (mark)) {
            if (getField(5) == (mark)) {
                if (getField(9) == ((mark))) {
                    System.out.println("LEFT DIAGONAL");
                    return true;


                }
            }

        }
        return false;
    }

    public boolean rightDiagonalVictory(Mark mark) {
        if (getField(7) == (mark)) {
            if (getField(5) == (mark)) {
                if (getField(3) == ((mark))) {
                    System.out.println("RIGHT DIAGONAL");
                    return true;


                }
            }

        }
        return false;
    }

    public int countFreeCell() {
        int counter = 0;
        for (int i = 1; i < 10; i++) {
            if (getField(i) == (Mark.EMPTY)) {
                counter++;
            }

        }return counter;

    }
}


