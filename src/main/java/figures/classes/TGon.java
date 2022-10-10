package figures.classes;

import points.Point2D;

public class TGon extends NGon{
    public TGon(Point2D[] p)
    {
        super(p);
    }

    @Override
    public double square() throws Exception
    {
        double perimeter;

        //perimeter = this.length()/2;

        double a,b,c;

        a = Point2D.sub(p[1], p[0]).abs();
        b = Point2D.sub(p[2], p[1]).abs();
        c = Point2D.sub(p[0], p[2]).abs();

        perimeter = (a + b + c)/2 * 100;

        perimeter = Math.round(perimeter)/100.;

        double square;

        square = Math.pow(perimeter*(perimeter - a)*(perimeter - b)*(perimeter - c), 0.5);

        square = super.square();
        return square;
    }

    @Override
    public String toString()
    {
        String str =  "TGon\n{";
        for (int k=0; k < n-1; k++)
            str += p[k]+";";
        str += p[n-1]+"}";
        return str;
    }

}
