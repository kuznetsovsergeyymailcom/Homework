/**
* Calculating area of triangle.
* @author skuznetsov.
*/
package ru.skuznetsov.calculateAreaOfTriangle;
/**
* Class contains points for triangle.
*/
public class Point {

	/**
	* x coordinate.
	*/
    private double x;
	/**
	* y coordinate.
	*/
    private double y;
/**
* Constructor with two params x and y.
* @param x - coordinate x.
* @param y - coordinate y.
*/
    public Point(double x, double y) {
	   this.x = x;
	   this.y = y;
    }
/**
* Method calculates distance between two points.
* @param point - over point to calculate distance between them
* @return distance.
*/
    public double distanceTo(Point point) {
		double distance = Math.sqrt((this.x - point.x) * (this.x - point.x) + (this.y - point.y) * (this.y - point.y));
	return distance;
    }
	/**
	* Method get x coordinate.
	* @return x coordinate
	*/
	public double getX() {
		return this.x;
	}
	/**
	* Method get y coordinate.
	* @return y coordinate
	*/
	public double getY() {
		return this.y;
	}
}
