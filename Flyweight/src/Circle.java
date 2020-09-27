import java.awt.*;

public class Circle {
    private Color color;

    public Circle(Color color) {
        this.color = color;
    }

    public void draw(Graphics g, int x, int y, int x2, int y2) {
        g.setColor(color);
        g.fillOval(x, y, x2, y2);
    }
}
