package adapter;

import java.io.IOException;

public class ExecuteAdapter {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("./adapter/file.txt");
            f.setValue("year", "2018");
            f.setValue("month", "3");
            f.setValue("day", "15");
            f.writeToFile("./adapter/newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
