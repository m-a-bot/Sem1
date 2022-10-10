package figures.classes;

import points.Point2D;

public class Trapeze extends QGon{
    public Trapeze(Point2D[] p)
    {
        super(p);
    }

    @Override
    public double square() throws Exception
    {
        TGon t1, t2;
        t1 = new TGon(new Point2D[] {p[0], p[1], p[2]});
        t2 = new TGon(new Point2D[] {p[1], p[2], p[3]});
        double square = t1.square() + t2.square();
        square = super.square();
        return square;
    }

    @Override
    public String toString()
    {
        String str =  "Trapeze\n{";
        for (int k=0; k < n-1; k++)
            str += p[k]+";";
        str += p[n-1]+"}";

        return str;
    }
}
