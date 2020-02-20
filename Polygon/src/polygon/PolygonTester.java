package polygon;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;

public class PolygonTester {

	@Test
	public void test1() {
		SimplePolygon poly1 = new SimplePolygon(7); 
		poly1.vertices[0] = new Point2D.Double(28, 2);
		poly1.vertices[1] = new Point2D.Double(31, 5);
		poly1.vertices[2] = new Point2D.Double(28, 10);
		poly1.vertices[3] = new Point2D.Double(14, 14);
		poly1.vertices[4] = new Point2D.Double(5, 10);
		poly1.vertices[5] = new Point2D.Double(8, 4);
		poly1.vertices[6] = new Point2D.Double(18, 1);
		
		assertEquals(51.63, poly1.perimeter(), 0.002);
	}
	
	@Test
	public void test2() throws NonSimplePolygonException {
		SimplePolygon poly1 = new SimplePolygon(7);
		poly1.vertices[0] = new Point2D.Double(28, 2);
		poly1.vertices[1] = new Point2D.Double(31, 5);
		poly1.vertices[2] = new Point2D.Double(28, 10);
		poly1.vertices[3] = new Point2D.Double(14, 14);
		poly1.vertices[4] = new Point2D.Double(5, 10);
		poly1.vertices[5] = new Point2D.Double(8, 4);
		poly1.vertices[6] = new Point2D.Double(18, 1);
		
		assertEquals(227.00, poly1.area(), 0.002);
	}
	
	@Test
	public void test3() {
		SimplePolygon poly1 = new SimplePolygon(7);
		poly1.vertices[0] = new Point2D.Double(28, 2);
		poly1.vertices[1] = new Point2D.Double(31, 5);
		poly1.vertices[2] = new Point2D.Double(28, 10);
		poly1.vertices[3] = new Point2D.Double(14, 14);
		poly1.vertices[4] = new Point2D.Double(5, 10);
		poly1.vertices[5] = new Point2D.Double(8, 4);
		poly1.vertices[6] = new Point2D.Double(18, 1);
		
		assertTrue(poly1.isSimple());
	}
	
	@Test
	public void test4() {
		Point2D.Double a = new Point2D.Double(28, 2);
		Point2D.Double b = new Point2D.Double(31, 5);
		Point2D.Double c = new Point2D.Double(28, 10);
		Point2D.Double d = new Point2D.Double(14, 14);
		Point2D.Double e = new Point2D.Double(5, 10);
		Point2D.Double f = new Point2D.Double(8, 4);
		Point2D.Double g = new Point2D.Double(18, 1);
		
		assertTrue(SimplePolygon.disjointSegments(a, b, c, d));
		assertTrue(SimplePolygon.disjointSegments(a, b, e, f));
		assertTrue(SimplePolygon.disjointSegments(b, c, e, d));
		assertTrue(SimplePolygon.disjointSegments(b, c, f, g));
	}
	
	@Test
	public void test5() {
		SimplePolygon poly1 = new SimplePolygon(7);
		ConvexPolygon c = new ConvexPolygon(7);
		poly1 = c;
		poly1.vertices[0] = new Point2D.Double(28, 2);
		poly1.vertices[1] = new Point2D.Double(31, 5);
		poly1.vertices[2] = new Point2D.Double(28, 10);
		poly1.vertices[3] = new Point2D.Double(14, 14);
		poly1.vertices[4] = new Point2D.Double(5, 10);
		poly1.vertices[5] = new Point2D.Double(8, 4);
		poly1.vertices[6] = new Point2D.Double(18, 1);
		 
		assertTrue(c.isConvex()); 
		assertTrue(poly1.isSimple());
	}
	
	@Test
	public void test6() {
		SimplePolygon poly2 = new SimplePolygon(9);
		poly2.vertices[0] = new Point2D.Double(6, 10);
		poly2.vertices[1] = new Point2D.Double(20, 3);
		poly2.vertices[2] = new Point2D.Double(23, 3);
		poly2.vertices[3] = new Point2D.Double(23, 8);
		poly2.vertices[4] = new Point2D.Double(27, 3);
		poly2.vertices[5] = new Point2D.Double(30, 3);
		poly2.vertices[6] = new Point2D.Double(20, 15);
		poly2.vertices[7] = new Point2D.Double(16, 5);
		poly2.vertices[8] = new Point2D.Double(20, 14);
		
		assertEquals(69.30, poly2.perimeter(), 0.01);
	}
	
	@Test
	public void test7() throws NonSimplePolygonException {
		SimplePolygon poly2 = new SimplePolygon(9);
		poly2.vertices[0] = new Point2D.Double(6, 10);
		poly2.vertices[1] = new Point2D.Double(20, 3);
		poly2.vertices[2] = new Point2D.Double(23, 3);
		poly2.vertices[3] = new Point2D.Double(23, 8);
		poly2.vertices[4] = new Point2D.Double(27, 3);
		poly2.vertices[5] = new Point2D.Double(30, 3);
		poly2.vertices[6] = new Point2D.Double(20, 15);
		poly2.vertices[7] = new Point2D.Double(16, 5);
		poly2.vertices[8] = new Point2D.Double(20, 14);
		
		assertEquals(0.0, poly2.area(), 0.01);
	}
	
	@Test
	public void test8() {
		SimplePolygon poly2 = new SimplePolygon(9);
		poly2.vertices[0] = new Point2D.Double(6, 10);
		poly2.vertices[1] = new Point2D.Double(20, 3); 
		poly2.vertices[2] = new Point2D.Double(23, 3);
		poly2.vertices[3] = new Point2D.Double(23, 8);
		poly2.vertices[4] = new Point2D.Double(27, 3);
		poly2.vertices[5] = new Point2D.Double(30, 3);
		poly2.vertices[6] = new Point2D.Double(20, 15); 
		poly2.vertices[7] = new Point2D.Double(16, 5);
		poly2.vertices[8] = new Point2D.Double(20, 14);
		
		assertFalse(poly2.isSimple()); 
	} 
	
	@Test
	public void test9() {
		SimplePolygon poly2 = new SimplePolygon(9);
		ConvexPolygon con2 = new ConvexPolygon(9); 
		poly2 = con2;
		poly2.vertices[0] = new Point2D.Double(6, 10);
		poly2.vertices[1] = new Point2D.Double(20, 3); 
		poly2.vertices[2] = new Point2D.Double(23, 3);
		poly2.vertices[3] = new Point2D.Double(23, 8);
		poly2.vertices[4] = new Point2D.Double(27, 3);
		poly2.vertices[5] = new Point2D.Double(30, 3);
		poly2.vertices[6] = new Point2D.Double(20, 15);
		poly2.vertices[7] = new Point2D.Double(16, 5);
		poly2.vertices[8] = new Point2D.Double(20, 14);
		
		assertFalse(con2.isConvex()); 
	}
	
	@Test
	public void test10() {
		Point2D.Double a = new Point2D.Double(6, 10);   
		Point2D.Double b = new Point2D.Double(20, 3);
		Point2D.Double c = new Point2D.Double(23, 3); 
		Point2D.Double d = new Point2D.Double(23, 8);
		Point2D.Double e = new Point2D.Double(27, 3);
		Point2D.Double f = new Point2D.Double(30, 3);
		Point2D.Double g = new Point2D.Double(20, 15);
		Point2D.Double h = new Point2D.Double(16, 5);
		Point2D.Double i = new Point2D.Double(20, 14);
		
		assertFalse(SimplePolygon.disjointSegments(a, b, g, h));
		assertFalse(SimplePolygon.disjointSegments(a, b, h, i));
		assertTrue(SimplePolygon.disjointSegments(c, d, f, g)); 
		assertTrue(SimplePolygon.disjointSegments(d, e, g, h));
	}
	
	@Test
	public void test11() throws NonSimplePolygonException { 
		SimplePolygon poly1 = new SimplePolygon(5);
		ConvexPolygon c = new ConvexPolygon(5); 
		poly1 = c;
		poly1.vertices[0] = new Point2D.Double(-1, -2);
		poly1.vertices[1] = new Point2D.Double(1, -2);
		poly1.vertices[2] = new Point2D.Double(2, 1);
		poly1.vertices[3] = new Point2D.Double(-1, 4);
		poly1.vertices[4] = new Point2D.Double(-4, 1);
		 
		assertTrue(c.isConvex()); 
		assertTrue(poly1.isSimple());
		assertEquals(21.00, poly1.area(), 0.01);
		assertEquals(13.65, poly1.perimeter(), 0.01);
	}
	
	@Test
	public void test12() {
		SimplePolygon poly1 = new SimplePolygon(7);
		ConvexPolygon c = new ConvexPolygon(7);
		poly1 = c;
		poly1.vertices[0] = new Point2D.Double(-4, -2);
		poly1.vertices[1] = new Point2D.Double(1, -2);
		poly1.vertices[2] = new Point2D.Double(2, 1);
		poly1.vertices[3] = new Point2D.Double(-1, 4);
		poly1.vertices[4] = new Point2D.Double(-4, 1);
		poly1.vertices[5] = new Point2D.Double(-1, -2);
		poly1.vertices[6] = new Point2D.Double(-3, -1.5);
		 
 		assertFalse(c.isConvex()); 
		assertFalse(poly1.isSimple());
	}
	
	@Test
	public void test13() {
		Point2D.Double a = new Point2D.Double(-4, -2);
		Point2D.Double b = new Point2D.Double(1, -2);
		Point2D.Double c = new Point2D.Double(-4, 1);
		Point2D.Double d = new Point2D.Double(-1, -2);
		Point2D.Double e = new Point2D.Double(-3, -1.5);
		 
		assertFalse(SimplePolygon.disjointSegments(a, b, c, d)); 
		assertFalse(SimplePolygon.disjointSegments(a, b, d, e));
		assertTrue(SimplePolygon.disjointSegments(c, d, e, a)); 
	}
	
	@Test
	public void test14() { 
		SimplePolygon poly1 = new SimplePolygon(5);
		ConvexPolygon c = new ConvexPolygon(5);
		poly1 = c;
		poly1.vertices[0] = new Point2D.Double(-1, -3);
		poly1.vertices[1] = new Point2D.Double(3, -1);
		poly1.vertices[2] = new Point2D.Double(1, -1);
		poly1.vertices[3] = new Point2D.Double(3, 1);
		poly1.vertices[4] = new Point2D.Double(-1, 3);
		 
		assertFalse(c.isConvex()); 
		assertTrue(poly1.isSimple());
	}
	
	@Test
	public void test15() { 
		SimplePolygon poly1 = new SimplePolygon(13);
		ConvexPolygon c = new ConvexPolygon(13);
		poly1 = c;
		poly1.vertices[0] = new Point2D.Double(5, 6);
		poly1.vertices[1] = new Point2D.Double(13, 2);
		poly1.vertices[2] = new Point2D.Double(12, 6);
		poly1.vertices[3] = new Point2D.Double(20, 2);
		poly1.vertices[4] = new Point2D.Double(16, 12);
		poly1.vertices[5] = new Point2D.Double(17, 11);
		poly1.vertices[6] = new Point2D.Double(19, 5);
		poly1.vertices[7] = new Point2D.Double(13, 11);
		poly1.vertices[8] = new Point2D.Double(19, 15);
		poly1.vertices[9] = new Point2D.Double(8, 12);
		poly1.vertices[10] = new Point2D.Double(14, 7);
		poly1.vertices[11] = new Point2D.Double(5, 11);
		poly1.vertices[12] = new Point2D.Double(9, 6);
		 
		assertFalse(c.isConvex()); 
		assertFalse(poly1.isSimple());
	} 
	
	@Test
	public void test16() { 
		Point2D.Double a = new Point2D.Double(20, 2);
		Point2D.Double b = new Point2D.Double(16, 12);
		Point2D.Double c = new Point2D.Double(19, 5);
		Point2D.Double d = new Point2D.Double(13, 11);
		
		assertFalse(SimplePolygon.disjointSegments(a, b, c, d)); 
	}
	
	@Test
	public void test17() { 
		SimplePolygon poly1 = new SimplePolygon(12);
		ConvexPolygon c = new ConvexPolygon(12);
		poly1 = c;
		poly1.vertices[0] = new Point2D.Double(5, 6);
		poly1.vertices[1] = new Point2D.Double(13, 2);
		poly1.vertices[2] = new Point2D.Double(12, 6);
		poly1.vertices[3] = new Point2D.Double(20, 2);
		poly1.vertices[4] = new Point2D.Double(16, 12);
		poly1.vertices[5] = new Point2D.Double(17, 11);
		poly1.vertices[6] = new Point2D.Double(19, 5);
		poly1.vertices[7] = new Point2D.Double(19, 15);
		poly1.vertices[8] = new Point2D.Double(8, 12);
		poly1.vertices[9] = new Point2D.Double(14, 7);
		poly1.vertices[10] = new Point2D.Double(5, 11);
		poly1.vertices[11] = new Point2D.Double(9, 6);
		 
		assertFalse(c.isConvex()); 
		assertTrue(poly1.isSimple());
	} 
	
	@Test
	public void test18() { 
		Point2D.Double a3 = new Point2D.Double(-7, -1); 
		Point2D.Double b3 = new Point2D.Double(-1, -4);
		Point2D.Double c3 = new Point2D.Double(-5, -1);
		Point2D.Double d3 = new Point2D.Double(-3, 2);
		Point2D.Double c = new Point2D.Double(-5.5, -1.75); 
		
		SimplePolygon p4 = new SimplePolygon(4);
		ConvexPolygon c4 = new ConvexPolygon(4);  
		p4 = c4;
		p4.vertices[0] = a3;
		p4.vertices[1] = b3;
		p4.vertices[2] = c3;
		p4.vertices[3] = d3;
		
		assertFalse(c4.isConvex()); 
		assertTrue(p4.isSimple());
		assertTrue(SimplePolygon.disjointSegments(a3, b3, c3, d3));
		assertFalse(SimplePolygon.disjointSegments(a3, b3, c, d3));
		
	} 	

}
