package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {

    private static String dbName = "maildata";
    private static Properties prop;

    private PageMaker() {// インスタンスは作らないのでprivateに。
    }

    public static void makeWelcomPage(String mailAddress, String fileName) {
        try {
            prop = Database.getProperties(dbName);
            String userName = prop.getProperty(mailAddress);
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Welcome to " + userName + "'s page!");
            writer.paragraph(userName + "のページへようこそ！");
            writer.paragraph("メール待っていますね");
            writer.mailTo(mailAddress, userName);
            writer.close();
            System.out.println(fileName + " is created for " + mailAddress + "(" + userName + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String fileName) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Link Page");
            prop = Database.getProperties(dbName);
            String userName = null;
            for (Object mailAddress: prop.keySet()) {
                userName = prop.getProperty((String) mailAddress);
                writer.mailTo((String) mailAddress, userName);
            }
            writer.close();
            System.out.println(fileName + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
