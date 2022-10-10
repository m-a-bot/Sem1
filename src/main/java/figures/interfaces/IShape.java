package figures.interfaces;

public interface IShape extends IMoveable {
    double square() throws Exception;

    double length() throws Exception;

    boolean cross(IShape i) throws Exception;
}
