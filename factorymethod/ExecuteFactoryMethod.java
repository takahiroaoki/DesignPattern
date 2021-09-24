package factorymethod;

import java.util.List;

import factorymethod.framework.Factory;
import factorymethod.framework.Product;
import factorymethod.idcard.IDCardFactory;

public class ExecuteFactoryMethod {
    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product card1 = factory.create("Nobita");
        Product card2 = factory.create("Takeshi");
        Product card3 = factory.create("Shizuka");
        card1.use();
        card2.use();
        card3.use();
        factory.registerProduct(card1);
        factory.registerProduct(card2);
        factory.registerProduct(card3);
        System.out.println(factory.getOwnerMap().toString());
    }
}
