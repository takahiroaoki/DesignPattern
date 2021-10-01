package strategy;

public class ExecuteStrategy {
    public static void main(String[] args) {
        int seed1 = 123;
        int seed2 = 456;
        
        Player player1 = new Player("Taro", new WinningStrategy(seed1));
        Player player2 = new Player("Hanako", new ProbStrategy(seed2));

        Hand nextHand1, nextHand2;
        for (int i = 0; i < 10000; i++) {
            nextHand1 = player1.nextHand();
            nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + player1.toString());
                player1.win();
                player2.lose();
            } else if (nextHand1.isWeakerThan(nextHand2)) {
                System.out.println("Winner: " + player2.toString());
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("================= Total Result =================");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
