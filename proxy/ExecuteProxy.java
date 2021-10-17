package proxy;

public class ExecuteProxy {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        p.print("Hello, I'm " + p.getPrinterName());
        p.setPrinterName("Bob");
        p.print("Hello, I'm " + p.getPrinterName());
    }
}
