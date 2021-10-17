package proxy;

public class PrinterProxy implements Printable {
    private String name;
    private Printer real;// Printerインスタンスの実物

    public PrinterProxy() {}
    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);// 実物にも名前を設定
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {// 実物がまだ生成されていなければ生成
        if (real == null) {
            real = new Printer(name);
        }
    }
    
}
