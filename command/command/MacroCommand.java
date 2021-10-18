package command.command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
    private Stack<Command> commands = new Stack<>();// 命令の集合

    @Override
    public void execute() {// 命令を順番に実行
        Iterator<Command> it = commands.iterator();
        while (it.hasNext()) {
            ((Command) it.next()).execute();
        }
    }

    public void append(Command cmd) {// 命令を追加
        if (cmd != this) {// 自分自身を追加してしまうと、execute()で無限ループになる
            commands.push(cmd);
        }
    }

    public void undo() {// 最後の命令を削除
        if (!commands.empty()) {
            commands.pop();
        }
    }

    public void clear() {// 命令の全件削除
        commands.clear();
    }
    
}
