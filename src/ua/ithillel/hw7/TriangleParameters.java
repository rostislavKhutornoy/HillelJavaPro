package ua.ithillel.hw7;

public class TriangleParameters {
    public Triangle[] triangles;

    public TriangleParameters(Triangle[] triangles) {
        this.triangles = triangles;
    }

    public int amountTrianglesByType(String type) {
        int amount = 0;
        for (Triangle triangle : triangles) {
            if (triangle.typeEquinox().equals(type) ||
                    triangle.typeEquilateral().equals(type) ||
                    triangle.typeRectangular().equals(type) ||
                    triangle.typeArbitrary().equals(type)) {
                amount++;
            }
        }
        return amount;
    }

    public double findMinArea() {
        double minArea = triangles[0].area;
        for (Triangle triangle : triangles) {
            if (triangle.area < minArea) {
                minArea = triangle.area;
            }
        }
        return minArea;
    }

    public double findMaxArea() {
        double maxArea = triangles[0].area;
        for (Triangle triangle : triangles) {
            if (triangle.area > maxArea) {
                maxArea = triangle.area;
            }
        }
        return maxArea;
    }

    public double findMinPerimeter() {
        double minPerimeter = triangles[0].perimeter;
        for (Triangle triangle : triangles) {
            if (triangle.perimeter < minPerimeter) {
                minPerimeter = triangle.perimeter;
            }
        }
        return minPerimeter;
    }

    public double findMaxPerimeter() {
        double maxPerimeter = triangles[0].perimeter;
        for (Triangle triangle : triangles) {
            if (triangle.perimeter > maxPerimeter) {
                maxPerimeter = triangle.perimeter;
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
                    if (triangle.typeEquinox().equals(type) ||
                            triangle.typeEquilateral().equals(type) ||
                            triangle.typeRectangular().equals(type) ||
                            triangle.typeArbitrary().equals(type)) {
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
