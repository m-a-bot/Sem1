package figures.classes;

import figures.interfaces.*;
import points.Point2D;

public class NGon implements IShape, IPolyPoint {
    protected int n;

    protected Point2D[] p;

    public NGon(Point2D[] p)
    {
        n = p.length;
        this.p = new Point2D[n];
        System.arraycopy(p, 0, this.p, 0, n);
    }

    public int getN()
    {
        return n;
    }

    public Point2D[] getP()
    {
        return p;
    }

    public void setP(Point2D[] p)
    {
        n = p.length;
        this.p = p;
    }

    @Override
    public IMoveable shift(Point2D a) throws Exception
    {
        for (int i=0; i<n; i++)
        {
            p[i].add(a);
        }
        return this;
    }

    @Override
    public IMoveable rot(double phi) {
        for (int i=0; i<n; i++)
        {
            p[i].rot(phi);
        }
        return this;
    }

    @Override
    public IMoveable symAxis(int i)
    {
        for (int k=0; k<n; k++)
        {
            p[k].symAxis(i);
        }
        return this;
    }

    @Override
    public Point2D getP(int i) {
        return p[i];
    }

    @Override
    public void setP(Point2D p, int i)
    {
        this.p[i] = p;
    }

    @Override
    public double square() throws Exception {
        double S=0;
        double x1, y1, x2, y2;

        for(int i=1; i<n; i++)
        {
            x1 = p[i-1].getX(0);
            y1 = p[i-1].getX(1);
            x2 = p[i].getX(0);
            y2 = p[i].getX(1);
            S += x1 * y2 - x2 * y1;
        }
        x1 = p[0].getX(0);
        y1 = p[0].getX(1);
        x2 = p[n-1].getX(0);
        y2 = p[n-1].getX(1);
        S += x2 * y1 - x1 * y2;

        double result = Math.abs(S/2) * 100;
        return Math.round(result)/100.;
    }

    @Override
    public double length() throws Exception
    {
        double length = 0;
        for (int k=1; k < n; k++)
        {
            length += new Segment(p[k-1], p[k]).length();
        }
        length += new Segment(p[n-1], p[0]).length();
        return length;
    }

    @Override
    public boolean cross(IShape i) throws Exception
    {
        NGon shape = (NGon)i;

        for (int k=1; k < n; k++)
        {
            for (int j = 1; j < shape.n; j++)
            {
                if (new Segment(p[k - 1], p[k]).cross(new Segment(shape.p[j - 1], shape.p[j]))) {
                    System.out.println(k-1);
                    System.out.println(j-1);
                    return true;
                }
            }
            if (new Segment(p[k-1], p[k]).cross(new Segment(shape.p[shape.n-1], shape.p[0]))) {
                System.out.println("k");
                return true;
            }
        }

        for (int j = 1; j < shape.n; j++)
        {
            if (new Segment(p[n - 1], p[0]).cross(new Segment(shape.p[j - 1], shape.p[j]))) {
                System.out.println("k1");
                return true;
            }
        }

        return new Segment(p[n - 1], p[0]).cross(new Segment(shape.p[shape.n - 1], shape.p[0]));
//        if (new Segment(p[n-1], p[0]).cross(new Segment(shape.p[shape.n-1], shape.p[0])))
//            return true;
//        return false;
    }

    @Override
    public String toString()
    {
        String str =  "NGon\n{";
        for (int k=0; k < n-1; k++)
            str += p[k]+";";
        str += p[n-1]+"}";
        return str;
    }
}
