package memento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import memento.game.Gamer;
import memento.game.Memento;

public class ExecuteMemento {
    public static final String SAVE_FILE_NAME = "memento/gameData.dat";

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);// 最初の所持金は100
        Memento memento = loadMemento();// ファイルからロード

        if (memento != null) {
            System.out.println("前回のセーブポイントからスタートします。");
            gamer.restoreMemento(memento);
        } else {
            System.out.println("新規にスタートします。");
            memento = gamer.createMemento();
        }

        memento = gamer.createMemento();// 最初の状態を保存しておく
        for (int i = 0; i < 10; i++) {
            System.out.println("==== " + i);// 回数表示
            System.out.println("現状: " + gamer.toString());//主人公の現状を表示

            gamer.bet();// ゲームを勧める

            System.out.println("所持金は" + gamer.getMoney() + "円になりました。");

            // 結果に応じてMementoの取り扱いの決定
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("前回のセーブポイントより所持金が増えたので現状を保存します。");
                memento = gamer.createMemento();
                saveMemento(memento);// ファイルに保存
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("所持金がだいぶ減ったので、前回のセーブポイントからやり直します。");
                gamer.restoreMemento(memento);
            }

            // 時間待ち
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }

    public static void saveMemento(Memento memento) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_NAME));
            out.writeObject(memento);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Memento loadMemento() {
        Memento memento = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE_NAME));
            memento = (Memento) in.readObject();
            in.close();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return memento;
    }
}
