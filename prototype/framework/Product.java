package prototype.framework;

public abstract class Product implements Cloneable {
    public abstract void use(String s);
    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
    protected int getWidth(String str) {
        // 半角は1文字、全角は2文字分として文字列の長さを返す
        
        // 文字列の長さのカウンタ
        int w = 0;
        
        //全角半角判定
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(String.valueOf(c[i]).getBytes().length <= 1){
                w += 1; //半角文字なら＋１
            }else{
                w += 2; //全角文字なら＋２
            }
        }
        return w;
    }
}