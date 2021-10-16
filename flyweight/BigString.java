package flyweight;

public class BigString {
    // 大きな文字の文字列
    private BigChar[] bigChars;

    public BigString(String string, boolean isShared) {
        if (isShared) {
            initShared(string);
        } else {
            initNotShared(string);
        }
    }

    private void initShared(String string) {// インスタンスを共有して初期化する場合
        bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < string.length(); i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    private void initNotShared(String string) {
        bigChars = new BigChar[string.length()];
        for (int i = 0; i < string.length(); i++) {
            bigChars[i] = new BigChar(string.charAt(i));
        }
    }

    public void print() {
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i].print();
        }
    }
}
