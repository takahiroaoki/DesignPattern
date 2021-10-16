package flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    // 文字の名前
    private char charName;
    // 大きな文字を表現するアスキーアート
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader("flyweight/big" + charName + ".txt")
            );
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontData = buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}
