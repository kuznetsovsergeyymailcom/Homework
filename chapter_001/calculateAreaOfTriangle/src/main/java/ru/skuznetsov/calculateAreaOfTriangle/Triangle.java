package ru.skuznetsov.calculateAreaOfTriangle;

public class Triangle {

    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double area = Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
        if(!canBeBuild()) throw new IllegalArgumentException("Triangle cannot be build");

        return area;
    }

    public boolean canBeBuild() {
        double distanceAToB = a.distanceTo(b);
        double distanceAToC = a.distanceTo(c);
        double distanceBToC = b.distanceTo(c);

        double largest = (distanceAToB > distanceAToC) ?
                (distanceAToB > distanceBToC ? distanceAToB : distanceBToC) :
                (distanceAToC > distanceBToC ? distanceAToC : distanceBToC);

        if (largest == distanceAToB) {
            return distanceAToB < (distanceAToC + distanceBToC);
        }else if(largest == distanceAToC){
            return distanceAToC < (distanceAToB + distanceBToC);
        }else{
            return distanceBToC < (distanceAToC + distanceAToB);
        }
    }
}
