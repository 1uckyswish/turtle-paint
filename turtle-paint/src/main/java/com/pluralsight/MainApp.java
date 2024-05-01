package com.pluralsight;

import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;
import com.pluralsight.shapes.Circle;
import com.pluralsight.shapes.Shape;
import com.pluralsight.shapes.Square;
import com.pluralsight.shapes.Triangle;

import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class MainApp {
    // Declare a global scanner for the entire application
    static Scanner scanner = new Scanner(System.in);
    // A collection of colors used to style the turtle
    // Takes a string value of color (e.g., "RED") with the corresponding Color representation
    static Map<String, Color> colorMap = createColorMap();
    // Boolean flag to check if any shapes have been created to save
    static boolean shapesAdded = false; // Initialize to false
    static World world; // Define world at the class level
    // An ArrayList that holds all shapes created by the turtle
    static List<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        // Run the program
        displayHomeScreen();
    }

    // Method to display the main menu and handle user input
    public static void displayHomeScreen() {
        System.out.println("Welcome to Turtle Painter");
        System.out.println("1) Add Shape");
        System.out.println("2) Save Image");
        System.out.println("3) Save Painting");
        System.out.println("4) Open Painting");
        System.out.println("0) Exit");
        System.out.print("Please Choose: ");

        // Collect user's choice
        String userOption = scanner.nextLine().trim();

        switch (userOption) {
            case "1":
                addShape();
                break;
            case "2":
                saveImage();
                break;
            case "3":
                writeToFile();
                break;
            case "4":
                readFromFile();
                break;
            case "0":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Sorry, please choose one of the options above");
                displayHomeScreen();
        }
    }

    // Method to read shape data from a CSV file and repaint each shape
    public static void readFromFile(){
        String fileName = "paint.csv";
        try{
            // Create a reader and specify the file to read from
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // Skip the first three lines (CSV headers)
            for (int i = 0; i < 3; i++) {
                reader.readLine();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by the pipe character
                String[] shapeInfo = line.split(Pattern.quote("|"));
                paintShape(shapeInfo); // Paint each shape on a new canvas
            }
            reader.close(); // Close the reader when done
        } catch (Exception e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to paint a shape based on the provided data
    public static void paintShape(String[] shapeInfo) {
        if (shapeInfo.length < 6) {
            System.out.println("Invalid shape information: " + Arrays.toString(shapeInfo));
            return;
        }
        int x = Integer.parseInt(shapeInfo[1]);
        int y = Integer.parseInt(shapeInfo[2]);
        Color color = colorMap.get(shapeInfo[4]);
        int border = Integer.parseInt(shapeInfo[3]);
        int radius = Integer.parseInt(shapeInfo[5]);

        World world = new World(1200, 800); // Create a new canvas for each shape
        Turtle turtle = new Turtle(world);

        // Determine the shape type and paint it accordingly
        switch (shapeInfo[0]) {
            case "square":
                Square square = new Square(new Point(x, y), color, border);
                square.paint(turtle);
                break;
            case "circle":
                Circle circle = new Circle(new Point(x, y), color, border, radius);
                circle.paint(turtle);
                break;
            case "triangle":
                Triangle triangle = new Triangle(new Point(x, y), color, border);
                triangle.paint(turtle);
                break;
            default:
                System.out.println("Unknown shape type: " + shapeInfo[0]);
        }
    }

    // Method to write created shapes to a CSV file
    public static void writeToFile() {
        String fileName = "paint.csv";
        File file = new File(fileName);

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            // Write the headers if the file is empty or doesn't exist
            if (!file.exists() || file.length() == 0) {
                writer.write("width|height|background");
                writer.newLine();
                writer.write("1200|800|white");
                writer.newLine();
                writer.write("shape|x|y|border|color|width|height");
                writer.newLine();
            }
            // Loop through all the shapes in the ArrayList and write them to the CSV
            for (Shape shape : shapes) {
                writer.write(shape.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
            displayHomeScreen();
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    // Method to allow the user to choose which shape to create and draw
    public static void addShape() {
        System.out.print("Which shape (1. square, 2. circle, 3. triangle)? ");
        String userShapeOption = scanner.nextLine().trim();

        // Validate user input
        if (!userShapeOption.equals("1") && !userShapeOption.equals("2") && !userShapeOption.equals("3")) {
            System.out.println("Invalid input. Please choose one of the three shapes");
            displayHomeScreen();
            return; // Exit method
        }

        int userRadius = 0;
        // If the user chooses a circle, prompt for the radius since it's needed to draw a circle
        if (userShapeOption.equals("2")) {
            System.out.print("What is the radius? ");
            userRadius = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }

        // Get border width
        System.out.print("What is the border width? ");
        int userBorder = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Get color for the outline
        System.out.print("What is the border color? ");
        String userColor = scanner.nextLine().trim().toUpperCase();
        Color shapeColor = colorMap.getOrDefault(userColor, Color.BLACK); // Get Color from the map,
        // default to BLACK if not found

        // Get location to draw the shape
        System.out.println("What is the location of the shape (x,y)?");
        System.out.print("X: ");
        int userX = scanner.nextInt();
        System.out.print("Y: ");
        int userY = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create a new canvas for each shape
        if (world == null) {
            world = new World(1200, 800); // Initialize the world with width and height
        }
//        World world = new World(1200, 800); // Create a new canvas for each shape
        Turtle turtle = new Turtle(world);

        // Depending on what the user chooses as the shape to draw, call the respective shape constructor
        switch (userShapeOption) {
            case "1":
                Square square = new Square(new Point(userX, userY), shapeColor, userBorder);
                // Call method to draw the shape
                square.paint(turtle);
                // Append the newly made object to the ArrayList to hold all shapes made
                shapes.add(square);
                shapesAdded = true; // Set shapesAdded to true after a shape is added
                displayHomeScreen();
                break;
            case "2":
                Circle circle = new Circle(new Point(userX, userY), shapeColor, userBorder, userRadius);
                // Call method to draw the shape
                circle.paint(turtle);
                // Append the newly made object to the ArrayList to hold all shapes made
                shapes.add(circle);
                shapesAdded = true; // Set shapesAdded to true after a shape is added
                displayHomeScreen();
                break;
            case "3":
                Triangle triangle = new Triangle(new Point(userX, userY), shapeColor, userBorder);
                // Call method to draw the shape
                triangle.paint(turtle);
                // Append the newly made object to the ArrayList to hold all shapes made
                shapes.add(triangle);
                shapesAdded = true; // Set shapesAdded to true after a shape is added
                displayHomeScreen();
                break;
        }
    }

    // Method to save the created shape to your local files
    public static void saveImage() {
        if (!shapesAdded) { // Check if shapes have been added
            System.out.println("No shapes added yet. Nothing to save.");
            displayHomeScreen();
        }

        if (world == null) { // Check if the world object is null
            System.out.println("Error: World object is null.");
            displayHomeScreen();
        }

        // Get a local date to save the image based on when it's created
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        // Call the method that saves the image to a local file, found in the World object
        world.saveAs("/Users/butterflycoupe/Desktop/YearUp/turtle-paint/canvas/" + formattedDateTime + ".png");
        System.out.println("Image saved successfully!");
        displayHomeScreen();
    }

    // Method to create a map that holds all the colors to be used within the objects,
    // This method is used to retrieve values when calling the constructor and printing the object to string
    public static Map<String, Color> createColorMap() {
        Map<String, Color> map = new HashMap<>();
        map.put("BLACK", Color.BLACK);
        map.put("BLUE", Color.BLUE);
        map.put("CYAN", Color.CYAN);
        map.put("DARK_GRAY", Color.DARK_GRAY);
        map.put("GRAY", Color.GRAY);
        map.put("GREEN", Color.GREEN);
        map.put("LIGHT_GRAY", Color.LIGHT_GRAY);
        map.put("MAGENTA", Color.MAGENTA);
        map.put("ORANGE", Color.ORANGE);
        map.put("PINK", Color.PINK);
        map.put("RED", Color.RED);
        map.put("WHITE", Color.WHITE);
        map.put("YELLOW", Color.YELLOW);
        return map;
    }
}
