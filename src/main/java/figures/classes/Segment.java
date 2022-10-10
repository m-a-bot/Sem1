package figures.classes;

import figures.OpenFigure;
import figures.interfaces.IShape;
import points.Point2D;

import java.util.Objects;

public class Segment extends OpenFigure {
    protected Point2D start;
    protected Point2D finish;

    public Segment(Point2D s, Point2D f) throws Exception {
        start = new Point2D(s.getX());
        finish = new Point2D(f.getX());
    }

    public Point2D getStart()
    {
        return start;
    }
    public void setStart(Point2D a) throws Exception {
        start.setX(a.getX());
    }

    public Point2D getFinish()
    {
        return finish;
    }
    public void setFinish(Point2D a) throws Exception
    {
        finish.setX(a.getX());
    }

    @Override
    public double length() throws Exception
    {
        double len = Point2D.sub(finish, start).abs();
        return len;
    }


    @Override
    public Segment shift(Point2D a) throws Exception
    {
        start.add(a);
        finish.add(a);
        return this;
    }

    @Override
    public Segment rot(double phi)
    {
        start.rot(phi);
        finish.rot(phi);
        return this;
    }

    @Override
    public Segment symAxis(int i)
    {
        start.symAxis(i);
        finish.symAxis(i);
        return this;
    }

    @Override
    public boolean cross(IShape i) throws Exception
    {
        Segment another = (Segment) i;

        double x0, x1, y0, y1;
        x0 = this.start.getX(0);
        y0 = this.start.getX(1);
        x1 = this.finish.getX(0);
        y1 = this.finish.getX(1);

        double _x0, _x1, _y0, _y1;
        _x0 = another.start.getX(0);
        _y0 = another.start.getX(1);
        _x1 = another.finish.getX(0);
        _y1 = another.finish.getX(1);

        boolean parallel1 = x1 - x0 == 0, parallel2 = _x1 - _x0 == 0;

        double x,y;
        if (parallel1 && parallel2)
        {
            double v = Math.max(x0, x1),
                    d = Math.min(x0, x1);

            double _v = Math.max(_x0, _x1),
                    _d = Math.min(_x0, _x1);

            return v >= _v && _v >= d || _v >= v && v >= _d;
        } else if (parallel1) {
            x = x1;
            double A1 = (_y1-_y0)/(_x1-_x0),
                    B1 = (_y0*_x1-_x0*_y1)/(_x1-_x0);
            y = x * A1 + B1;
        } else if (parallel2)
        {
            x = _x1;
            double A0 = (y1-y0)/(x1-x0),
                    B0 = (y0*x1-x0*y1)/(x1-x0);
            y = x * A0 + B0;
        } else
        {
            double A0 = (y1-y0)/(x1-x0),
                    B0 = (y0*x1-x0*y1)/(x1-x0),
            A1 = (_y1-_y0)/(_x1-_x0),
            B1 = (_y0*_x1-_x0*_y1)/(_x1-_x0);
            if (A0 - A1 == 0)
            {
                double v = Math.max(x0, x1),
                        d = Math.min(x0, x1);

                double _v = Math.max(_x0, _x1),
                        _d = Math.min(_x0, _x1);

                return B0 == B1 && ( v >= _v && _v >= d || _v >= v && v >= _d);
            }
            x = (B1 - B0)/(A0 - A1);
            y = x * A0 + B0;
        }

        Point2D tp = new Point2D(new double[]{x,y});
        Segment l1 = new Segment(start, tp),
                l2 = new Segment(tp, finish);

        Segment _l1 = new Segment(another.start, tp),
                _l2 = new Segment(tp, another.finish);
        return l1.length() + l2.length() <= length()
                && _l1.length() + _l2.length() <= another.length();
    }

    @Override
    public String toString()
    {
        return "Segment\n["+start + ";" + finish + "]";
    }
}