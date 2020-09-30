import java.util.*;
import java.awt.*;

public class CircleFactory {
    public static final HashMap<Color, CircleColor> circlesByColor = new HashMap<Color, CircleColor>();

    public static CircleColor getColor(Color color) {
        CircleColor circleColor = circlesByColor.get(color);

        if(circleColor == null) {
            circleColor = new CircleColor(color);
            circlesByColor.put(color, circleColor);
        }
        return circleColor;
    }
}
