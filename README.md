# My 2D Map & Maze Project (Ex2)

Hi! This is my third assignment for the Intro to CS course. In this project, I implemented various algorithms for 2D maps and mazes using Java, focusing on Object-Oriented Programming and grid-based logic.

The goal of this assignment was to manage a grid of pixels and write logic for pathfinding and area filling, similar to how a "paint" bucket tool works in graphic software.

## What I implemented:
* **Shortest Path**: I used a BFS (Breadth-First Search) approach to find the quickest way to get from point A to point B while avoiding obstacles.
* **Flood Fill**: This algorithm starts at a specific pixel and "spreads" a new color to all connected pixels that share the same original color.
* **Shape Drawing**: I added functions to draw lines, circles, and rectangles directly onto the map grid based on coordinate distances.
* **GUI & Visualization**: For the graphical interface, I used the `StdDraw` library (added from the `classes.week4` package) to create a window that displays the map and algorithm results.

## Project Organization:
* **Map.java**: This is the main class where I implemented the Map2D interface and all the BFS logic.
* **Index2D.java**: A class I implemented to handle (x, y) coordinates and Euclidean distances.
* **Testing**: I built a JUnit testing suite, including `MapTest` and a new `Index2DTest` class, to ensure the code handles all scenarios correctly.

## Documentation
I have included detailed English documentation inside `Map.java` to explain the logic behind the algorithms and methods used.
