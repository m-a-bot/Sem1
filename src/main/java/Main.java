import figures.classes.*;
import figures.interfaces.*;
import points.Point2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<IShape> figures;
        figures = new ArrayList<IShape>();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of figures: ");

        int numberOfFigures;
        numberOfFigures = in.nextInt();

        for (int i = 0; i < numberOfFigures; i++) {
            System.out.println("Enter type of figure:");
            in.nextLine(); // костыль
            String typeOfFigure = in.nextLine();
            System.out.println(typeOfFigure);
            switch (typeOfFigure) {
                case "Segment":
                    System.out.println("Введите параметры: ");
                    Point2D s, f;

                    s = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    f = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});

                    //System.out.println(new Segment(s, f));
                    figures.add(new Segment(s, f));
                    break;

                case "Polyline":
                    System.out.println("Введите количество точек: ");

                    int n = in.nextInt();

                    Point2D[] points = new Point2D[n];

                    for (int p = 0; p < n; p++) {
                        System.out.println("Введите параметры: ");
                        points[p] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    }
                    figures.add(new Polyline(points));
                    break;

                case "Circle":
                    System.out.println("Введите параметры: ");
                    Point2D p = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    double r = in.nextDouble();
                    figures.add(new Circle(p, r));
                    break;

                case "NGon":
                    System.out.println("Введите n: ");
                    n = in.nextInt();
                    points = new Point2D[n];
                    for (int point_ngon = 0; point_ngon < n; point_ngon++) {
                        System.out.println("Введите параметры: ");
                        points[point_ngon] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    }
                    figures.add(new NGon(points));
                    break;

                case "TGon":
                    n = 3;
                    points = new Point2D[n];
                    for (int point_tgon = 0; point_tgon < n; point_tgon++) {
                        System.out.println("Введите параметры: ");
                        points[point_tgon] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    }
                    figures.add(new TGon(points));
                    break;

                case "QGon":
                    n = 4;
                    points = new Point2D[n];
                    for (int point_qgon = 0; point_qgon < n; point_qgon++) {
                        System.out.println("Введите параметры: ");
                        points[point_qgon] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    }
                    figures.add(new QGon(points));
                    break;

                case "Rectangle":
                    n = 4;
                    points = new Point2D[n];
                    for (int point_r = 0; point_r < n; point_r++) {
                        System.out.println("Введите параметры: ");
                        points[point_r] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    }
                    figures.add(new Rectangle(points));
                    break;

                case "Trapeze":
                    n = 4;
                    points = new Point2D[n];
                    for (int point_t = 0; point_t < n; point_t++) {
                        System.out.println("Введите параметры: ");
                        points[point_t] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    }
                    figures.add(new Trapeze(points));
                    break;
            }
        }

        double square, length;
        square = length = 0;
        for (IShape x : figures) {
            square += x.square();
            length += x.length();
        }
        System.out.println("Суммарная площадь всех фигур: " + square);
        System.out.println("Суммарная длина всех фигур: " + length);
        System.out.println("Средняя площадь по всем фигурам: " + square / numberOfFigures);


        for (int i = 0; i < numberOfFigures; i++) {
            IShape x = figures.get(i);
            IShape y = null;

            if (x.getClass().getSimpleName().equals("Segment")) {
                System.out.println("Segment. Введите параметры: ");
                Point2D s, f;
                s = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});

                f = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});

                y = new Segment(s, f);
            }
            if (x.getClass().getSimpleName().equals("Polyline")) {
                System.out.println("Polyline. Введите количество точек: ");
                int n = in.nextInt();
                Point2D[] _pointts = new Point2D[n];
                for (int k=0; k < n; k++)
                {
                    System.out.println("Segment. Введите параметры: ");
                    Point2D p;
                    p = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    _pointts[k] = p;
                }
                y = new Polyline(_pointts);
            }
            if (x.getClass().getSimpleName().equals("Circle")) {
                System.out.println("Circle: ");
                y = new Circle(new Point2D(new double[]{in.nextDouble(), in.nextDouble()}), in.nextDouble());
            }
            if (x.getClass().getSimpleName().equals("TGon"))
            {
                int n = 3;
                Point2D[] _pointts = new Point2D[n];
                for (int k=0; k < n; k++)
                {
                    System.out.println("TGon. Введите параметры: ");
                    Point2D p;
                    p = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    _pointts[k] = p;
                }
                y = new TGon(_pointts);
            }
            if (x.getClass().getSimpleName().equals("QGon"))
            {
                int n = 4;
                Point2D[] _pointts = new Point2D[n];
                for (int k=0; k < n; k++)
                {
                    System.out.println("QGon. Введите параметры: ");
                    Point2D p;
                    p = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    _pointts[k] = p;
                }
                y = new QGon(_pointts);
            }
            if (x.getClass().getSimpleName().equals("Rectangle"))
            {
                int n = 4;
                Point2D[] _pointts = new Point2D[n];
                for (int k=0; k < n; k++)
                {
                    System.out.println("Rectangle. Введите параметры: ");
                    Point2D p;
                    p = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    _pointts[k] = p;
                }
                y = new Rectangle(_pointts);
            }
            if (x.getClass().getSimpleName().equals("Trapeze"))
            {
                int n = 4;
                Point2D[] _pointts = new Point2D[n];
                for (int k=0; k < n; k++)
                {
                    System.out.println("Trapeze. Введите параметры: ");
                    Point2D p;
                    p = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    _pointts[k] = p;
                }
                y = new Trapeze(_pointts);
            }
            if (x.getClass().getSimpleName().equals("NGon")) {
                System.out.println("NGon. Введите количество точек: ");
                int n = in.nextInt();
                Point2D[] _pointts = new Point2D[n];
                for (int k=0; k < n; k++)
                {
                    System.out.println("NGon. Введите параметры: ");
                    Point2D p;
                    p = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                    _pointts[k] = p;
                }
                y = new NGon(_pointts);
            }


            if (x.cross(y))
                System.out.println("Пересекаются");
            else
                System.out.println("Не пересекаются");

            System.out.println("Введите тип движения: ");

            in.nextLine(); // костыль
            String typeOfMove = in.nextLine();

            if (Objects.equals(typeOfMove, "Shift"))
            {
                System.out.println("Enter vector of movement: ");
                if (y != null) {
                    y.shift(new Point2D(new double[]{in.nextDouble(), in.nextDouble()}));
                }
            }
            else if (Objects.equals(typeOfMove, "Rotate"))
            {
                if (y != null) {
                    y.rot(in.nextDouble());
                }
            }
            else if (Objects.equals(typeOfMove, "Symmetry"))
            {
                if (y != null) {
                    y.symAxis(in.nextInt());
                }
            }
            if (x.cross(y))
                System.out.println("Пересекаются после перемещения");
            else
                System.out.println("Не пересекаются после перемещения");
        }
    }
}
