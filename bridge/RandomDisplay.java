package bridge;

import java.util.Random;

public class RandomDisplay extends CountDisplay {
    private Random rand = new Random();

    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int upperTimes) {;
        multiDisplay(rand.nextInt(upperTimes));
    }
}
