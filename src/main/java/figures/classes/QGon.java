package figures.classes;

import points.*;

public class QGon extends NGon{
    public QGon(Point2D[] p)
    {
        super(p);
    }

    @Override
    public double square() throws Exception
    {
        double perimeter;

        perimeter = this.length()/2;

        double a,b,c,d;

        a = Point2D.sub(p[1], p[0]).abs();
        b = Point2D.sub(p[2], p[1]).abs();
        c = Point2D.sub(p[3], p[2]).abs();
        d = Point2D.sub(p[0], p[3]).abs();

        double square;

        square = Math.pow((perimeter - a)*(perimeter - b)*(perimeter - c)*(perimeter - d), 0.5);
        square = super.square();
        return square;
    }

    @Override
    public String toString()
    {
        String str =  "QGon\n{";
        for (int k=0; k < n-1; k++)
            str += p[k]+";";
        str += p[n-1]+"}";

        return str;
    }
}
