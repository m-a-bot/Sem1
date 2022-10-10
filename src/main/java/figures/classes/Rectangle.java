package figures.classes;

import points.Point2D;

public class Rectangle extends QGon {
    public Rectangle(Point2D[] p)
    {
        super(p);
    }

    @Override
    public double square() throws Exception
    {
        double a,b;

        a = Point2D.sub(p[1], p[0]).abs();
        b = Point2D.sub(p[2], p[1]).abs();

        return a * b;
    }

    @Override
    public String toString()
    {
        String str =  "Rectangle\n{";
        for (int k=0; k < n-1; k++)
            str += p[k]+";";
        str += p[n-1]+"}";

        return str;
    }
}
