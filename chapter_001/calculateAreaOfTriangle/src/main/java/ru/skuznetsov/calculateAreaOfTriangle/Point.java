
package ru.skuznetsov.calculateAreaOfTriangle;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    public double distanceTo(Point point) {
	double distance = Math.sqrt((this.x - point.x) * (this.x - point.x) + (this.y - point.y) * (this.y - point.y));
	return distance;
    }
}
