package state;

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState() {};// コンストラクタはprivate

    public static DayState getInstance() {// システム内で唯一のDayStateインスタンスを得る
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recording("金庫使用（昼間）");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル使用（昼間）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の電話（昼間）");
    }
    
    public String toString() {
        return "[昼間]";
    }
}
