package prototype;

import prototype.framework.Product;

public class UnderlinePen extends Product {
    private char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }

    @Override
    public void use(String s) {
        int width = getWidth(s);
        System.out.println('"' + s + '"');
        System.out.print(" ");
        for (int i = 0; i < width; i++) {
            System.out.print(this.ulChar);
        }
        System.out.println(" ");
    }
}
