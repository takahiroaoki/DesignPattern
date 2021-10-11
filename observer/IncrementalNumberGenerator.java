package observer;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;// 現在の値

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 10; i ++) {
            number++;
            notifyObservers();
        }
    }
    
}
