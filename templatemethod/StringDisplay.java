package templatemethod;

public class StringDisplay extends AbstractDisplay {

    private String str;
    private int width;

    public StringDisplay(String str) {
        this.str = str;
        this.width = getWidth(str);// .getBytes()してからでないと、日本語などの2バイト文字長さが合わなくなる。
    }

    @Override
    protected void open() {
        printLine();
    }

    @Override
    protected void print() {
        System.out.println("|" + this.str + "|");
    }

    @Override
    protected void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < this.width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    private int getWidth(String str) {
        // 半角は1文字、全角は2文字分として文字列の長さを返す

        // 文字列の長さのカウンタ
        int w = 0;

        // 全角半角判定
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (String.valueOf(c[i]).getBytes().length <= 1) {
                w += 1; // 半角文字なら＋１
            } else {
                w += 2; // 全角文字なら＋２
            }
        }
        return w;
    }
}
