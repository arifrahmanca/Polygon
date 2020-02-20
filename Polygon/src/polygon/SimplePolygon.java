package polygon;

import java.awt.geom.Point2D;
import java.util.Scanner;

/**
 * The class SimplePolygon implements the Polygon interface.
 * 
 * It is intended to be further extended by ConvexPolygon.
 * 
 * @author Muhammad Arifur Rahman
 */

public class SimplePolygon implements Polygon {

	/********* protected fields ************************/

	protected int n; // number of vertices of the polygon
	protected Point2D.Double[] vertices; // vertices[0..n-1] around the polygon boundary

	/********* protected constructors ******************/

	/**
	 * constructor used in the static factory method getNewPoly()
	 * 
	 * @param size
	 *            number of edges (also vertices) of the polygon
	 */
	
	protected SimplePolygon(int size) {
		n = size;
		vertices = new Point2D.Double[n];
	}

	/** default no-parameter constructor */
	protected SimplePolygon() {
		n = 3;
		vertices = new Point2D.Double[n];
		vertices[0] = new Point2D.Double(1, 1);
		vertices[1] = new Point2D.Double(-1, -1);
		vertices[2] = new Point2D.Double(0, 0);
	}

	/********* public getters & toString ***************/

	/**
	 * static factory method constructs and returns an unverified simple-polygon, initialised
	 * according to user provided input data. Runs in O(n) time.
	 * 
	 * @return an unverified simple-polygon instance
	 */
	
	public static SimplePolygon getNewPoly() {
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		String[] inputArr = input.split(" ");
		int size = Integer.parseInt(inputArr[0]);
		userInput.close();

		SimplePolygon poly = new SimplePolygon(size);
		poly.vertices = new Point2D.Double[size];

		for (int i = 1; i < size - 1; i = i ++) {
			poly.vertices[i - 1] = new Point2D.Double(Double.parseDouble(inputArr[i]),
					Double.parseDouble(inputArr[i + 1]));
		}
		return poly;
	}

	/**
	 * 
	 * @return n, the number of edges (equivalently, vertices) of the polygon.
	 */
	
	public int getSize() {
		return vertices.length;
	}

	/**
	 * 
	 * @param i
	 *            index of the vertex.
	 * @return the i-th vertex of the polygon.
	 * @throws IndexOutOfBoundsException
	 *             if {@code i < 0 || i >= n }.
	 */
	
	public Point2D.Double getVertex(int i) throws IndexOutOfBoundsException {
		try {
			return vertices[i];
		} catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException catch");
		}
		return null;
	}

	/**
	 * @return a String representation of the polygon in O(n) time.
	 */
	
	@Override
	public String toString() {
		String result = " ";
		for (int i = 0; i < vertices.length; i++) {
			result += vertices[i] + ",";
		}
		return result;
	}

	/************** utilities *********************/

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 *            three input points.
	 * @return twice the signed area of the oriented triangle (a,b,c). Runs in O(1) time.
	 */
	
	public static double delta(Point2D.Double a, Point2D.Double b,
			Point2D.Double c) {
		double delta = 0;
		delta = a.getX() * (b.getY() - c.getY()) - b.getX() * (a.getY() - c.getY())
				+ c.getX() * (a.getY() - b.getY());
		return delta;
	}
	
	public static int orientation(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
		return (delta(a, b, c) == 0) ? 0 : ((delta(a, b, c) > 0) ? 1 : -1);
	}

	public static double getDistance(Point2D.Double a, Point2D.Double b) {
		return Math.sqrt(Math.pow((b.getY() - a.getY()), 2) + Math.pow((b.getX() - a.getX()), 2));
	}
	

	/**
	 * @param a
	 * @param b
	 *            end points of line-segment (a,b).
	 * @param c
	 * @param d
	 *            end points of line-segment (c,d).
	 * @return true if closed line-segments (a,b) and (c,d) are disjoint. Runs in O(1) time.
	 */
	
	public static boolean disjointSegments(Point2D.Double a, Point2D.Double b,
			Point2D.Double c, Point2D.Double d) {
		if (delta(c, b, a) * delta(b, d, a) < 0)
			return true;
		if (delta(a, d, c) * delta(d, b, c) < 0)
			return true;

		return false;
	}

	/**
	 * @param i
	 * @param j
	 *            indices of two edges of the polygon.
	 * @return true if the i-th and j-th edges of the polygon are disjoint. Runs in O(1) time.
	 * @throws IndexOutOfBoundsException
	 *             if i or j are outside the index range [0..n-1].
	 */
	
	public boolean disjointEdges(int i, int j) throws IndexOutOfBoundsException {
		try {
			if (j - i > 1 && j - i < n - 1) {
				return true;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Catch Exception");
		}
		return false;
	}

	/**
	 * This method verifies whether the claimed "simple-polygon" is indeed simple.
	 * 
	 * @return true if the polygon is simple. Runs in O(n^2) time.
	 */
	
	public boolean isSimple() {
		boolean result = true;
		for (int i = 0; i < vertices.length - 1; i++) {
			for (int j = i + 2; j < vertices.length - 1; j++) {
				result = result && disjointSegments(vertices[i], vertices[i + 1], vertices[j], vertices[j + 1]);
			}
		}
		return result;
	}

	/************ perimeter & area ***************/

	/**
	 * 
	 * @return the sum of the edge lengths of the polygon. Runs in O(n) time.
	 */
	
	public double perimeter() {
		double peri = 0.0;
		for (int i = 0; i < vertices.length - 1; i++) {
			peri += getDistance(vertices[i], vertices[i + 1]);
		}
		return peri;
	}

	/**
	 * 
	 * @return area of the polygon interior. Runs in O(n) time not counting the simplicity test.
	 * @throws NonSimplePolygonException
	 *             if the polygon is non-simple.
	 */
	
	public double area() throws NonSimplePolygonException {
		try {
			if (isSimple() == false)
				throw new NonSimplePolygonException();
			else {
				double sum = 0;
				for (int i = 0; i < vertices.length; i++) {
					if (i == 0) {
						sum += vertices[i].getX() * (vertices[i + 1].getY() - vertices[vertices.length - 1].getY());
					} else if (i == vertices.length - 1) {
						sum += vertices[i].getX() * (vertices[0].getY() - vertices[i - 1].getY());
					} else {
						sum += vertices[i].getX() * (vertices[i + 1].getY() - vertices[i - 1].getY());
					}
				}
				double area = 0.5 * Math.abs(sum);
				return area;
			}
		} catch (NonSimplePolygonException e) {
			System.out.println("The Polygon is not simple.");
		}
		return 0.0;
	}

}
