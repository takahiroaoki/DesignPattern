package proxy;

public class Printer implements Printable {
    private String name;

    public Printer(String name) {
        this.name = name;
        heavyJob("Printerのインスタンス（" + name + "）を生成中。");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {// 名前付きで表示
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(String msg) {// なんらかの重い作業
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(".");
        }
        System.out.println("完了");
    }
    
}
