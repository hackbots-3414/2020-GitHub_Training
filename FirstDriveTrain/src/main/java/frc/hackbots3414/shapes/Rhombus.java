/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.hackbots3414.shapes;

/**
 * Add your docs here.
 */

public class Rhombus implements Shape {
    int side;
    int diagonal1;
    int diagonal2;
    public Rhombus(int side, int diagonal1, int diagonal2){
        this.side = side;
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;

    }
    @Override
    public String getName() {
        return "Rhombus";
    }

    @Override
    public double getPerimeter() {
        return side*4;
    }

    @Override
    public double getArea() {
        return (diagonal1*diagonal2)/2;
    }
    
    
}