package command.drawer;

import command.command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
    protected Drawable drawable;// 描画対象
    private Point position;// 描画座標

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }

}
