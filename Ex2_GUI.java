package assignments.Ex2;

import java.awt.Color;

/**
 * GUI class for displaying and handling Map2D objects.
 */
public class Ex2_GUI {

    public static void drawMap(Map2D map) {
        int w = map.getWidth();
        int h = map.getHeight();
        StdDraw.setCanvasSize(w * 8, h * 8);
        StdDraw.setXscale(-0.5, w - 0.5);
        StdDraw.setYscale(-0.5, h - 0.5);
        StdDraw.enableDoubleBuffering();

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int val = map.getPixel(x, y);
                // Simple color mapping based on pixel value
                Color c = new Color(val % 256, (val * 2) % 256, (val * 3) % 256);
                StdDraw.setPenColor(c);
                StdDraw.filledSquare(x, y, 0.5);
            }
        }
        StdDraw.show();
    }

    public static Map2D loadMap(String mapFileName) {
        // Simple placeholder: in a real scenario, you'd read from a file.
        // For the assignment, you might need to implement text file reading here.
        return new Map(10, 10, 0);
    }

    public static void saveMap(Map2D map, String mapFileName) {
        // Simple placeholder for saving the map to a text file.
        System.out.println("Saving map to " + mapFileName);
    }

    public static void main(String[] a) {
        // Basic testing of the GUI
        Map m = new Map(50, 50, 0);
        m.drawCircle(new Index2D(25, 25), 15, 100);
        m.drawLine(new Index2D(0, 0), new Index2D(49, 49), 200);
        drawMap(m);
    }
}