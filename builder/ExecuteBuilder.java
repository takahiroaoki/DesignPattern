package builder;

/*
javacコマンドででコンパイルしてから起動
*/
public class ExecuteBuilder {
    // javac ./builder/ExecuteBuilder.java
    // java ./builder/ExecuteBuilder (plain|html)
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }

        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            System.out.println(textBuilder.getResult());
        } else if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + "が作成されました。");
        } else {
            usage();
            System.exit(0);
        }
    }

    private static void usage() {
        System.out.println("Usage: java builder/ExecuteBuilder plain => プレーンテキストで文書作成");
        System.out.println("Usage: java builder/ExecuteBuilder html => HTMLファイルで文書作成");
    }

}
