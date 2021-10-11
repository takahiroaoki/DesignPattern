package observer;

import java.util.Random;

public class ExecuteObserver {
    public static void main(String[] args) {
        /**
         * 使い方
         * javac observer/ExecuteObserver.java
         * したうえで、
         * java observer/ExecuteObserver random
         * か
         * java observer/ExecuteObserver incremental
         * と実行
         */

        if (args.length != 1 || (!args[0].equals("random") && !args[0].equals("incremental"))) {
            System.out.println("Usage:");
            System.out.println("javac observer/ExecuteObserver.java");
            System.out.println("としたうえで、");
            System.out.println("java observer/ExecuteObserver random");
            System.out.println("か");
            System.out.println("java observer/ExecuteObserver incremental");
            System.out.println("と実行");
        } else {

            NumberGenerator generator = null;

            if (args[0].equals("random")) {
                generator = new RandomNumberGenerator();
            } else if (args[0].equals("incremental")) {
                generator = new IncrementalNumberGenerator();
            }

            Observer observer1 = new DigitObserver();
            Observer observer2 = new GraphObserver();
            generator.addObserver(observer1);
            generator.addObserver(observer2);
            generator.execute();

        }
    }
}
