package state;

public class ExecuteState {
    public static void main(String[] args) {
        SecuritySystem securitySystem = new SecuritySystem("State Sample");
        while (true) {
            for (int i = 0; i < 24; i++) {
                securitySystem.setClock(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
