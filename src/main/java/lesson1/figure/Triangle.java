package lesson1.figure;

public class Triangle extends Figure{
    private double sideA;
    private double sideB;
    private double sideC;
    private double p;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        p = (sideA+sideB+sideC)/2;
    }

    @Override
    public double perimeter() {
        return sideA+sideB+sideC;
    }

    @Override
    public double area() {
        return  Math.pow( p*(p-sideA)*(p-sideB)*(p-sideC), 0.5);
    }
}
