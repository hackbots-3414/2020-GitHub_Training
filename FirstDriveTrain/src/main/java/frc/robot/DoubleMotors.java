/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * Add your docs here.
 */
public class DoubleMotors implements SpeedController  {
    Spark frontMotor = new Spark(1);
    Spark backmotor = new Spark(2);
    @Override
    public void pidWrite(double output) {
        frontMotor.pidWrite(output); 
        backmotor.pidWrite(output);
    }

    @Override
    public void set(double speed) {
        frontMotor.set(speed);
        backmotor.set(speed);
    }

    @Override
    public double get() {
        frontMotor.get();
        backmotor.get();
        return 0;
    }

    @Override
    public void setInverted(boolean isInverted) {
        frontMotor.setInverted(isInverted);
        backmotor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        frontMotor.getInverted();
        backmotor.getInverted();
        return false;
    }

    @Override
    public void disable() {
        frontMotor.disable();
        backmotor.disable();
    }

    @Override
    public void stopMotor() {
        frontMotor.stopMotor();
        backmotor.stopMotor();
    }


}
