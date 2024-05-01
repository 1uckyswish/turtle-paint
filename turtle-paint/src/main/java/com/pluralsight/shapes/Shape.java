package com.pluralsight.shapes;

import com.pluralsight.forms.Turtle;

import java.awt.*;
import java.util.Map;

import static com.pluralsight.MainApp.createColorMap;

public abstract class Shape {
    protected Point location;
    protected Color color;
    protected int border;

    public Shape(Point location, Color color, int border) {
        this.location = location;
        this.color = color;
        this.border = border;
    }

    public abstract void paint(Turtle turtle);

    protected String colorToString(Color color) {
        if (color == null)
            return "unknown";

        // Map known colors to string representations
        Map<String, Color> colorMap = createColorMap();
        for (Map.Entry<String, Color> entry : colorMap.entrySet()) {
            if (entry.getValue().equals(color)) {
                return entry.getKey();
            }
        }

        // If the color is not found in the map, return "unknown"
        return "unknown";
    }
}
