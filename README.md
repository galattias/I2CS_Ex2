# My 2D Map & Maze Project (Ex2)

Hi! [cite_start]This is my second assignment for the Intro to CS course (2026)[cite: 1, 2]. [cite_start]In this project, I worked on implementing different algorithms for 2D maps and mazes using Java[cite: 3, 11]. 

[cite_start]The main goal was to handle a grid of pixels and write logic for things like finding the shortest path and filling areas with color, similar to how a "paint" bucket tool works[cite: 2, 3].

## What I implemented:
* [cite_start]**Shortest Path**: I used a BFS (Breadth-First Search) approach to find the quickest way to get from point A to point B without hitting any obstacles[cite: 3, 13].
* [cite_start]**Flood Fill**: This algorithm starts at a specific pixel and "spreads" a new color to all connected pixels that have the same original color[cite: 3, 13].
* [cite_start]**Shape Drawing**: I added functions to draw lines, circles, and rectangles directly onto the map grid[cite: 12].
* [cite_start]**GUI Visualization**: I used the StdDraw library to create a window that actually shows the map and the results of the algorithms[cite: 14, 15].

## How it's organized:
* [cite_start]**Map.java**: This is where most of my logic lives, including the BFS algorithms[cite: 11, 13].
* [cite_start]**Index2D.java**: A simple class to manage (x, y) coordinates[cite: 10].
* [cite_start]**Testing**: I wrote JUnit tests (MapTest and Index2DTest) to make sure my code actually works and handles edge cases[cite: 5, 10, 12].

## Documentation
[cite_start]I added detailed comments in English throughout the Map.java file to explain how the logic works[cite: 13].
