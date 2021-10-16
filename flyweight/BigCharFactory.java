package flyweight;

import java.util.HashMap;

public class BigCharFactory {
    // 既に作ったBigCharのインスタンスを管理
    private HashMap<String, BigChar> pool = new HashMap<>();
    // singletonパターン
    private static BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory() {}

    // 唯一のインスタンスを作る
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigCharのインスタンスを生成
    public synchronized BigChar getBigChar(char charName) {
        BigChar bc = (BigChar) pool.get("" + charName);
        if (bc == null) {
            bc = new BigChar(charName);
            pool.put("" + charName, bc);
        }
        return bc;
    }
}
