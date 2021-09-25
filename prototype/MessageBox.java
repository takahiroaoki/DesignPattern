package prototype;

import prototype.framework.Product;

public class MessageBox extends Product {
    private char decoChar;
    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }
    @Override
    public void use(String s) {
        int width = getWidth(s);
        for (int i = 0; i < width + 4; i++) {
            System.out.print(this.decoChar);
            if (i == width + 3) {
                System.out.println();
            }
        }
        System.out.println(this.decoChar + " " + s + " " + this.decoChar);
        for (int i = 0; i < width + 4; i++) {
            System.out.print(this.decoChar);
            if (i == width + 3) {
                System.out.println();
            }
        }
    }
}
