package ru.skuznetsov.calculateAreaOfTriangle;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void getAreaOfTriangleByThreePoints() {
        Point pointA = new Point(3, 1);
        Point pointB = new Point(6, 4);
        Point pointC = new Point(9, 1);

        Triangle triangle = new Triangle(pointA, pointB, pointC);
        double area = triangle.area();
        assertThat(area, closeTo(9.00, 0.01));

    }
    /**
    * method area() throws IllegalArgumentException if triangle cannot be build
    */ 
    @Test(expected = IllegalArgumentException.class)
    public void isTriangleCanBeBuild(){
        Point pointA = new Point(3, 1);
        Point pointB = new Point(5, 1);
        Point pointC = new Point(9, 1);

        Triangle triangle = new Triangle(pointA, pointB, pointC);
        triangle.area();
    }

}
