package com.pluralsight.shapes;

import com.pluralsight.forms.Turtle;

import java.awt.*;

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
}
