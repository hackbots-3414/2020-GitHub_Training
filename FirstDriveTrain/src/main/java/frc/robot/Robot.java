/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  private AHRS navx = new AHRS(SPI.Port.kMXP);
  WPI_TalonSRX leftFront = new WPI_TalonSRX(2);
  WPI_TalonSRX leftBack = new WPI_TalonSRX(1);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(5);
  WPI_TalonSRX rightBack = new WPI_TalonSRX(4);

  Joystick left = new Joystick(0);
  Joystick right = new Joystick(1);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFront, rightBack);

  private final DifferentialDrive m_robotDrive
      = new DifferentialDrive(leftMotors, rightMotors);


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      m_robotDrive.stopMotor(); // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    System.out.println("---------------------------------");
    System.out.println("navx.getAngle(): "+navx.getAngle());
    System.out.println("navx.getRate(): "+navx.getRate());
    System.out.println("navx.getCompassHeading(): "+navx.getCompassHeading());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
