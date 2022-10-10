package figures.classes;

import figures.OpenFigure;
import figures.interfaces.IMoveable;
import figures.interfaces.IPolyPoint;
import figures.interfaces.IShape;
import points.Point2D;

public class Polyline extends OpenFigure implements IPolyPoint {
    protected int n;

    protected Point2D[] p;

    public Polyline(Point2D[] p)
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
        this.p = p;
    }


    @Override
    public IMoveable shift(Point2D a) throws Exception
    {
        for (int k=0; k < n; k++)
        {
            p[k].add(a);
        }
        return this;
    }

    @Override
    public IMoveable rot(double phi)
    {
        for (int k=0; k < n; k++)
        {
            p[k].rot(phi);
        }
        return this;
    }

    @Override
    public IMoveable symAxis(int i)
    {
        for (int k=0; k < n; k++)
        {
            p[k].symAxis(i);
        }
        return this;
    }

    @Override
    public Point2D getP(int i)
    {
        return p[i];
    }

    @Override
    public void setP(Point2D p, int i)
    {
        this.p[i] = p;
    }

    @Override
    public double length() throws Exception
    {
        double length = 0;
        for (int k=1; k < n; k++)
        {
            length += new Segment(p[k-1], p[k]).length();
        }
        return length;
    }

    @Override
    public boolean cross(IShape i) throws Exception {
        Polyline shape = (Polyline)i;
        boolean is_cross = false;
        for (int k=1; k < n; k++)
        {
            for (int j = 1; j < shape.n; j++)
            {
                if (new Segment(p[k - 1], p[k]).cross(new Segment(shape.p[j - 1], shape.p[j])))
                {
                    System.out.println(1);

                    is_cross = true;
                }
            }
        }
        return is_cross;
    }

    @Override
    public String toString()
    {
        String str = "Polyline\n[";
        for (int i = 0; i < n-1; i++)
            str += p[i] + ";";
        str += p[n-1] + "]";
        return str;
    }
}
