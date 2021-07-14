package lesson1.figure;

public class Square extends Figure{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return side*4;
    }

    @Override
    public double area() {
        return side*side;
    }
}
