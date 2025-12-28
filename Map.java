package assignments.Ex2;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a 2D map of integers.
 * It supports drawing shapes and pathfinding algorithms like BFS.
 */
public class Map implements Map2D, Serializable {

	private int[][] _map;

	public Map(int w, int h, int v) { init(w, h, v); }
	public Map(int size) { this(size, size, 0); }
	public Map(int[][] data) { init(data); }

	@Override
	public void init(int w, int h, int v) {
		_map = new int[w][h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				_map[x][y] = v;
			}
		}
	}

	@Override
	public void init(int[][] arr) {
		if (arr == null || arr.length == 0 || arr[0] == null) {
			throw new RuntimeException("Array cannot be null or empty.");
		}
		_map = new int[arr.length][arr[0].length];
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[0].length; y++) {
				_map[x][y] = arr[x][y];
			}
		}
	}

	@Override
	public int[][] getMap() {
		int[][] copy = new int[getWidth()][getHeight()];
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				copy[x][y] = _map[x][y];
			}
		}
		return copy;
	}

	@Override
	public int getWidth() { return _map.length; }

	@Override
	public int getHeight() { return _map[0].length; }

	@Override
	public int getPixel(int x, int y) { return _map[x][y]; }

	@Override
	public int getPixel(Pixel2D p) { return getPixel(p.getX(), p.getY()); }

	@Override
	public void setPixel(int x, int y, int v) { _map[x][y] = v; }

	@Override
	public void setPixel(Pixel2D p, int v) { setPixel(p.getX(), p.getY(), v); }

	@Override
	public boolean isInside(Pixel2D p) {
		return p != null && p.getX() >= 0 && p.getX() < getWidth() && p.getY() >= 0 && p.getY() < getHeight();
	}

	@Override
	public boolean sameDimensions(Map2D p) {
		return p != null && getWidth() == p.getWidth() && getHeight() == p.getHeight();
	}

	@Override
	public void addMap2D(Map2D p) {
		if (!sameDimensions(p)) return;
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				_map[x][y] += p.getPixel(x, y);
			}
		}
	}

	@Override
	public void mul(double scalar) {
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				_map[x][y] = (int)(_map[x][y] * scalar);
			}
		}
	}

	@Override
	public void rescale(double sx, double sy) {
		int newW = (int)(getWidth() * sx);
		int newH = (int)(getHeight() * sy);
		int[][] temp = new int[newW][newH];
		for (int x = 0; x < newW; x++) {
			for (int y = 0; y < newH; y++) {
				temp[x][y] = _map[(int)(x / sx)][(int)(y / sy)];
			}
		}
		_map = temp;
	}

	@Override
	public void drawCircle(Pixel2D center, double rad, int color) {
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				Pixel2D p = new Index2D(x, y);
				if (p.distance2D(center) < rad) {
					setPixel(x, y, color);
				}
			}
		}
	}

	@Override
	public void drawLine(Pixel2D p1, Pixel2D p2, int color) {
		// Simple implementation of line drawing using the provided logic
		int x1 = p1.getX(), y1 = p1.getY();
		int x2 = p2.getX(), y2 = p2.getY();
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);

		if (dx >= dy) {
			if (x1 > x2) { drawLine(p2, p1, color); return; }
			for (int x = x1; x <= x2; x++) {
				double t = (dx == 0) ? 0 : (double)(x - x1) / dx;
				int y = (int) Math.round(y1 + t * (y2 - y1));
				setPixel(x, y, color);
			}
		} else {
			if (y1 > y2) { drawLine(p2, p1, color); return; }
			for (int y = y1; y <= y2; y++) {
				double t = (dy == 0) ? 0 : (double)(y - y1) / dy;
				int x = (int) Math.round(x1 + t * (x2 - x1));
				setPixel(x, y, color);
			}
		}
	}

	@Override
	public void drawRect(Pixel2D p1, Pixel2D p2, int color) {
		int xMin = Math.min(p1.getX(), p2.getX());
		int xMax = Math.max(p1.getX(), p2.getX());
		int yMin = Math.min(p1.getY(), p2.getY());
		int yMax = Math.max(p1.getY(), p2.getY());
		for (int x = xMin; x <= xMax; x++) {
			for (int y = yMin; y <= yMax; y++) {
				setPixel(x, y, color);
			}
		}
	}

	@Override
	public boolean equals(Object ob) {
		if (!(ob instanceof Map2D)) return false;
		Map2D other = (Map2D) ob;
		if (!sameDimensions(other)) return false;
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				if (getPixel(x, y) != other.getPixel(x, y)) return false;
			}
		}
		return true;
	}

	@Override
	public int fill(Pixel2D p, int new_v, boolean cyclic) {
		int oldColor = getPixel(p);
		if (oldColor == new_v) return 0;

		int count = 0;
		Queue<Pixel2D> q = new LinkedList<>();
		q.add(p);
		setPixel(p, new_v);
		count++;

		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		while (!q.isEmpty()) {
			Pixel2D curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.getX() + dx[i];
				int ny = curr.getY() + dy[i];

				if (cyclic) {
					nx = (nx + getWidth()) % getWidth();
					ny = (ny + getHeight()) % getHeight();
				}

				Pixel2D neighbor = new Index2D(nx, ny);
				if (isInside(neighbor) && getPixel(neighbor) == oldColor) {
					setPixel(neighbor, new_v);
					q.add(neighbor);
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public Pixel2D[] shortestPath(Pixel2D p1, Pixel2D p2, int obsColor, boolean cyclic) {
		Map2D distMap = allDistance(p1, obsColor, cyclic);
		int distance = distMap.getPixel(p2);

		if (distance == -1) return null; // No path found

		Pixel2D[] path = new Pixel2D[distance + 1];
		Pixel2D curr = p2;
		path[distance] = p2;

		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		// Backtrack from p2 to p1 using the distance map
		for (int d = distance - 1; d >= 0; d--) {
			for (int i = 0; i < 4; i++) {
				int nx = curr.getX() + dx[i];
				int ny = curr.getY() + dy[i];
				if (cyclic) {
					nx = (nx + getWidth()) % getWidth();
					ny = (ny + getHeight()) % getHeight();
				}
				Pixel2D neighbor = new Index2D(nx, ny);
				if (isInside(neighbor) && distMap.getPixel(neighbor) == d) {
					path[d] = neighbor;
					curr = neighbor;
					break;
				}
			}
		}
		return path;
	}

	@Override
	public Map2D allDistance(Pixel2D start, int obsColor, boolean cyclic) {
		Map res = new Map(getWidth(), getHeight(), -1);
		if (!isInside(start) || getPixel(start) == obsColor) return res;

		Queue<Pixel2D> q = new LinkedList<>();
		q.add(start);
		res.setPixel(start, 0);

		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		while (!q.isEmpty()) {
			Pixel2D curr = q.poll();
			int currentDist = res.getPixel(curr);

			for (int i = 0; i < 4; i++) {
				int nx = curr.getX() + dx[i];
				int ny = curr.getY() + dy[i];
				if (cyclic) {
					nx = (nx + getWidth()) % getWidth();
					ny = (ny + getHeight()) % getHeight();
				}
				Pixel2D neighbor = new Index2D(nx, ny);
				if (isInside(neighbor) && getPixel(neighbor) != obsColor && res.getPixel(neighbor) == -1) {
					res.setPixel(neighbor, currentDist + 1);
					q.add(neighbor);
				}
			}
		}
		return res;
	}
}