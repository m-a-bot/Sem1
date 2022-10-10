package figures.classes;

import figures.interfaces.*;
import points.*;

public class Circle implements IShape {
    protected Point2D p;
    protected double r;

    public Circle(Point2D p, double r) throws Exception
    {
        this.p = new Point2D(p.getX());
        if (r < 0)
            throw new Exception("R");
        this.r = r;
    }

    public Point2D getP()
    {
        return p;
    }

    public void setP(Point2D p) throws Exception
    {
        this.p.setX(p.getX());
    }

    public double getR()
    {
        return r;
    }

    public void setR(double r)
    {
        this.r = r;
    }

    @Override
    public IMoveable shift(Point2D a) throws Exception {
        this.p.add(a);
        return this;
    }

    @Override
    public IMoveable rot(double phi)
    {
        this.p.rot(phi);
        return this;
    }

    @Override
    public IMoveable symAxis(int i)
    {
        this.p.symAxis(i);
        return this;
    }

    @Override
    public double square()
    {
        return Math.PI * r * r;
    }

    @Override
    public double length()
    {
        return Math.PI * 2 * r;
    }

    @Override
    public boolean cross(IShape i) throws Exception
    {
        Circle shape = (Circle)i;

        Segment s = new Segment(p, shape.p);
        double d = s.length();
        return d <= r + shape.r && d >= Math.abs(r - shape.r);
    }

    @Override
    public String toString()
    {
        return "Circle\n(Centre:" + p + ";Radius:" + r+")";
    }
}
