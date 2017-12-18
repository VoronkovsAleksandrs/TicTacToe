package lv.tictactoe;

public enum Mark {
    X("X"),
    O("O"),
    EMPTY(".");
    private String value;
    Mark (String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
