package ru.skuznetsov.calculateAreaOfTriangle;
/**
* Some comment.
*/
class Triangle {
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
    Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
/**
* Method calculates area of triangle.
* @return calculated area
*/
    double area() {
		if (canBeBuild()) {
			double area = Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
			return area;
		}

		return 0.0;
    }
/**
* Method check can be build triangle or no.
* @return boolean value is can be build triangle.
*/
    boolean canBeBuild() {
		if (this.a == null || this.b == null || this.c == null) {
			return false;
		}
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
