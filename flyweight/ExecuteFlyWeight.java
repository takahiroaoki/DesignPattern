package flyweight;

public class ExecuteFlyWeight {
    private static BigString[] bsArray = new BigString[10];

    public static void main(String[] args) {
        // インスタンスを共有する場合
        System.out.println("インスタンスを共有した場合");
        testAllocation(true);
        // インスタンスを共有しない場合
        System.out.println("インスタンスを共有しない場合");
        testAllocation(false);
    }

    public static void testAllocation(Boolean isShared) {
        String string = "0028135321543";
        for (int i = 0; i < bsArray.length; i++) {// インスタンスの重複が増えるほど、共有するメリットが大きい。
            bsArray[i] = new BigString(string, isShared);
        }
        showMemory();
        
    }

    public static void showMemory() {
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用メモリ = " + usedMemory);
    }
}
