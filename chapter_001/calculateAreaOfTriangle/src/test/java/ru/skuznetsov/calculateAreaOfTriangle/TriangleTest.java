package ru.skuznetsov.calculateAreaOfTriangle;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
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
    * method area() throws IllegalArgumentException if triangle cannot be build.
    */
    @Test(expected = IllegalArgumentException.class)
    public void isTriangleCanBeBuild() {
		final int a = 3;
		final int b = 5;
		final int c = 1;
		final int e = 9;

        Point pointA = new Point(a, c);
        Point pointB = new Point(b, c);
        Point pointC = new Point(e, c);

        Triangle triangle = new Triangle(pointA, pointB, pointC);
        triangle.area();
    }

}
