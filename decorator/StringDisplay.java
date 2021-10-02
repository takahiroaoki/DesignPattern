package decorator;

public class StringDisplay extends Display {
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    public int getColumns() {
        // 半角は1文字、全角は2文字分として文字列の長さを返す

        // 文字列の長さのカウンタ
        int cols = 0;

        // 全角半角判定
        char[] c = string.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (String.valueOf(c[i]).getBytes().length <= 1) {
                cols += 1; // 半角文字なら＋１
            } else {
                cols += 2; // 全角文字なら＋２
            }
        }
        return cols;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {// rowが0行目の時だけ返す
            return string;
        } else {
            return null;
        }
    }

}
