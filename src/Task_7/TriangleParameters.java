package Task_7;

public class TriangleParameters {
    public Triangle[] triangles;

    public TriangleParameters(Triangle[] triangles) {
        this.triangles = triangles;
    }

    public int amountTrianglesByType(String type) {
        int amount = 0;
        for (Triangle triangle : triangles) {
            if (triangle.typeTriangle().equals(type)) {
                amount++;
            }
        }
        return amount;
    }

    public double findMinArea() {
        double minArea = triangles[0].findArea();
        for (Triangle triangle : triangles) {
            if (triangle.findArea() < minArea) {
                minArea = triangle.findArea();
            }
        }
        return minArea;
    }

    public double findMaxArea() {
        double maxArea = triangles[0].findArea();
        for (Triangle triangle : triangles) {
            if (triangle.findArea() > maxArea) {
                maxArea = triangle.findArea();
            }
        }
        return maxArea;
    }

    public double findMinPerimeter() {
        double minPerimeter = triangles[0].findPerimeter();
        for (Triangle triangle : triangles) {
            if (triangle.findPerimeter() < minPerimeter) {
                minPerimeter = triangle.findPerimeter();
            }
        }
        return minPerimeter;
    }

    public double findMaxPerimeter() {
        double maxPerimeter = triangles[0].findPerimeter();
        for (Triangle triangle : triangles) {
            if (triangle.findPerimeter() > maxPerimeter) {
                maxPerimeter = triangle.findPerimeter();
            }
        }
        return maxPerimeter;
    }

    private void printInfoByType(String type) {
        Triangle[] typeTriangles = new Triangle[amountTrianglesByType(type)];
        TriangleParameters triangleParameters = new TriangleParameters(typeTriangles);
        if (typeTriangles.length != 0) {
            for (int i = 0; i < typeTriangles.length; ) {
                for (Triangle triangle : triangles) {
                    if (triangle.typeTriangle().equals(type)) {
                        typeTriangles[i] = triangle;
                        i++;
                    }
                }
            }
            System.out.println(type + ": " + typeTriangles.length + ", min/max area: " +
                    triangleParameters.findMinArea() + "/" + triangleParameters.findMaxArea() + ", min/max perimeter: " +
                    triangleParameters.findMinPerimeter() + "/" + triangleParameters.findMaxPerimeter());
        } else {
            System.out.println("No triangles type: " + type);
        }
    }

    public void printEachTypeInfo() {
        String[] types = new String[] { "Equilateral", "Rectangular", "Equinox", "Arbitrary" };
        for (String type : types) {
            printInfoByType(type);
        }
    }
}
