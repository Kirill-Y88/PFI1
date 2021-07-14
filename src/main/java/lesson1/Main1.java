package lesson1;

import lesson1.figure.Figure;
import lesson1.figure.Triangle;

public class Main1 {
    public static void main(String[] args) {

        Person p1 = (new Person.BuilderPerson()).addFirstName("sfsf").addAge(15).build();

        System.out.println(p1.firstName);
        System.out.println(p1.lastName);

        Figure t = new Triangle(5, 5, 2);
        System.out.println(t.perimeter());
        System.out.println(t.area());

    }






}
