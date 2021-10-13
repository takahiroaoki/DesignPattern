package memento.game;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();


    public static String[] fruitsName = {
        "りんご", "ぶどう", "バナナ", "みかん"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = 1 + random.nextInt(6);// さいころを振る

        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました。");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました。");
        } else if (dice == 6) {
            String f = getFruit();
            fruits.add(f);
            System.out.println("フルーツ（" + f + "）をもらいました。");
        } else {
            System.out.println("何も起こりませんでした。");
        }
    }

    public Memento createMemento() {// スナップショットを撮る
        Memento m = new Memento(money);
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String) it.next();// フルーツは美味しいものだけ保存
            if (f.startsWith("おいしい")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {// アンドゥを行う
        this.money = memento.getMoney();
        this.fruits = memento.getFruit();
    }
    
    private String getFruit() {// ランダムにフルーツを選ぶメソッド
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }

    public String toString() {
        return "[money = " + money + ", fruits = " + fruits.toString() + "]";
    }
}
