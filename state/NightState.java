package state;

public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() {};// コンストラクタはprivate

    public static NightState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour >= 9 && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("非常：夜間の金庫使用");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル使用（夜間）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の電話（夜間）");
    }
    
}
