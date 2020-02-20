package polygon;

/**
 * This exception is thrown whenever a method is invoked on a non-simple polygon
 * when a simple polygon is expected.
 * 
 * @author Muhammad Arifur Rahman
 */

public class NonSimplePolygonException extends Exception {

	/**
	 * compiler generated serialVersionUID
	 */
	
	private static final long serialVersionUID = -6499398129928918406L;

	/** no-message constructor */
	public NonSimplePolygonException() {
	}

	/** detailed message constructor */
	public NonSimplePolygonException(String msg) {
		super(msg); }
}

