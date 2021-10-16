package state;

public class SecuritySystem implements Context {
    private State state = DayState.getInstance();// 現在の状態

    public SecuritySystem(String title) {
        // TODO: コンテナ内でGUIを使えるようにする
    }

    @Override
    public void setClock(int hour) {
        String clockString = "現在時刻は";
        if (hour < 10) {
            clockString += 0 + ":00";
        } else {
            clockString += ":00";
        }
        System.out.println(clockString);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state.toString() + "から" + state.toString() + "へ状態が変化しました");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        System.out.println(msg);
    }

    @Override
    public void recording(String msg) {
        System.out.println(msg);
    }
}
