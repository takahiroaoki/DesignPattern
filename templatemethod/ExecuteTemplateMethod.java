package templatemethod;

public class ExecuteTemplateMethod {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello Design Pattern!");
        AbstractDisplay d3 = new StringDisplay("日本語の表示は？");
        d1.display();
        d2.display();
        d3.display();
    }
}
