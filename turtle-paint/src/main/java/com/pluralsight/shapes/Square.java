package com.pluralsight.shapes;

import com.pluralsight.forms.Turtle;
import java.awt.Color;
import java.awt.Point;
import java.util.Map;

import static com.pluralsight.MainApp.createColorMap;

public class Square extends Shape {
    private static final int SIDE_LENGTH = 200; // constant side length for square

    public Square(Point location, Color color, int border) {
        super(location, color, border);
    }

    @Override
    public void paint(Turtle turtle) {
        // Calculate the coordinates for drawing the square
        // Here, it calculates the x and y coordinates based on the provided
        // convert from decimal to int
        int x = (int) location.getX();
        int y = (int) location.getY();

        // Move the turtle to the starting position
        turtle.penUp();
        // * Stops the turtle from leaving a trail.
        turtle.goTo(x - SIDE_LENGTH / 2, y - SIDE_LENGTH / 2); // Move to the starting corner
        turtle.turnRight(90); // Turn the turtle to face right
        // * Causes the turtle to leave a trail.
        turtle.penDown();

        // Set the color and draw the square
        turtle.setColor(color);
        // Loops three four and draws each side of the square
        for (int i = 0; i < 4; i++) {
            turtle.forward(SIDE_LENGTH);
            turtle.turnRight(90);
        }
        // Finally, the pen is lifted up to stop drawing.
        turtle.penUp();
    }

    @Override
    public String toString() {
        return String.format("square|%d|%d|%d|%s|%d|%d",
                (int) location.getX(),
                (int) location.getY(),
                border,
                colorToString(color),
                SIDE_LENGTH,
                SIDE_LENGTH);
    }

}
