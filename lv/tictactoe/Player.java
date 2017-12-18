package lv.tictactoe;

public abstract class Player {
    private Mark mark;

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public abstract int selectCell ();
}
