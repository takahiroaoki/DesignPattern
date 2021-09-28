package abstractfactory;

import abstractfactory.factory.Factory;
import abstractfactory.factory.Link;
import abstractfactory.factory.Page;
import abstractfactory.factory.Tray;

public class ExecuteAbstractFactory {
    public static void main(String[] args) {
        /**
         * コンパイルして、引数を渡して実行する
         * javac abstractfactory/ExecuteAbstractFactory.java abstractfactory/listfactory/ListFactory.java
         * ex.) java abstractfactory/ExecuteAbstractFactory abstractfactory.listfactory.ListFactory
         */
        if (args.length != 1) {
            System.out.println("Usage: Java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: Java Main listfactory.ListFactory");
            System.out.println("Example 2: Java Main tablefactory.TableFactory");
            System.exit(0);
        }
        Factory factory = Factory.getFactory(args[0]);
        Link asahi = factory.createLink("朝日新聞", "https:///www.asahi.com/");
        Link yomiuri = factory.createLink("読売新聞", "https://www.yomiuri.co.jp/");
        Link us_yahoo = factory.createLink("Yahoo!", "https:///www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan", "https://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "https://www.excite.com/");
        Link google = factory.createLink("Google", "https://www.google.com/");

        Tray trayNews = factory.createTray("新聞");
        trayNews.add(asahi);
        trayNews.add(yomiuri);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(jp_yahoo);

        Tray traySearch = factory.createTray("サーチエンジン");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage("LinkPage", "Takahiro Aoki");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
