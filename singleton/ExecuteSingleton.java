package singleton;

public class ExecuteSingleton {
    public static void main(String[] args) {
        // Singletonパターン検証
        Singleton single1 = Singleton.getInstance();
        Singleton single2 = Singleton.getInstance();
        if (single1 == single2) {
            System.out.println("single1とsingle2は同一インスタンスです。");
        } else {
            System.out.println("single1とsingle2は別のインスタンスです。");
        }

        // Tripletonパターン検証
        for (int i = 0; i < 9; i++) {
            Tripleton tripleton = Tripleton.getInstance(i % 3);
            System.out.println(i + ": " + tripleton);
        }
    }
}
