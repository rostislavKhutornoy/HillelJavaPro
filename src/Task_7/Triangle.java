package Task_7;

public class Triangle {
    public Point a;
    public Point b;
    public Point c;
    private final double ab;
    private final double bc;
    private final double ac;
    public final double perimeter;
    public final double area;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.ab = findSideLength(this.a, this.b);
        this.bc = findSideLength(this.b, this.c);
        this.ac = findSideLength(this.a, this.c);
        this.perimeter = findPerimeter();
        this.area = findArea();
    }

    public double findSideLength(Point first, Point second) {
        Point third = new Point(0, 0);
        third.x = second.x - first.x;
        third.y = second.y - first.y;
        return Math.sqrt(Math.pow(third.x, 2) + Math.pow(third.y, 2));
    }

    public String typeEquilateral() {
        if (ab == bc && ab == ac) {
            return "Equilateral"; //Равностроронний
        }
        return "Not equilateral";
    }

    public String typeRectangular() {
        if ((Math.round(ab * ab) == bc * bc + ac * ac) ||
                (Math.round(bc * bc) == ab * ab + ac * ac) ||
                (Math.round(ac * ac) == ab * ab + bc * bc)) {
            return "Rectangular"; //Прямоугольный
        }
        return "Not rectangular";
    }

    public String typeEquinox() {
        if (ab == bc || ab == ac || bc == ac) {
            return "Equinox"; //Равнобедренный
        }
        return "Not equinox";
    }

    public String typeArbitrary() {
        if (typeEquilateral().equals("Not equilateral") &&
                typeRectangular().equals("Not rectangular") &&
                typeEquinox().equals("Not equinox")) {
            return "Arbitrary";
        }
        return "Not arbitrary";
    }

    public double findPerimeter() {
        return ab + bc + ac;
    }

    public double findArea() {
        double p = findPerimeter() / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
    }
}
