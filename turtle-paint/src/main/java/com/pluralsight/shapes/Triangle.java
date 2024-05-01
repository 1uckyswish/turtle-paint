package com.pluralsight.shapes;

import com.pluralsight.forms.Turtle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends Shape {
    private static final int SIDE_LENGTH = 300; // constant side length for triangle

    public Triangle(Point location, Color color, int border) {
        super(location, color, border);
    }

    @Override
    public void paint(Turtle turtle) {
        // Calculate the coordinates for drawing the triangle
        // Here, it calculates the x and y coordinates based on the provided
        // convert from decimal to int
        int x = (int) location.getX();
        int y = (int) location.getY();

        // Move the turtle to the starting position
        // * Stops the turtle from leaving a trail.
        turtle.penUp();
        turtle.goTo(x - SIDE_LENGTH / 2, y - (int) (Math.sqrt(3) * SIDE_LENGTH / 6)); // Move to the left corner of the
        // base
        turtle.turnRight(30); // Turn the turtle to face upwards
        // * Causes the turtle to leave a trail.
        turtle.penDown();

        // Set the color and draw the triangle
        turtle.setColor(color);
        // Loops three times and draws each side of the triangle
        for (int i = 0; i < 3; i++) {
            turtle.forward(SIDE_LENGTH);
            turtle.turnRight(120);
        }
        // Finally, the pen is lifted up to stop drawing.
        turtle.penUp();
    }

    @Override
    public String toString() {
        return String.format("triangle|%d|%d|%d|%s|%d|%d",
                (int) location.getX(),
                (int) location.getY(),
                border,
                colorToString(color),
                SIDE_LENGTH,
                SIDE_LENGTH);
    }
}
