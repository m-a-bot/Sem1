package points;

public class Point {
    protected int dim;
    protected double[] x;

    public Point(int dim) throws Exception {
        if (dim < 1)
            throw new Exception("Error");
        this.dim = dim;
        this.x = new double[this.dim];
    }

    public Point(int dim, double[] x) throws Exception
    {
        if (dim < 1)
            throw new Exception("Error");
        if (dim != x.length)
            throw new Exception("Error");
        this.dim = dim;
        this.x = new double[this.dim];
        for (int i=0; i < this.dim; i++)
            this.x[i] = x[i];
    }

    public int getDim()
    {
        return dim;
    }

    public double[] getX()
    {
        return x;
    }

    public double getX(int i)
    {
        return x[i];
    }

    public void setX(double[] x) throws Exception
    {
        if (x.length != dim)
            throw new Exception("R");
        for (int i=0; i < dim; i++)
            this.x[i] = x[i];
    }

    public void setX(double x, int i)
    {
        this.x[i] = x;
    }

    public double abs()
    {
        double result = 0;
        for (double p: x)
        {
            result += p*p;
        }
        result = Math.pow(result, 0.5) * 1000;
        return Math.round(result)/1000.;
    }

    public static Point add(Point a, Point b) throws Exception {
        Point c = new Point(a.dim, a.x);
        c.add(b);
        return c;
    }

    public Point add(Point b) throws Exception
    {
        if (dim != b.dim)
            throw new Exception("R");
        for (int i=0; i < dim; i++)
            x[i] += b.x[i];
        return this;
    }

    public static Point sub(Point a, Point b) throws Exception {
        Point c = new Point(a.dim, a.x);
        c.sub(b);
        return c;
    }

    public Point sub(Point b) throws Exception
    {
        if (dim != b.dim)
            throw new Exception("R");
        for (int i=0; i < dim; i++)
            x[i] -= b.x[i];
        return this;
    }

    public static Point mult(Point a, double r) throws Exception
    {
        Point b = new Point(a.dim, a.x);
        b.mult(r);
        return b;
    }

    public Point mult(double r)
    {
        for (int i=0; i < dim; i++)
            x[i] *= r;
        return this;
    }

    public static double mult(Point a, Point b) throws Exception {
        Point c = new Point(a.dim, a.x);
        double res = c.mult(b);
        return res;
    }

    public double mult(Point b) throws Exception
    {
        if (dim != b.dim)
            throw new Exception("r");
        double scalarProduct;
        scalarProduct = 0;
        for (int i=0; i < dim; i++)
            scalarProduct += x[i] * b.x[i];
        return scalarProduct;
    }

    public static Point symAxis(Point a, int i) throws Exception {
        Point b =  new Point(a.dim, a.x);
        b.symAxis(i);
        return b;
    }

    public Point symAxis(int i)
    {
        if (i == 0)
            setX(-x[1], 1);
        else if (i == 1)
            setX(-x[0], 0);
        else
            setX(-x[i], i);
        return this;
    }

    @Override
    public String toString()
    {
        String info = "(";
        for (int k=0; k < dim - 1; k++)
        {
            info += x[k] + ",";
        }
        info += x[dim-1] + ")";
        return info;
    }

}
