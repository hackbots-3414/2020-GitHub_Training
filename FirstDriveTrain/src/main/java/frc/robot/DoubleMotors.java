/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * Add your docs here.
 */
public class DoubleMotors implements SpeedController {
    Spark frontSpark = null;
    Spark backSpark = null;

    public DoubleMotors(int frontAddress, int backAddress){
        frontSpark = new Spark(frontAddress);
        backSpark = new Spark(backAddress);
    }
    @Override
    public void pidWrite(double output) {
        frontSpark.pidWrite(output);
        backSpark.pidWrite(output);
    }

    @Override
    public void set(double speed) {
        frontSpark.set(speed);
        backSpark.set(speed);
    }

    @Override
    public double get() {
        frontSpark.get();
        backSpark.get();
        return 0;
    }

    @Override
    public void setInverted(boolean isInverted) {
        frontSpark.setInverted(isInverted);
        backSpark.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        frontSpark.getInverted();
        backSpark.getInverted();
        return false;
    }

    @Override
    public void disable() {
        frontSpark.disable();
        backSpark.disable();
    }

    @Override
    public void stopMotor() {
        frontSpark.stopMotor();
        backSpark.stopMotor();
    }
}
