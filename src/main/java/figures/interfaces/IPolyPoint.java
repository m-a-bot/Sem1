package figures.interfaces;

import points.Point2D;

public interface IPolyPoint extends IShape {
    Point2D getP(int i);

    void setP(Point2D p, int i);
}