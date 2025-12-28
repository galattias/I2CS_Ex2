package assignments.Ex2;

public class Index2D implements Pixel2D {
    private int _x, _y;

    // Standard constructor
    public Index2D(int x, int y) {
        _x = x;
        _y = y;
    }

    // Copy constructor
    public Index2D(Pixel2D other) {
        this(other.getX(), other.getY());
    }

    @Override
    public int getX() {
        return _x;
    }

    @Override
    public int getY() {
        return _y;
    }

    @Override
    public double distance2D(Pixel2D p2) {
        if (p2 == null) {
            throw new RuntimeException("The other pixel (p2) cannot be null.");
        }
        // Using the Euclidean distance formula: sqrt((x1-x2)^2 + (y1-y2)^2)
        int dx = this._x - p2.getX();
        int dy = this._y - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return _x + "," + _y;
    }

    @Override
    public boolean equals(Object p) {
        if (p == null || !(p instanceof Pixel2D)) {
            return false;
        }
        Pixel2D other = (Pixel2D) p;
        return _x == other.getX() && _y == other.getY();
    }
}