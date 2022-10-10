package points;

public class Point2D extends Point {
    public Point2D() throws Exception {
        super(2);
    }

    public Point2D(double[] x) throws Exception {
        super(2, x);
    }

    public static Point2D rot(Point2D p, double phi) throws Exception
    {
        Point2D c = new Point2D(p.x);
        c.rot(phi);
        return c;
    }

    public Point2D rot(double phi)
    {
        double pointX = x[0], pointY = x[1];
        x[0] = pointX * Math.cos(phi) - pointY * Math.sin(phi);
        x[1] = pointX * Math.sin(phi) + pointY * Math.cos(phi);
        return this;
    }
}
