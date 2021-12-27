package state;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecuritySystem extends Frame implements ActionListener, Context {
    private State state = DayState.getInstance();// 現在の状態

    private TextField textClock = new TextField(60);// 時刻表示
    private TextArea textScreen = new TextArea(10, 60);// 警備センサ出力
    private Button buttonUse = new Button("金庫使用");// 金庫使用ボタン
    private Button buttonAlarm = new Button("非常ベル");// 非常ベルボタン
    private Button buttonPhone = new Button("通常通話");// 通常通話ボタン
    private Button buttonExit = new Button("終了");// 終了ボタン

    public SecuritySystem(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock配置
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreen配置
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // パネルにボタンを格納
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);//そのパネルを配置
        // 表示
        pack();
        setVisible(true);
        // リスナーの設定
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    @Override
    public void setClock(int hour) {
        String clockString = "現在時刻は";
        if (hour < 10) {
            clockString += "0" + hour + ":00";
        } else {
            clockString += hour + ":00";
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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());

        if (e.getSource() == buttonUse) {
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        } else {
            System.out.println("What do you mean?");
        }
    }
}
