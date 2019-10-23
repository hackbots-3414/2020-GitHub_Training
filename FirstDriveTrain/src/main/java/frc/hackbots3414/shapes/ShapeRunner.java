/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.hackbots3414.shapes;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Way to test out Shape instances and other fun stuff
 */
public class ShapeRunner {

    public static void main(String[] args) {
        ArrayList<Shape> shapeList = createShapeList();
        for (int listIndex = 0; listIndex < shapeList.size(); listIndex ++) {
            printShape(shapeList.get(listIndex));
        }
        System.out.println("Hello Colin");
        System.out.println("2"+"2");
        System.out.println(2+2);
        System.out.println(2==2);
        System.out.println(2==3);
        System.out.println("2"=="2");
        System.out.println("2".equals(String.valueOf(2)));
        System.out.println("2"== String.valueOf(2));
    }

    /**
     * Create the list of shapes we want to show.  This is a good place to 
     * put shapes.add(createYourNameShape());, with a createYourNameShape() method
     * defined later in the class.
     * @return the shapeList
     */
    public static ArrayList<Shape> createShapeList() {
        ArrayList<Shape> shapes = new ArrayList<>();
        // TODO create all the shapes and add them to the list
        return shapes;
    }

    /**
     * Dump a shape to console
     * @param shape
     */
    public static void printShape(Shape shape) {
        if (shape == null) {
            System.out.println("Shape was null!");
            return;
        }
        System.out.println("------------------------------");
        System.out.println("Shape.toString(): " + shape);
        System.out.println("Shape.class: " + shape.getClass());
        System.out.print("Shape.getName(): " + shape.getName());
        System.out.print(", Shape.getPerimeter(): " + shape.getPerimeter());
        System.out.print(", Shape.getArea(): " + shape.getArea());
        DecimalFormat formatter = new DecimalFormat("#####.00");
        System.out.println(", formatted perimeter: " + formatter.format(shape.getPerimeter()));
        System.out.println("------------------------------");
        
    }
}
