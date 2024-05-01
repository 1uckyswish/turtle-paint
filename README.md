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
 

<img width="1440" alt="Screenshot 2024-05-01 at 10 28 22 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/f108d964-314c-472b-af3a-ed1d7650662e">

  <img width="1440" alt="Screenshot 2024-05-01 at 10 28 38 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/afd87ce2-3c40-4e47-ac22-ac547c1b132c">

<img width="1440" alt="Screenshot 2024-05-01 at 10 28 57 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/0192116a-9917-4f45-bb48-a5b644e46dc7">

<img width="1440" alt="Screenshot 2024-05-01 at 10 29 23 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/3ac19e4a-3933-483f-b73f-5c56bd0ef3e6">

<img width="1440" alt="Screenshot 2024-05-01 at 10 29 32 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/6406639e-905a-482f-990a-85b89c15c0d5">

### Phase 4 - Error Handling

#### Error Handling for Saving and Opening Paintings
- Ensure that the application checks if there are shapes to save before proceeding with saving the painting to a CSV file. If the canvas is empty or no shapes have been drawn, prompt the user with an appropriate message indicating that there are no shapes to save.
- Implement error handling to address scenarios where the user selects a shape option that is not provided in the menu. If the user enters an invalid shape option, display an error message and prompt the user to choose a valid option from the menu.

#### Implementation Details
- **Error Handling for Saving Painting**:
  - Check if the list of shapes is empty before attempting to save the painting.
  - Display a message if no shapes are present, informing the user that there are no shapes to save.
- **Error Handling for Selecting Shape Option**:
  - Validate user input when selecting a shape option from the menu.
  - If the user enters an invalid option, display an error message and prompt the user to choose a valid option from the menu.

<img width="1440" alt="Screenshot 2024-05-01 at 10 33 18 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/6da7b1e2-f97f-41ba-9f9f-106490893297">

<img width="1440" alt="Screenshot 2024-05-01 at 10 33 26 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/67ee64a6-cd23-42fb-ab38-651b2cdefafe">

### Phase 5 - Interesting Code Features

Using a HashMap in the createColorMap() method efficiently maps string representations of color names to their respective Color objects. With its key-value pair structure, each color name is directly associated with its corresponding Color object, enabling fast retrieval.

<img width="1440" alt="Screenshot 2024-05-01 at 10 37 19 AM" src="https://github.com/1uckyswish/turtle-paint/assets/107442415/e4e93247-6576-4d40-ba99-edae197e2a40">


