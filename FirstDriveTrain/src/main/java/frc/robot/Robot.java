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
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.RobotDrive;
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
public class Robot extends TimedRobot implements PIDOutput {

  
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  private AHRS navx = new AHRS(SPI.Port.kMXP);
  Joystick left = new Joystick(0);
  Joystick right = new Joystick(0);
  WPI_TalonSRX leftFront = new WPI_TalonSRX(2);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(4);
  WPI_TalonSRX leftBack = new WPI_TalonSRX(1);
  WPI_TalonSRX rightBack = new WPI_TalonSRX(5);
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFront, rightBack);
  AHRS ahrs = new AHRS(SPI.Port.kMXP);
  boolean rotateToAngleRate;


  private final DifferentialDrive m_robotDrive
      = new DifferentialDrive(leftMotors, rightMotors);

      static final double KP = 0.03;
      static final double KI = 0.00;
      static final double KD = 0.00;
      static final double KF = 0.00;
      static final double kToleranceDegrees = 2.0f;



      
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
      m_robotDrive.stopMotor(); // stop r+obot
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
    System.out.println("=============================");
    System.out.println("navx.getCompassHeading(): " + navx.getCompassHeading());
    System.out.println("navx.getBoardYawAxis" + navx.getBoardYawAxis());
    System.out.println("navx.getQuaternionW" + navx.getQuaternionW());
    System.out.println("navx.getQuaternionX" +navx.getQuaternionX());
    System.out.println("navx.getQuaternionY" +navx.getQuaternionY());
    System.out.println("navx.getQuaternionZ" + navx.getQuaternionZ());
    System.out.println("=============================");
    PIDController turnController = new PIDController(KP, KI, KD, KF,ahrs,this);
    turnController.setInputRange(-180.0f,180.0f);
    turnController.setOutputRange(-.50,.50);
    turnController.setAbsoluteTolerance(kToleranceDegrees);
    turnController.setContinuous(true);
    if (m_stick.getRawButton(1)){
      ahrs.reset();
    }
    if (m_stick.getRawButton(2)){
      turnController.setSetpoint(0.0f);
      rotateToAngleRate = true;
    }
    else if (m_stick.getRawButton(3)) {
      turnController.setSetpoint(90f);
    }
    else if(m_stick.getRawButton(4)){
      turnController.setSetpoint(180f);
      rotateToAngleRate = true;
    }
    else if(m_stick.getRawButton(5)){
      turnController.setSetpoint(-90f);
    }
    double CurrentRotationRate;
    if (rotateToAngleRate){
      turnController.enable();
      CurrentRotationRate = rotateToAngleRate;
    }
    else{
      turnController.disable();
      CurrentRotationRate = m_stick.getTwist();
    }
    m_robotDrive.arcadeDrive(0,.50);
  }

    



    public void robotTurn(){
       double startingAngle = ahrs.getAngle();
       double endingAngle = startingAngle+90;
       double endingAngle2 =  startingAngle+180;
    }

  @Override
  public void pidWrite(double output) {
    rotateToAngleRate = output;

  }

    
    

  }



 