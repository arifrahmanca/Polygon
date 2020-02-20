package polygon;

/**
 * The class ConvexPolygon extends SimplePolygon.
 * 
 * @author Muhammad Arifur Rahman
 */

public class ConvexPolygon extends SimplePolygon {
	
	public ConvexPolygon(int i) {
		super(i);
	}
	
	public ConvexPolygon()
	{
		super();
	}
	
	public boolean isConvex() {
		if (!isSimple()) {
			return false;
		}

		else {
			double turn1 = orientation(vertices[0], vertices[1], vertices[2]);

			double[] turns = new double[vertices.length];
			for (int i = 1; i < vertices.length - 2; i++) {
				turns[i] = orientation(vertices[i], vertices[i + 1], vertices[i + 2]);
				return turn1 == turns[i];
			}

			double turn2 = orientation(vertices[n - 2], vertices[n - 1], vertices[0]);
			double turn3 = orientation(vertices[n - 1], vertices[0], vertices[1]);
			return turn1 == turn2 && turn1 == turn3;

		}
	}
}