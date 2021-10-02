package decorator;

public class ExecuteDecorator {
    public static void main(String[] args) {
        // 一行の文字列を表示
        Display b1 = new StringDisplay("Hello world!");
        b1.show();

        // 左右に装飾
        Display b2 = new SideBorder(b1, '#');
        b2.show();

        // 周囲に装飾
        Display b3 = new FullBorder(b2);
        b3.show();

        // 何重にも装飾
        Display b4 = new FullBorder(
            new FullBorder(
                new SideBorder(
                    new FullBorder(
                        new StringDisplay("rich decoration!")
                    ),
                    '/')
            )
        );
        b4.show();

        // 複数行の文字列を表示
        MultiStringDisplay md1 = new MultiStringDisplay();
        md1.add("こんにちは。");
        md1.add("私はたかしと申します。");
        md1.add("これからよろしくお願いします。");
        
        Display md2 = new FullBorder(md1);
        md2.show();
    }
}
