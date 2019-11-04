package frc.hackbots3414.shapes;

public interface Shape {

    /**
     * @return the name of the shape
     */
    String getName();
    
    /**
     * @return the perimeter (or circumference) of the shape
     */
    double getPerimeter();

    /**
     * @return the area of the shape
     */
    double getArea();
}