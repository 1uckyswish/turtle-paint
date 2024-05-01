package com.pluralsight.shapes;

import com.pluralsight.forms.Turtle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape {
    private int radius;

    public Circle(Point location, Color color, int border, int radius) {
        super(location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint(Turtle turtle) {
        // Calculate the coordinates for drawing the circle
        // Here, it calculates the x and y coordinates based on the provided
        // convert from decimal to int
        int x = (int) location.getX();
        int y = (int) location.getY();
        int diameter = radius * 2;

        // Move the turtle to the starting position
        turtle.penUp();
        // * Stops the turtle from leaving a trail.
        turtle.goTo(x + radius, y); // Move to the right edge of the circle
        turtle.turnRight(90); // Turn the turtle to face upwards
        // * Causes the turtle to leave a trail.
        turtle.penDown();

        // Set the color and draw the circle
        turtle.setColor(color);
        // Loops to draw every line of a circle and draws each radius of the circle
        for (int i = 0; i < 36; i++) { // Reduce the number of steps to 36
            turtle.forward(diameter * Math.PI / 18); // Divide 360 by 36
            turtle.turnRight(10); // Divide 360 by 36
        }
        // Finally, the pen is lifted up to stop drawing.
        turtle.penUp();
    }

    @Override
    public String toString() {
        return String.format("circle|%d|%d|%d|%s|%d",
                (int) location.getX(),
                (int) location.getY(),
                border,
                colorToString(color),
                radius);
    }

}
