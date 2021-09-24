package factorymethod.idcard;

import factorymethod.framework.Product;

public class IDCard extends Product {
    private int id;
    private String owner;
    IDCard(int id, String owner) {
        System.out.println(id + ": " + owner + "のIDカードを作成します。");
        this.id = id;
        this.owner = owner;
    }
    @Override
    public void use() {
        System.out.println(id + ": " + owner + "のIDカードを使います。");
    }

    public int getID() {
        return this.id;
    }

    public String getOwner() {
        return this.owner;
    }
}
