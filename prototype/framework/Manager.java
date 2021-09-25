package prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showCase = new HashMap<>();

    public void register(String name, Product proto) {
        showCase.put(name, proto);
    }

    public Product create(String protoName) {
        Product p = showCase.get(protoName);
        return p.createClone();
    }
}
