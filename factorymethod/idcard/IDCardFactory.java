package factorymethod.idcard;

import java.util.HashMap;
import java.util.Map;

import factorymethod.framework.Factory;
import factorymethod.framework.Product;

public class IDCardFactory extends Factory {
    private Map<Integer, String> ownerMap = new HashMap<>();
    private int id = 0;

    @Override
    public synchronized Product createProduct(String owner) {
        return new IDCard(id++, owner);
    }

    @Override
    public void registerProduct(Product p) {
        IDCard card = (IDCard) p;
        ownerMap.put(card.getID(), card.getOwner());
    }

    public Map<Integer, String> getOwnerMap() {
        return this.ownerMap;
    }
}
