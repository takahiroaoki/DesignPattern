package decorator;

public abstract class Display {
    public abstract int getColumns();// 横の幅（半角換算での文字数）を得る

    public abstract int getRows();// 行数を得る

    public abstract String getRowText(int row);// 0始まりrow行目の文字列を得る

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}