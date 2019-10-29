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
public class Parallelogram implements Shape {
    private int leftLength = 0; 
    private int rightLength = 0;
    private int topLength = 0;
    private int bottomLength = 0;

    public Parallelogram(int leftLength, int rightLength, int topLength, int bottomLength){
        this.leftLength = leftLength;
        this.rightLength = rightLength;
        this.topLength = topLength;
        this.bottomLength = bottomLength;
    }
    
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        return (leftLength + rightLength + topLength + bottomLength);
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return 0;
    }
}
