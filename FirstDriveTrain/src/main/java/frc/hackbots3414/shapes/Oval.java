/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.hackbots3414.shapes;

/**
 * Implementation of an Oval for Shape
 */
public class Oval implements Shape {
    private double majorDiameter = 0;
    private double minorDiameter = 0;

    /**
     * Recommended constructor (often abbreviated by c'tor)
     * @param majorDiameter
     * @param minorDiameter
     */
    public Oval(double majorDiameter, double minorDiameter) {
        this.majorDiameter = majorDiameter;
        this.minorDiameter = minorDiameter;
    }

    public double getMajorDiameter() {
        return majorDiameter;
    }

    /**
     * @param majorDiameter the majorDiameter to set
     */
    public void setMajorDiameter(double majorDiameter) {
        this.majorDiameter = majorDiameter;
    }

    /**
     * @return the minorDiameter
     */
    public double getMinorDiameter() {
        return minorDiameter;
    }

    /**
     * @param minorDiameter the minorDiameter to set
     */
    public void setMinorDiameter(double minorDiameter) {
        this.minorDiameter = minorDiameter;
    }
    
    @Override
    public String getName() {
        return "Oval";
    }

    @Override
    public double getPerimeter() {
        // from https://www.mathsisfun.com/geometry/ellipse-perimeter.html, approximation 2, by Ramanujan
        return Math.PI * (3 * (majorDiameter + minorDiameter) - Math.sqrt((3 * majorDiameter + minorDiameter) * (majorDiameter + 3 * minorDiameter)));
    }

    @Override
    public double getArea() {
        // from https://www.wikihow.com/Calculate-the-Area-of-an-Ellipse
        return majorDiameter * minorDiameter * Math.PI;
    }
}
