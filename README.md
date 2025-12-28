# My 2D Map & Maze Project (Ex2)

Hi! This is my second assignment for the Intro to CS course. In this project, I worked on implementing different algorithms for 2D maps and mazes using Java. 

The main goal was to handle a grid of pixels and write logic for things like finding the shortest path and filling areas with color, similar to how a "paint" bucket tool works.

## What I implemented:
* **Shortest Path**: I used a BFS (Breadth-First Search) approach to find the quickest way to get from point A to point B without hitting any obstacles.
* **Flood Fill**: This algorithm starts at a specific pixel and "spreads" a new color to all connected pixels that have the same original color.
* **Shape Drawing**: I added functions to draw lines, circles, and rectangles directly onto the map grid.
* **GUI Visualization**: I used the StdDraw library to create a window that actually shows the map and the results of the algorithms.

## How it's organized:
* **Map.java**: This is where most of my logic lives, including the BFS algorithms.
* **Index2D.java**: A simple class to manage (x, y) coordinates.
* **Testing**: I wrote JUnit tests (MapTest and Index2DTest) to make sure my code actually works and handles edge cases.

## Documentation
I added detailed comments in English throughout the Map.java file to explain how the logic works.
