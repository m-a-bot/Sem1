package points;

public class Point3D extends Point{

    public Point3D() throws Exception {
        super(3);
    }

    public Point3D(double[] x) throws Exception {
        super(3, x);
    }

    public static Point3D cross_prod(Point3D p1, Point3D p2) throws Exception {
        Point3D r = new Point3D(p1.x);
        r.cross_prod(p2);
        return r;
    }

    public Point3D cross_prod(Point3D p)
    {
        double x1 = x[0], y1 = x[1], z1 = x[2];
        double x2 = p.x[0], y2 = p.x[1], z2 = p.x[2];

        x[0] = y1 * z2 - y2 * z1;
        x[1] = -x1 * z2 + x2 * z1;
        x[2] = x1 * y2 - x2 * y1;

        return this;
    }

    public static double mix_prod(Point3D p1, Point3D p2, Point3D p3) throws Exception {
        Point3D r = new Point3D(p1.x);
        double mp = r.mix_prod(p2, p3);
        return mp;
    }

    public double mix_prod(Point3D p1, Point3D p2)
    {
        double mix = 0;

        double x1 = p1.x[0], y1 = p1.x[1], z1 = p1.x[2];
        double x2 = p2.x[0], y2 = p2.x[1], z2 = p2.x[2];

        mix += x[0] * (y1 * z2 - y2 * z1);
        mix += -x[1] * (x1 * z2 - x2 * z1);
        mix += x[2] * (x1 * y2 - x2 * y1);

        return mix;
    }
}
