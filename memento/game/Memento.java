package memento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Memento implements Serializable {
    int money;// 所持金
    ArrayList<String> fruits;// フルーツ

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    @SuppressWarnings("unchecked")
    List<String> getFruit() {
        return (List<String>) fruits.clone();
    }
}
