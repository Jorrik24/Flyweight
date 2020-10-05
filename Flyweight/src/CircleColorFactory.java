import java.util.*;
import java.awt.*;

public class CircleColorFactory {
    public static final HashMap<Color, CircleColor> circlesByColor = new HashMap<Color, CircleColor>();

    public static CircleColor getCircleColor(Color color) {
        CircleColor circleColor = circlesByColor.get(color);

        if(circleColor == null) {
            circleColor = new CircleColor(color);
            circlesByColor.put(color, circleColor);
        }
        return circleColor;
    }
}
