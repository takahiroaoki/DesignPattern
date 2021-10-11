package observer;

public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DigitObserver: " + generator.getNumber());
    }
    
}
