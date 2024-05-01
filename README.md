# Turtle Paint Simple Drawing Application

## Description
This Java project involves creating a basic drawing application akin to MS-Paint, building upon the TurtlePaint project. Instead of directly implementing shape-drawing logic, the project emphasizes object-oriented programming principles like inheritance and abstraction.

Using Java classes with inheritance, we establish a structured relationship among shapes, with a base class 'Shape' serving as the foundation. Subclasses such as Circle, Triangle, and Square inherit properties and behaviors from the Shape class, promoting code organization and reusability.

Through abstraction, essential shape characteristics are encapsulated, ensuring a modular and flexible design. This approach facilitates the creation and manipulation of shapes on the canvas while promoting code efficiency and scalability.
## Getting Started Main Class (Home)
This is the heart of our Turtle Paint project. The Main class manages all store functionalities. Check out the Maven Java folder structure on the left to see how the project is organized.
<img width="1440" alt="Screenshot 2024-05-01 at 9 55 59 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/cc7b8e34-c1a0-461d-b864-422d6a93b00b">

## Programming Process
- Defined classes include:
  - Shape (abstract)
    - turtle: the turtle used for painting
    - location: the xy coordinate where the shape should be drawn
    - color: the color used for the border
    - border: the width of the shape border
    - paint(): method to paint the shape
  - Additional shape classes that extend Shape:
    - Square
    - Triangle
    - Circle
    - 
<img width="1440" alt="Screenshot 2024-05-01 at 9 56 28 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/c6fe9511-a412-4299-a146-0ed53c3ae905">

<img width="1440" alt="Screenshot 2024-05-01 at 9 56 55 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/f1e8c90f-9159-47b4-8700-40396fd51df8">

<img width="1440" alt="Screenshot 2024-05-01 at 9 57 05 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/0ee50ef6-668a-4d6b-ab25-2ef0aa8aec80">

<img width="1440" alt="Screenshot 2024-05-01 at 9 57 13 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/393f9191-3bb1-4981-b34c-a02cf25ad81f">

### Start of Program
This is the main screen of the Turtle Paint interface, offering users a variety of options to explore.

<img width="1440" alt="Screenshot 2024-05-01 at 9 57 43 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/24cad274-5f8f-4d67-a8f0-a50f30aa624b">

### Phase 2 - Application Flow
- Prompt the user for the size of the world canvas upon application start.
- Display the Home Screen with options:
  1) Add Shape
  2) Save Image
  3) Save Painting
  4) Open Painting
  0) Exit
- When adding a new shape:
  - Prompt for shape details:
    - Shape type (1. Square, 2. Circle, 3. Triangle)
    - Radius (for circle)
    - Border width
    - Border color
    - Shape location (x, y)
  - Paint the shape to the canvas and display the Home Screen again.

<img width="1440" alt="Screenshot 2024-05-01 at 9 58 09 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/b3fab66e-d193-4205-9d4b-10e6d50f147a">


### Phase 3 - Saving and Opening Paintings

#### New Features
1. **Save Painting**
2. **Open Painting**

#### Functionality
- When the application starts, the user is prompted for the size of the world canvas.
- The Home Screen displays options:
  1) Add Shape
  2) Save Image
  3) Save Painting
  4) Open Painting
  0) Exit
#### Implementation Details
- **Save Painting**:
  - Iterate through the list of shapes and write the details of each shape to a CSV file.
  - The CSV file format includes canvas information on the first line and shape details on subsequent lines.
- **Open Painting**:
  - Read the contents of the selected CSV file.
  - Recreate the canvas based on canvas information from the file.
  - Paint each shape according to the stored details.
