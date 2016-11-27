package ru.skuznetsov.calculateAreaOfTriangle;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
/**
* Test class of triangle area calculation.
*/
public class TriangleTest {

/**
* Test method verify expected area with area calculated by operation.
*/
    @Test
    public void getAreaOfTriangleByThreePoints() {
		final int a = 3;
		final int b = 6;
		final int c = 1;
		final int d = 4;
		final int e = 9;
		final double precision = 0.01;
		final double expected = 9.00;

        Point pointA = new Point(a, c);
        Point pointB = new Point(d, d);
        Point pointC = new Point(e, c);

        Triangle triangle = new Triangle(pointA, pointB, pointC);
        double area = triangle.area();
        assertThat(area, closeTo(expected, precision));

    }
    /**
    * method area() 0 if triangle cannot be build or null gives to argument of Triangle.
    */
    @Test
    public void isTriangleCanBeBuild() {
		final int a = 3;
		final int b = 5;
		final int c = 1;
		final int e = 9;
		final double expected = 0.0;
		final double precision = 0.01;

        Point pointA = new Point(a, c);
        Point pointB = new Point(b, c);
        Point pointC = new Point(e, c);

        Triangle triangle = new Triangle(pointA, pointB, pointC);
        double area = triangle.area();
		assertThat(area, closeTo(expected, precision));
    }
    /**
     * method area() 0 if triangle cannot be build or null gives to argument of Triangle.
     */
    @Test
    public void checkThrowsThanNullPointerGivesAsArgument() {
        Triangle triangle = new Triangle(null, null, null);
        boolean area = triangle.canBeBuild();
		assertFalse(area);
    }
    /**
     * Method check can be build triangle or no.
     */
    @Test
    public void canBeBuildTriangle() {
        final int a = 3;
        final int b = 5;
        final int c = 1;
        final int e = 9;

        Point pointA = new Point(a, c);
        Point pointB = new Point(b, c);
        Point pointC = new Point(e, c);

        Triangle triangle = new Triangle(pointA, pointB, pointC);
        boolean canBe = triangle.canBeBuild();
        assertFalse(canBe);
    }
    /**
     * Method check calculation of distance from point to point.
     */
    @Test
    public void distanceToPointTest() {
		final int ax = 4;
        final int ay = 7;
        final int bx = 1;
        final int by = 4;
		final double expected = 4.24;
        final double delta = 0.01;

        Point a = new Point(ax, ay);
        Point b = new Point(bx, by);

        double dist = a.distanceTo(b);

        assertThat(dist, closeTo(expected, delta));
    }
    /**
     * Method check returned value of x var.
     */
    @Test
    public void getXTest() {
		final int ax = 1;
        final int ay = 5;

        final double expected = 1;
        final double delta = 0.01;

		Point a = new Point(ax, ay);

        final double x = a.getX();

        assertThat(x, closeTo(expected, delta));
    }
    /**
     * Method check returned value of x var.
     */
    @Test
    public void getYTest() {
		final int ax = 1;
        final int ay = 5;
		Point a = new Point(ax, ay);
		final double expected = 5;
        final double delta = 0.01;

        double y = a.getY();
        assertThat(y, closeTo(expected, delta));
    }
}
