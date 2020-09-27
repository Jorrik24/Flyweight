import java.util.*;
import java.awt.*;

public class CircleFactory {
    private static final HashMap<Color, Circle> circlesByColor = new HashMap<Color, Circle>();

    public static Circle getCircle(Color color) {
        Circle circle = (Circle)circlesByColor.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circlesByColor.put(color, circle);
        }
        return circle;
    }
}
