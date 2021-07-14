package lesson1.figure;

public class Circle extends Figure{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2*3.14*radius;
    }

    @Override
    public double area() {
        return 3.14*radius*radius;
    }
}
