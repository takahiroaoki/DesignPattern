package prototype;

import prototype.framework.Product;
import prototype.framework.Manager;

public class Main {
    public static void main(String[] args) {
        // 登録
        Manager manager = new Manager();
        MessageBox messageBox = new MessageBox('*');
        UnderlinePen underlinePen = new UnderlinePen('-');
        manager.register("mb", messageBox);
        manager.register("ul", underlinePen);

        // 生成
        Product p1 = manager.create("mb");
        p1.use("Message Box");
        Product p2 = manager.create("ul");
        p2.use("Underlined Word");
    }
}
