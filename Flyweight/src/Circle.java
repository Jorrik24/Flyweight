import java.awt.*;

public class Circle {
    private CircleColor color;
    private int x, y, x2, y2;

    public Circle(CircleColor color, int x, int y, int x2, int y2) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        g.setColor(color.color);
        g.fillOval(x, y, x2, y2);
    }
}
