# Project Description:

An 𝑛-sided polygon 𝑃 (𝑛≥3) is a cyclic sequence 𝑣0,𝑣1,⋯,𝑣𝑛−1 of vertices as we walk around the polygon boundary. Each vertex 𝑣𝑖 (the 𝑖th vertex) is a point in the plane represented by its 𝐝𝐨𝐮𝐛𝐥𝐞 𝑥 and 𝑦 coordinates. The line-segment 𝑒𝑖 between vertex 𝑣𝑖 and the next vertex 𝑣𝑖+1 𝑚𝑜𝑑 𝑛 (in cyclic order around the boundary) is called the 𝑖th edge of 𝑃, for 𝑖=0..𝑛−1. 
The Point2D.Double class in the java.awt.geom package of the Java API is used to represent polygon vertices. The polygon is said to be simple if no two non-adjacent pair of edges intersect. That is, two edges 𝑒𝑖 and 𝑒𝑗 are completely disjoint from each other whenever 1<𝑗−𝑖<𝑛−1. 
A simple polygon is said to be convex if the internal angle of every vertex is at most 180°. Equivalently, the simple polygon is convex if every turn is consistently in the same orientation (clockwise or counter-clockwise) as we walk around the polygon boundary. 
The main methods of interest are polygon perimeter and area. Note that polygon area may not be well defined if the polygon is non-simple, since the notion of polygon “interior” may not be well defined in that case. We obviously need the boolean methods isSimple and isConvex as well.
Here double precision coordinates are used for vertices of the polygon. So, this Polygon interface is different from the java.awt.Polygon class in the Java API.
