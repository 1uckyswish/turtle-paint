package com.pluralsight;

import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;
import com.pluralsight.shapes.*;

import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        // Get the screen dimensions

        // Create the world with the screen dimensions
        World world = new World(1200, 800);

        Turtle turtle = new Turtle(world);

        // Create a circle instance
        Circle circle = new Circle(new Point(50, 150), Color.RED, 2, 50);

        // Draw the circle on the canvas
        circle.paint(turtle);

        Square square = new Square(new Point(200, 120), Color.BLUE, 2);
        square.paint(turtle);
    }
}
