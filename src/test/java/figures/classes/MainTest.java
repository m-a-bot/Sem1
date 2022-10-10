package figures.classes;

import org.junit.Assert;
import org.junit.Test;
import points.*;

public class MainTest {

    @Test
    public void test_circle() throws Exception
    {
        Point2D p = new Point2D(new double[]{1,1});
        Circle circle1 = new Circle(p, 1);
        double square = circle1.square();
        Assert.assertEquals(3.14, square, 0.1);

        double perimeter = circle1.length();
        Assert.assertEquals(6.28, perimeter, 0.1);
    }

    @Test
    public void test_segment() throws Exception
    {
        Point2D s = new Point2D(new double[]{0,2}),
                f = new Point2D(new double[]{1,1});
        Segment seg = new Segment(s,f);
        double square = seg.square();

        Assert.assertEquals(0, square, 0.1);
        double perimeter = seg.length();

        Assert.assertEquals(1.41, perimeter, 0.1);
    }

    @Test
    public void test_polyline() throws Exception
    {
        Point2D[] p = new Point2D[3];
        p[0] = new Point2D(new double[]{0,3});
        p[1] = new Point2D(new double[]{2,1});
        p[2] = new Point2D(new double[]{1,1});

        Polyline polyline = new Polyline(p);

        double square = polyline.square();

        Assert.assertEquals(0, square, 0.1);

        double length = polyline.length();

        Assert.assertEquals(3.8,length,0.1);
    }


    @Test
    public void test_ngon() throws Exception
    {
        Point2D[] p = new Point2D[5];
        p[0] = new Point2D(new double[]{1,1});
        p[1] = new Point2D(new double[]{2,3});
        p[2] = new Point2D(new double[]{4,6});
        p[3] = new Point2D(new double[]{3,0});
        p[4] = new Point2D(new double[]{1,0});
        NGon fig = new NGon(p);
        double square = fig.square();

        Assert.assertEquals(8.0,square , 0.1);

        Assert.assertEquals(14.88,fig.length(),0.1);
    }

    @Test
    public void test_tgon() throws Exception
    {
        Point2D[] p = new Point2D[3];
        p[0] = new Point2D(new double[]{1,5});
        p[1] = new Point2D(new double[]{2,10});
        p[2] = new Point2D(new double[]{3,8});
        TGon fig = new TGon(p);
        double square = fig.square();

        Assert.assertEquals(3.5, square, 0.1);

        Assert.assertEquals(10.92,fig.length(),0.1);
    }

    @Test
    public void test_qgon() throws Exception
    {
        Point2D[] p = new Point2D[4];
        p[0] = new Point2D(new double[]{5,7});
        p[1] = new Point2D(new double[]{9,8});
        p[2] = new Point2D(new double[]{10,3});
        p[3] = new Point2D(new double[]{2,2});
        QGon fig = new QGon(p);
        double square = fig.square();

        Assert.assertEquals(29, square, 0.1);

        Assert.assertEquals(23.1,fig.length(),0.1);
    }

    @Test
    public void test_rect() throws Exception
    {
        Point2D[] p = new Point2D[4];
        p[0] = new Point2D(new double[]{0,4});
        p[1] = new Point2D(new double[]{8,10});
        p[2] = new Point2D(new double[]{11,6});
        p[3] = new Point2D(new double[]{3,0});
        Rectangle fig = new Rectangle(p);
        double square = fig.square();

        Assert.assertEquals(50, square, 0.1);

        Assert.assertEquals(30,fig.length(),0.1);
    }

    @Test
    public void test_trapeze() throws Exception
    {
        Point2D[] p = new Point2D[4];
        p[0] = new Point2D(new double[]{-1,4});
        p[1] = new Point2D(new double[]{1,10});
        p[2] = new Point2D(new double[]{5,9});
        p[3] = new Point2D(new double[]{2,0});
        Trapeze fig = new Trapeze(p);
        double square = fig.square();

        Assert.assertEquals(32.5, square, 0.1);

        Assert.assertEquals(24.92,fig.length(),0.1);
    }
}
