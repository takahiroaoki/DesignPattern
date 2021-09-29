package bridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplayImpl extends DisplayImpl {
    private String filePath;
    private BufferedReader reader;
    private final int READAHEAD_LIMIT = 4096;

    public FileDisplayImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void rawOpen() {
        try {
            reader = new BufferedReader(new FileReader(filePath));
            reader.mark(READAHEAD_LIMIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=-=-=-=-=-=-=-=-=-" + filePath + "=-=-=-=-=-=-=-=-=-");
    }
    @Override
    public void rawPrint() {
        try {
            String line;
            reader.reset();
            while((line = reader.readLine()) != null) {
                System.out.println(">" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void rawClose() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
