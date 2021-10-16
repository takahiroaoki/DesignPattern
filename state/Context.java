package state;

public interface Context {
    public abstract void setClock(int hour);// 時刻の設定
    public abstract void changeState(State state);// 状態の変化
    public abstract void callSecurityCenter(String msg);// 警備センターへ電話
    public abstract void recording(String msg);// 警備センタ記録
}
