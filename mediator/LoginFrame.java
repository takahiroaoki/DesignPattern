package mediator;

import java.awt.Frame;
import java.awt.Color;
import java.awt.Label;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUserName;
    private ColleagueTextField textPassword;
    private ColleagueButton buttonOK;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        // Frameの設定
        super(title);
        super.setBackground(Color.lightGray);
        super.setLayout(new GridLayout(4, 2));// レイアウトマネージャを使って4×2のグリッドを作成

        // Colleagueたちを生成、配置し、表示する
        createColleagues();
        super.add(checkGuest);
        super.add(checkLogin);
        super.add(new Label("Username"));
        super.add(textUserName);
        super.add(new Label("Password"));
        super.add(textPassword);
        super.add(buttonOK);
        super.add(buttonCancel);

        // Colleagueたちの有効・無効を設定
        colleagueChanged();

        // 表示
        super.pack();
        super.setVisible(true);
    }

    @Override
    public void createColleagues() {
        // 生成
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUserName = new ColleagueTextField("", 10);
        textPassword = new ColleagueTextField("", 10);
        buttonOK = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // mediatorのセット
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUserName.setMediator(this);
        textPassword.setMediator(this);
        buttonOK.setMediator(this);
        buttonCancel.setMediator(this);

        // Listenerのセット
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUserName.addTextListener(textUserName);
        textPassword.addTextListener(textPassword);
        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {// Guestモード
            textUserName.setColleagueEnabled(false);
            textPassword.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(true);
        } else {// Loginモード
            textUserName.setColleagueEnabled(true);
            textPasswordChanged();
        }
    }

    private void textPasswordChanged() {
        if (textUserName.getText().length() > 0) {// ユーザー名に入力があるときパスワード欄は入力可能
            textPassword.setColleagueEnabled(true);
            if (textPassword.getText().length() > 0) {
                buttonOK.setColleagueEnabled(true);
            } else {
                buttonOK.setColleagueEnabled(false);
            }
        } else {// ユーザー名が未入力の時パスワード欄は入力不可
            textPassword.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 本来なら、キャンセルボタンかOKボタンかによってログイン処理などの処理を行う
        System.out.println(e.toString());
        System.exit(0);
    }

}
