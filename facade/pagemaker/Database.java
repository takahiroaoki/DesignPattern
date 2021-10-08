package facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Database {// 同パッケージからのみ（今回はPageMakerからのみ）使用可能
    private Database() {// newで呼び出されないようにprivateに。
    }

    public static Properties getProperties(String dbName) {
        // データベース名からプロパティを得る
        String fileName = "facade/" + dbName + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(fileName));
        } catch (IOException e) {
            System.out.println("Warning: " + fileName + " is not found.");
        }
        return prop;
    }
}