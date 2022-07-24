package Task_7;

/* Определить класс Треугольник на плоскости. Вычислить площадь и периметр
треугольника. Создать массив объектов и подсчитать
количество треугольников разного типа (равносторонний, равнобедренный,
прямоугольный, произвольный). Определить для каждой группы наибольший
и наименьший по площади и периметру объект.

Треугольник задается точками, которые тоже должны быть классами.
Точка задается двумя координатами(x,y) */

public class Main {
    public static void main(String[] args) {
        Triangle[] triangles = new Triangle[] {
                new Triangle(new Point(0, 0), new Point(0, 3), new Point(4, 0)),
                new Triangle(new Point(0, 0), new Point(0, 6), new Point(8, 0)),
                new Triangle(new Point(0, 0), new Point(6, 0), new Point(3, 6)),
                new Triangle(new Point(0, 0), new Point(8, 0), new Point(4, 8)),
                new Triangle(new Point(0, 0), new Point(5, 0), new Point(3, 5)),
                new Triangle(new Point(0, 0), new Point(8, 0), new Point(6, 8))
        };
        TriangleParameters triangleParameters = new TriangleParameters(triangles);
        triangleParameters.printEachTypeInfo();
    }
}
