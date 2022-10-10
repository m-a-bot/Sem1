package figures.classes;

import org.junit.Assert;
import org.junit.Test;
import points.*;

public class CrossTest {
    @Test
    public void test_circle() throws Exception
    {
        Point2D p1 = new Point2D(new double[]{1,1}),
        p2 = new Point2D(new double[]{0,2});
        Circle circle1 = new Circle(p1, 1),
        circle2 = new Circle(p2, 2);
        boolean v = circle1.cross(circle2);
        Assert.assertTrue(v);
        circle2.shift(new Point2D(new double[]{3,3}));
        v = circle1.cross(circle2);
        Assert.assertFalse(v);
    }

    @Test
    public void test_segment1() throws Exception
    {
        Point2D s = new Point2D(new double[]{0,2}),
                f = new Point2D(new double[]{1,1});
        Segment seg1 = new Segment(s,f),
        seg2 = new Segment(new Point2D(new double[]{0,1}), new Point2D(new double[]{2,3}));
        boolean v = seg1.cross(seg2);
        Assert.assertTrue(v);
        seg2.rot(1);
        v = seg1.cross(seg2);
        Assert.assertFalse(v);
    }

    @Test
    public void test_segment2() throws Exception
    {
        Point2D s = new Point2D(new double[]{0,2}),
                f = new Point2D(new double[]{2,0});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{-1,1}), new Point2D(new double[]{3,1}));
        boolean v = seg1.cross(seg2);
        Assert.assertTrue(v);
    }

    @Test
    public void test_segment3() throws Exception
    {
        Point2D s = new Point2D(new double[]{0,2}),
                f = new Point2D(new double[]{2,0});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{1,0}), new Point2D(new double[]{1,2}));
        boolean v = seg1.cross(seg2);
        Assert.assertTrue(v);
    }

    @Test
    public void test_segment4() throws Exception
    {
        Point2D s = new Point2D(new double[]{1,0}),
                f = new Point2D(new double[]{1,2});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{0,2}), new Point2D(new double[]{2,0}));
        boolean v = seg1.cross(seg2);
        Assert.assertTrue(v);
    }

    @Test
    public void test_segment5() throws Exception
    {
        Point2D s = new Point2D(new double[]{1,0}),
                f = new Point2D(new double[]{1,2});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{-1,2}), new Point2D(new double[]{1,4}));
        boolean v = seg1.cross(seg2);
        Assert.assertFalse(v);
    }

    @Test
    public void test_segment6() throws Exception
    {
        Point2D s = new Point2D(new double[]{1,1}),
                f = new Point2D(new double[]{3,3});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{2,2}), new Point2D(new double[]{4,4}));
        boolean v = seg1.cross(seg2);
        Assert.assertTrue(v);
    }

    @Test
    public void test_segment7() throws Exception
    {
        Point2D s = new Point2D(new double[]{1,1}),
                f = new Point2D(new double[]{3,3});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{4,2}), new Point2D(new double[]{6,4}));
        boolean v = seg1.cross(seg2);
        Assert.assertFalse(v);
    }

    @Test
    public void test_segment8() throws Exception
    {
        Point2D s = new Point2D(new double[]{1,1}),
                f = new Point2D(new double[]{3,3});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{4,4}), new Point2D(new double[]{2,2}));
        boolean v = seg1.cross(seg2);
        Assert.assertTrue(v);
    }

    @Test
    public void test_segment9() throws Exception
    {
        Point2D s = new Point2D(new double[]{1,1}),
                f = new Point2D(new double[]{3,3});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{6,4}), new Point2D(new double[]{4,2}));
        boolean v = seg1.cross(seg2);
        Assert.assertFalse(v);
    }

    @Test
    public void test_segment10() throws Exception
    {
        Point2D s = new Point2D(new double[]{1,0}),
                f = new Point2D(new double[]{1,1});
        Segment seg1 = new Segment(s,f),
                seg2 = new Segment(new Point2D(new double[]{5,-1}), new Point2D(new double[]{5,2}));
        boolean v = seg1.cross(seg2);
        Assert.assertFalse(v);
    }

    @Test
    public void test_polyline() throws Exception
    {
        Point2D[] p = new Point2D[3];
        p[0] = new Point2D(new double[]{0,3});
        p[1] = new Point2D(new double[]{2,1});
        p[2] = new Point2D(new double[]{1,1});
        Polyline polyline1 = new Polyline(p);
        p = new Point2D[4];
        p[0] = new Point2D(new double[]{0,1});
        p[1] = new Point2D(new double[]{-1,2});
        p[2] = new Point2D(new double[]{2,3});
        p[3] = new Point2D(new double[]{1,0});
        Polyline polyline2 = new Polyline(p);
        boolean v = polyline1.cross(polyline2);
        Assert.assertTrue(v);
        polyline2.symAxis(0);
        v = polyline1.cross(polyline2);
        Assert.assertFalse(v);
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

        p = new Point2D[6];
        p[0] = new Point2D(new double[]{5,2});
        p[1] = new Point2D(new double[]{8,3});
        p[2] = new Point2D(new double[]{9,1});
        p[3] = new Point2D(new double[]{8,-2});
        p[4] = new Point2D(new double[]{6,-2});
        p[5] = new Point2D(new double[]{5,-1});
        NGon fig1 = new NGon(p);
        boolean v = fig.cross(fig1);
        Assert.assertFalse(v);

        fig1.shift(new Point2D(new double[]{-2,1}));
        v = fig.cross(fig1);
        Assert.assertTrue(v);
    }

    @Test
    public void test_tgon() throws Exception
    {
        Point2D[] p = new Point2D[3];
        p[0] = new Point2D(new double[]{1,5});
        p[1] = new Point2D(new double[]{2,10});
        p[2] = new Point2D(new double[]{3,8});
        TGon fig = new TGon(p);

        p = new Point2D[3];
        p[0] = new Point2D(new double[]{1,2});
        p[1] = new Point2D(new double[]{5,1});
        p[2] = new Point2D(new double[]{5,5});
        TGon fig1 = new TGon(p);

        boolean v = fig.cross(fig1);
        Assert.assertFalse(v);

        fig1.rot(0.6);
        v = fig.cross(fig1);
        Assert.assertTrue(v);
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

        p = new Point2D[4];
        p[0] = new Point2D(new double[]{-1,8});
        p[1] = new Point2D(new double[]{2,6});
        p[2] = new Point2D(new double[]{-2,3});
        p[3] = new Point2D(new double[]{-4,5});

        QGon fig1 = new QGon(p);
        Assert.assertFalse(fig.cross(fig1));

        fig1.symAxis(1);
        Assert.assertTrue(fig.cross(fig1));
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

        p = new Point2D[4];
        p[0] = new Point2D(new double[]{2,10});
        p[1] = new Point2D(new double[]{6,9});
        p[2] = new Point2D(new double[]{5,5});
        p[3] = new Point2D(new double[]{1,6});
        Rectangle fig1 = new Rectangle(p);

        Assert.assertTrue(fig.cross(fig1));
        fig1.shift(new Point2D(new double[]{3,-2}));

        Assert.assertTrue(fig.cross(fig1));
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

        p = new Point2D[4];
        p[0] = new Point2D(new double[]{6,0});
        p[1] = new Point2D(new double[]{4,3});
        p[2] = new Point2D(new double[]{6,6});
        p[3] = new Point2D(new double[]{9,1.5});
        Trapeze fig1 = new Trapeze(p);
        Assert.assertFalse(fig.cross(fig1));

        fig1.rot(1.9);

        Assert.assertFalse(fig.cross(fig1));
    }

}

