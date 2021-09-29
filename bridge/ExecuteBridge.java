package bridge;

public class ExecuteBridge {
    public static void main(String[] args) {
        Display d = new Display(new StringDisplayImpl("Hellow world!"));
        d.display();

        // 機能のクラス階層の追加
        CountDisplay cd = new CountDisplay(new StringDisplayImpl("Hello Design Pattern!"));
        RandomDisplay rd = new RandomDisplay(new StringDisplayImpl("Hello Random Display!"));
        cd.multiDisplay(3);
        rd.randomDisplay(8);

        // 実装のクラス階層の追加
        Display fd = new Display(new FileDisplayImpl("bridge/sample.txt"));
        fd.display();
    }
}
