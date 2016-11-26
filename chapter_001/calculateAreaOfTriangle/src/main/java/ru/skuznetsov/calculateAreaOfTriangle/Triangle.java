package ru.skuznetsov.calculateAreaOfTriangle;
/**
* Some comment.
*/
public class Triangle {
	/**
	* Point a.
	*/
    private Point a;
	/**
	* Point b.
	*/
    private Point b;
	/**
	* Point c.
	*/
    private Point c;
	/**
	* Constructor with 3 points.
	* @param a - point a
	* @param b - point b
	* @param c - point c
	*/
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
/**
* Method calculates area of triangle.
* @return calculated area
*/
    public double area() {
        double area = Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
        if (!canBeBuild()) {
	    throw new IllegalArgumentException("Triangle cannot be build");
	}
        return area;
    }
/**
* Method check can be build triangle or no.
* @return boolean value is can be build triangle.
*/
    public boolean canBeBuild() {
        double distanceAToB = a.distanceTo(b);
        double distanceAToC = a.distanceTo(c);
        double distanceBToC = b.distanceTo(c);

        if (distanceAToB > distanceAToC && distanceAToB > distanceBToC) {
			return distanceAToB < (distanceAToC + distanceBToC);
		} else if (distanceAToC > distanceAToB && distanceAToC > distanceBToC) {
			return distanceAToC < (distanceAToB + distanceBToC);
		} else {
			return distanceBToC < (distanceAToC + distanceAToB);
		}
    }
}
