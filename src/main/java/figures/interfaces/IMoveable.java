package figures.interfaces;

import points.Point2D;

public interface IMoveable {
    IMoveable shift(Point2D a) throws Exception;

    IMoveable rot(double phi);

    IMoveable symAxis(int i);
}
