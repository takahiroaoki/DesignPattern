package command;

import javax.swing.*;
import java.awt.event.*;

import command.command.*;
import command.drawer.*;

public class ExecuteCommand extends JFrame implements ActionListener {
    private MacroCommand history = new MacroCommand();// 描画履歴
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);// 描画領域
    private JButton clearButton = new JButton("clear");
    private JButton undoButton = new JButton("undo");

    public ExecuteCommand(String title) {
        super(title);

        // WindowAdapterクラスはWindowListenerインターフェースを空メソッドで実装したクラス
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // MouseMotionAdapterクラスはMouseMotionListenerインターフェースを空メソッドで実装したクラス
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExecuteCommand("Command Pattern Sample");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        } else if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        }
    }
}
