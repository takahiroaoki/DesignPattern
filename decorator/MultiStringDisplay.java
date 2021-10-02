package decorator;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    private List<String> body = new ArrayList<>();
    private int columns;

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    private void updateColumn(String msg) {
        if (getWidth(msg) > columns) {
            columns = getWidth(msg);
        }
        for (int row = 0; row < body.size(); row++) {
            int fills = columns - getWidth(body.get(row));
            if (fills > 0) {
                body.set(row, body.get(row) + spaces(fills));
            }
        }
    }

    public void add(String msg) {
        body.add(msg);
        updateColumn(msg);
    }

    private String spaces(int count) {// 空白を埋める
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int getWidth(String msg) {
        // 半角は1文字、全角は2文字分として文字列の長さを返す

        // 文字列の長さのカウンタ
        int w = 0;

        // 全角半角判定
        char[] c = msg.toCharArray();
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
